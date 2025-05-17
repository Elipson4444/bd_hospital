package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Consulta;

@Repository
public class ConsultaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Consulta> mostrarTodo() {
        String sql = "SELECT * FROM consulta";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Consulta(
                rs.getLong("id_consulta"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getLong("id_historia"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("diagnostico"),
                rs.getString("tratamiento"),
                rs.getString("observaciones")
        ));
    }

    public Consulta mostrarPorId(Long id_consulta) {
        String sql = "SELECT * FROM consulta WHERE id_consulta = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_consulta}, (rs, rowNum) -> new Consulta(
                rs.getLong("id_consulta"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getLong("id_historia"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("diagnostico"),
                rs.getString("tratamiento"),
                rs.getString("observaciones")
        ));
    }

    public boolean guardar(Consulta consulta) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_consulta), 0) + 1 FROM consulta", Long.class);
            
            String sql = "INSERT INTO consulta (id_consulta, id_paciente, id_medico, id_historia, " +
                         "fecha_hora_creacion, motivo, diagnostico, tratamiento, observaciones) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    consulta.getId_paciente(),
                    consulta.getId_medico(),
                    consulta.getId_historia(),
                    Timestamp.valueOf(consulta.getFecha_hora_creacion()),
                    consulta.getMotivo(),
                    consulta.getDiagnostico(),
                    consulta.getTratamiento(),
                    consulta.getObservaciones());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Consulta consulta) {
        try {
            String sql = "UPDATE consulta SET id_paciente = ?, id_medico = ?, id_historia = ?, " +
                         "fecha_hora_creacion = ?, motivo = ?, diagnostico = ?, tratamiento = ?, " +
                         "observaciones = ? WHERE id_consulta = ?";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    consulta.getId_paciente(),
                    consulta.getId_medico(),
                    consulta.getId_historia(),
                    Timestamp.valueOf(consulta.getFecha_hora_creacion()),
                    consulta.getMotivo(),
                    consulta.getDiagnostico(),
                    consulta.getTratamiento(),
                    consulta.getObservaciones(),
                    consulta.getId_consulta());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Long id_consulta) {
        try {
            String sql = "DELETE FROM consulta WHERE id_consulta = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_consulta);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Consulta> mostrarPorPaciente(Long id_paciente) {
        String sql = "SELECT * FROM consulta WHERE id_paciente = ?";
        return jdbcTemplate.query(sql, new Object[]{id_paciente}, (rs, rowNum) -> new Consulta(
                rs.getLong("id_consulta"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getLong("id_historia"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("diagnostico"),
                rs.getString("tratamiento"),
                rs.getString("observaciones")
        ));
    }

    public List<Consulta> mostrarPorMedico(Long id_medico) {
        String sql = "SELECT * FROM consulta WHERE id_medico = ?";
        return jdbcTemplate.query(sql, new Object[]{id_medico}, (rs, rowNum) -> new Consulta(
                rs.getLong("id_consulta"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getLong("id_historia"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("diagnostico"),
                rs.getString("tratamiento"),
                rs.getString("observaciones")
        ));
    }

    public List<Consulta> mostrarPorHistoria(Long id_historia) {
        String sql = "SELECT * FROM consulta WHERE id_historia = ?";
        return jdbcTemplate.query(sql, new Object[]{id_historia}, (rs, rowNum) -> new Consulta(
                rs.getLong("id_consulta"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getLong("id_historia"),
                rs.getTimestamp("fecha_hora_creacion").toLocalDateTime(),
                rs.getString("motivo"),
                rs.getString("diagnostico"),
                rs.getString("tratamiento"),
                rs.getString("observaciones")
        ));
    }
}