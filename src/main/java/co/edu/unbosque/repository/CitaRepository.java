package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Cita;

@Repository
public class CitaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cita> mostrarTodo() {
        String sql = "SELECT * FROM cita";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Cita(
                rs.getLong("id_cita"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora_cita").toLocalDateTime(),
                rs.getString("estado")
        ));
    }

    public Cita mostrarPorId(Long id_cita) {
        String sql = "SELECT * FROM cita WHERE id_cita = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_cita}, (rs, rowNum) -> new Cita(
                rs.getLong("id_cita"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora_cita").toLocalDateTime(),
                rs.getString("estado")
        ));
    }

    public boolean guardar(Cita cita) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_cita), 0) + 1 FROM cita", Long.class);
            
            String sql = "INSERT INTO cita (id_cita, id_paciente, id_medico, fecha_hora_cita, estado) " +
                         "VALUES (?, ?, ?, ?, ?)";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    cita.getId_paciente(),
                    cita.getId_medico(),
                    Timestamp.valueOf(cita.getFecha_hora_cita()),
                    cita.getEstado());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Cita cita) {
        try {
            String sql = "UPDATE cita SET id_paciente = ?, id_medico = ?, " +
                         "fecha_hora_cita = ?, estado = ? WHERE id_cita = ?";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    cita.getId_paciente(),
                    cita.getId_medico(),
                    Timestamp.valueOf(cita.getFecha_hora_cita()),
                    cita.getEstado(),
                    cita.getId_cita());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Long id_cita) {
        try {
            String sql = "DELETE FROM cita WHERE id_cita = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_cita);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cita> mostrarPorPaciente(Long id_paciente) {
        String sql = "SELECT * FROM cita WHERE id_paciente = ?";
        return jdbcTemplate.query(sql, new Object[]{id_paciente}, (rs, rowNum) -> new Cita(
                rs.getLong("id_cita"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora_cita").toLocalDateTime(),
                rs.getString("estado")
        ));
    }

    public List<Cita> mostrarPorMedico(Long id_medico) {
        String sql = "SELECT * FROM cita WHERE id_medico = ?";
        return jdbcTemplate.query(sql, new Object[]{id_medico}, (rs, rowNum) -> new Cita(
                rs.getLong("id_cita"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora_cita").toLocalDateTime(),
                rs.getString("estado")
        ));
    }

    public List<Cita> mostrarPorEstado(String estado) {
        String sql = "SELECT * FROM cita WHERE estado = ?";
        return jdbcTemplate.query(sql, new Object[]{estado}, (rs, rowNum) -> new Cita(
                rs.getLong("id_cita"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora_cita").toLocalDateTime(),
                rs.getString("estado")
        ));
    }
}