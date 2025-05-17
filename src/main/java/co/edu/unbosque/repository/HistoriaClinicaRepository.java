package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.HistoriaClinica;

@Repository
public class HistoriaClinicaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<HistoriaClinica> mostrarTodo() {
        String sql = "SELECT * FROM historia_clinica";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new HistoriaClinica(
                rs.getLong("id_historia"),
                rs.getLong("id_paciente"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("observaciones")
        ));
    }

    public HistoriaClinica mostrarPorId(Long id_historia) {
        String sql = "SELECT * FROM historia_clinica WHERE id_historia = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_historia}, (rs, rowNum) -> new HistoriaClinica(
                rs.getLong("id_historia"),
                rs.getLong("id_paciente"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("observaciones")
        ));
    }

    public List<HistoriaClinica> mostrarPorPaciente(Long id_paciente) {
        String sql = "SELECT * FROM historia_clinica WHERE id_paciente = ?";
        return jdbcTemplate.query(sql, new Object[]{id_paciente}, (rs, rowNum) -> new HistoriaClinica(
                rs.getLong("id_historia"),
                rs.getLong("id_paciente"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("observaciones")
        ));
    }

    public boolean guardar(HistoriaClinica historiaClinica) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_historia), 0) + 1 FROM historia_clinica", Long.class);
            
            String sql = "INSERT INTO historia_clinica (id_historia, id_paciente, observaciones) VALUES (?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    historiaClinica.getId_paciente(),
                    historiaClinica.getObservaciones());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(HistoriaClinica historiaClinica) {
        try {
            String sql = "UPDATE historia_clinica SET id_paciente = ?, observaciones = ? WHERE id_historia = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    historiaClinica.getId_paciente(),
                    historiaClinica.getObservaciones(),
                    historiaClinica.getId_historia());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id_historia) {
        try {
            String sql = "DELETE FROM historia_clinica WHERE id_historia = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_historia);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}