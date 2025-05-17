package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.EventoAdverso;

@Repository
public class EventoAdversoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EventoAdverso> mostrarTodo() {
        String sql = "SELECT * FROM evento_adverso";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new EventoAdverso(
                rs.getLong("id_evento"),
                rs.getTimestamp("fecha_hora_evento").toLocalDateTime(),
                rs.getString("tipo_evento"),
                rs.getString("gravedad"),
                rs.getString("ubicacion"),
                rs.getString("estado"),
                rs.getString("acciones_tomadas"),
                rs.getLong("id_paciente")
        ));
    }

    public EventoAdverso mostrarPorId(Long id_evento) {
        String sql = "SELECT * FROM evento_adverso WHERE id_evento = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_evento }, (rs, rowNum) -> new EventoAdverso(
                rs.getLong("id_evento"),
                rs.getTimestamp("fecha_hora_evento").toLocalDateTime(),
                rs.getString("tipo_evento"),
                rs.getString("gravedad"),
                rs.getString("ubicacion"),
                rs.getString("estado"),
                rs.getString("acciones_tomadas"),
                rs.getLong("id_paciente")
        ));
    }

    public boolean guardar(EventoAdverso evento) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_evento), 0) + 1 FROM evento_adverso", Long.class);

            String sql = "INSERT INTO evento_adverso (id_evento, fecha_hora_evento, tipo_evento, gravedad, ubicacion, estado, acciones_tomadas, id_paciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    Timestamp.valueOf(evento.getFecha_hora_evento()),
                    evento.getTipo_evento(),
                    evento.getGravedad(),
                    evento.getUbicacion(),
                    evento.getEstado(),
                    evento.getAcciones_tomadas(),
                    evento.getId_paciente());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(EventoAdverso evento) {
        try {
            String sql = "UPDATE evento_adverso SET fecha_hora_evento = ?, tipo_evento = ?, gravedad = ?, ubicacion = ?, estado = ?, acciones_tomadas = ?, id_paciente = ? WHERE id_evento = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    Timestamp.valueOf(evento.getFecha_hora_evento()),
                    evento.getTipo_evento(),
                    evento.getGravedad(),
                    evento.getUbicacion(),
                    evento.getEstado(),
                    evento.getAcciones_tomadas(),
                    evento.getId_paciente(),
                    evento.getId_evento());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM evento_adverso WHERE id_evento = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
