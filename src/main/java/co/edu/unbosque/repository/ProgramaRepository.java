package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Programa;

@Repository
public class ProgramaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Programa> mostrarTodo() {
        String sql = "SELECT * FROM programa";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Programa(
                rs.getLong("id_programa"),
                rs.getString("nombre"),
                rs.getString("institucion"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_fin").toLocalDateTime(),
                rs.getString("estado")
        ));
    }

    public Programa mostrarPorId(Long id_programa) {
        String sql = "SELECT * FROM programa WHERE id_programa = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_programa}, (rs, rowNum) -> new Programa(
                rs.getLong("id_programa"),
                rs.getString("nombre"),
                rs.getString("institucion"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_fin").toLocalDateTime(),
                rs.getString("estado")
        ));
    }

    public boolean guardar(Programa programa) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_programa), 0) + 1 FROM programa", Long.class);

            String sql = "INSERT INTO programa (id_programa, nombre, institucion, fecha_hora_inicio, fecha_hora_fin, estado) VALUES (?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    programa.getNombre(),
                    programa.getInstitucion(),
                    Timestamp.valueOf(programa.getFecha_hora_inicio()),
                    Timestamp.valueOf(programa.getFecha_hora_fin()),
                    programa.getEstado());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Programa programa) {
        try {
            String sql = "UPDATE programa SET nombre = ?, institucion = ?, fecha_hora_inicio = ?, fecha_hora_fin = ?, estado = ? WHERE id_programa = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    programa.getNombre(),
                    programa.getInstitucion(),
                    Timestamp.valueOf(programa.getFecha_hora_inicio()),
                    Timestamp.valueOf(programa.getFecha_hora_fin()),
                    programa.getEstado(),
                    programa.getId_programa());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM programa WHERE id_programa = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
