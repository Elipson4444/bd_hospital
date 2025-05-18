package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Reclamo;

@Repository
public class ReclamoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Reclamo> mostrarTodo() {
        String sql = "SELECT * FROM reclamo";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Reclamo(
                rs.getInt("id_reclamo"),
                rs.getTimestamp("fecha_hora_reclamo").toLocalDateTime(),
                rs.getString("descripcion"),
                rs.getString("area_responsable"),
                rs.getString("estado"),
                rs.getString("tipo"),
                rs.getInt("id_paciente")
        ));
    }

    public Reclamo mostrarPorId(int id_reclamo) {
        String sql = "SELECT * FROM reclamo WHERE id_reclamo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_reclamo }, (rs, rowNum) -> new Reclamo(
                rs.getInt("id_reclamo"),
                rs.getTimestamp("fecha_hora_reclamo").toLocalDateTime(),
                rs.getString("descripcion"),
                rs.getString("area_responsable"),
                rs.getString("estado"),
                rs.getString("tipo"),
                rs.getInt("id_paciente")
        ));
    }

    public boolean guardar(Reclamo reclamo) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_reclamo), 0) + 1 FROM reclamo", Integer.class);
            
            String sql = "INSERT INTO reclamo (id_reclamo, fecha_hora_reclamo, descripcion, area_responsable, estado, tipo, id_paciente) VALUES (?, ?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql, 
                    nextId,
                    Timestamp.valueOf(reclamo.getFecha_hora_reclamo()),
                    reclamo.getDescripcion(),
                    reclamo.getArea_responsable(),
                    reclamo.getEstado(),
                    reclamo.getTipo(),
                    reclamo.getId_paciente());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Reclamo reclamo) {
        try {
            String sql = "UPDATE reclamo SET fecha_hora_reclamo = ?, descripcion = ?, area_responsable = ?, estado = ?, tipo = ?, id_paciente = ? WHERE id_reclamo = ?";
            int rowsAffected = jdbcTemplate.update(sql, 
                    Timestamp.valueOf(reclamo.getFecha_hora_reclamo()),
                    reclamo.getDescripcion(),
                    reclamo.getArea_responsable(),
                    reclamo.getEstado(),
                    reclamo.getTipo(),
                    reclamo.getId_paciente(),
                    reclamo.getId_reclamo());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM reclamo WHERE id_reclamo = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
