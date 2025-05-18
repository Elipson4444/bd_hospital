package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Prescripcion;

@Repository
public class PrescripcionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Prescripcion> mostrarTodo() {
        String sql = "SELECT * FROM prescripcion";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Prescripcion(
                rs.getInt("id_prescripcion"),
                rs.getLong("id_consulta"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("indicaciones_generales")
        ));
    }

    public Prescripcion mostrarPorId(int id_prescripcion) {
        String sql = "SELECT * FROM prescripcion WHERE id_prescripcion = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_prescripcion }, (rs, rowNum) -> new Prescripcion(
                rs.getInt("id_prescripcion"),
                rs.getLong("id_consulta"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("indicaciones_generales")
        ));
    }

    public boolean guardar(Prescripcion prescripcion) {
        try {
            int nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_prescripcion), 0) + 1 FROM prescripcion", Integer.class);

            String sql = "INSERT INTO prescripcion (id_prescripcion, id_consulta, fecha_hora, indicaciones_generales) " +
                         "VALUES (?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    prescripcion.getId_consulta(),
                    Timestamp.valueOf(prescripcion.getFecha_hora()),
                    prescripcion.getIndicaciones_generales());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Prescripcion prescripcion) {
        try {
            String sql = "UPDATE prescripcion SET id_consulta = ?, fecha_hora = ?, indicaciones_generales = ? " +
                         "WHERE id_prescripcion = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    prescripcion.getId_consulta(),
                    Timestamp.valueOf(prescripcion.getFecha_hora()),
                    prescripcion.getIndicaciones_generales(),
                    prescripcion.getId_prescripcion());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id_prescripcion) {
        try {
            String sql = "DELETE FROM prescripcion WHERE id_prescripcion = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_prescripcion);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
