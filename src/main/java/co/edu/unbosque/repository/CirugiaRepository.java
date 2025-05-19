package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Cirugia;

@Repository
public class CirugiaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cirugia> mostrarTodo() {
    String sql = "SELECT c.id_cirugia, " +
                 "       c.id_paciente, p.nombre AS nombre_paciente, p.apellido AS apellido_paciente, " +
                 "       c.id_medico, e.nombre AS nombre_medico, e.apellido AS apellido_medico, " +
                 "       c.fecha_hora, c.tipo_procedimiento, " +
                 "       c.tipo_procedimiento AS nombre_tipo_procedimiento, " +  
                 "       c.diagnostico, c.observaciones " +
                 "FROM cirugia c " +
                 "JOIN paciente p ON c.id_paciente = p.id_paciente " +
                 "JOIN medico m ON c.id_medico = m.id_medico " +
                 "JOIN empleado e ON m.id_empleado = e.id_empleado";

    return jdbcTemplate.query(sql, (rs, rowNum) -> new Cirugia(
            rs.getLong("id_cirugia"),
            rs.getLong("id_paciente"),
            rs.getString("nombre_paciente"),
            rs.getString("apellido_paciente"),
            rs.getLong("id_medico"),
            rs.getString("nombre_medico"),
            rs.getString("apellido_medico"),
            rs.getTimestamp("fecha_hora").toLocalDateTime(),
            rs.getString("tipo_procedimiento"),
            rs.getString("diagnostico"),
            rs.getString("observaciones")
    ));
}


    public Cirugia mostrarPorId(Long id_cirugia) {
        String sql = "SELECT * FROM cirugia WHERE id_cirugia = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_cirugia}, (rs, rowNum) -> new Cirugia(
                rs.getLong("id_cirugia"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("tipo_procedimiento"),
                rs.getString("diagnostico"),
                rs.getString("observaciones")
        ));
    }

    public boolean guardar(Cirugia cirugia) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_cirugia), 0) + 1 FROM cirugia", Long.class);
            
            String sql = "INSERT INTO cirugia (id_cirugia, id_paciente, id_medico, fecha_hora, " +
                         "tipo_procedimiento, diagnostico, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    cirugia.getId_paciente(),
                    cirugia.getId_medico(),
                    Timestamp.valueOf(cirugia.getFecha_hora()),
                    cirugia.getTipo_procedimiento(),
                    cirugia.getDiagnostico(),
                    cirugia.getObservaciones());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Cirugia cirugia) {
        try {
            String sql = "UPDATE cirugia SET id_paciente = ?, id_medico = ?, fecha_hora = ?, " +
                         "tipo_procedimiento = ?, diagnostico = ?, observaciones = ? WHERE id_cirugia = ?";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    cirugia.getId_paciente(),
                    cirugia.getId_medico(),
                    Timestamp.valueOf(cirugia.getFecha_hora()),
                    cirugia.getTipo_procedimiento(),
                    cirugia.getDiagnostico(),
                    cirugia.getObservaciones(),
                    cirugia.getId_cirugia());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Long id_cirugia) {
        try {
            String sql = "DELETE FROM cirugia WHERE id_cirugia = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_cirugia);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cirugia> mostrarPorPaciente(Long id_paciente) {
        String sql = "SELECT * FROM cirugia WHERE id_paciente = ?";
        return jdbcTemplate.query(sql, new Object[]{id_paciente}, (rs, rowNum) -> new Cirugia(
                rs.getLong("id_cirugia"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("tipo_procedimiento"),
                rs.getString("diagnostico"),
                rs.getString("observaciones")
        ));
    }

    public List<Cirugia> mostrarPorMedico(Long id_medico) {
        String sql = "SELECT * FROM cirugia WHERE id_medico = ?";
        return jdbcTemplate.query(sql, new Object[]{id_medico}, (rs, rowNum) -> new Cirugia(
                rs.getLong("id_cirugia"),
                rs.getLong("id_paciente"),
                rs.getLong("id_medico"),
                rs.getTimestamp("fecha_hora").toLocalDateTime(),
                rs.getString("tipo_procedimiento"),
                rs.getString("diagnostico"),
                rs.getString("observaciones")
        ));
    }
}