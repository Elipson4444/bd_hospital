package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Urgencia;

@Repository
public class UrgenciaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Urgencia> mostrarTodo() {
        String sql = "SELECT * FROM urgencia";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Urgencia(
                rs.getLong("id_urgencia"),
                rs.getLong("id_paciencia"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("acciones_realizadas"),
                rs.getString("resultado")
        ));
    }

    public Urgencia mostrarPorId(Long id_urgencia) {  
        String sql = "SELECT * FROM urgencia WHERE id_urgencia = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_urgencia }, (rs, rowNum) -> new Urgencia(
                rs.getLong("id_urgencia"),
                rs.getLong("id_paciencia"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("acciones_realizadas"),
                rs.getString("resultado")
        ));
    }

    public boolean guardar(Urgencia urgencia) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_urgencia), 0) + 1 FROM urgencia", Long.class);
            
            String sql = "INSERT INTO urgencia (id_urgencia, id_paciencia, fecha_hora, motivo, acciones_realizadas, resultado) VALUES (?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql, 
                    nextId,
                    urgencia.getId_paciencia(),
                    Timestamp.valueOf(urgencia.getFecha_hora()),
                    urgencia.getMotivo(),
                    urgencia.getAcciones_realizadas(),
                    urgencia.getResultado());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Urgencia urgencia) {
        try {
            String sql = "UPDATE urgencia SET id_paciencia = ?, fecha_hora = ?, motivo = ?, acciones_realizadas = ?, resultado = ? WHERE id_urgencia = ?";
            int rowsAffected = jdbcTemplate.update(sql, 
                    urgencia.getId_paciencia(),
                    Timestamp.valueOf(urgencia.getFecha_hora()),
                    urgencia.getMotivo(),
                    urgencia.getAcciones_realizadas(),
                    urgencia.getResultado(),
                    urgencia.getId_urgencia());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM urgencia WHERE id_urgencia = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
