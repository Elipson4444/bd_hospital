package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.AuditoriaMedica;

@Repository
public class AuditoriaMedicaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AuditoriaMedica> mostrarTodo() {
        String sql = "SELECT * FROM auditoria_medica";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new AuditoriaMedica(
                rs.getInt("id_auditoria"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_fin") != null ? rs.getTimestamp("fecha_hora_fin").toLocalDateTime() : null,
                rs.getString("tipo_auditoria"),
                rs.getString("hallazgos"),
                rs.getString("estado"),
                rs.getInt("id_empleado")
        ));
    }

    public AuditoriaMedica mostrarPorId(int id_auditoria) {
        String sql = "SELECT * FROM auditoria_medica WHERE id_auditoria = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_auditoria}, (rs, rowNum) -> new AuditoriaMedica(
                rs.getInt("id_auditoria"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_fin") != null ? rs.getTimestamp("fecha_hora_fin").toLocalDateTime() : null,
                rs.getString("tipo_auditoria"),
                rs.getString("hallazgos"),
                rs.getString("estado"),
                rs.getInt("id_empleado")
        ));
    }

    public boolean guardar(AuditoriaMedica auditoria) {
        try {
            int nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_auditoria), 0) + 1 FROM auditoria_medica", Integer.class);
            
            String sql = "INSERT INTO auditoria_medica (id_auditoria, fecha_hora_inicio, fecha_hora_fin, " +
                         "tipo_auditoria, hallazgos, estado, id_empleado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    Timestamp.valueOf(auditoria.getFecha_hora_inicio()),
                    auditoria.getFecha_hora_fin() != null ? Timestamp.valueOf(auditoria.getFecha_hora_fin()) : null,
                    auditoria.getTipo_auditoria(),
                    auditoria.getHallazgos(),
                    auditoria.getEstado(),
                    auditoria.getId_empleado());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(AuditoriaMedica auditoria) {
        try {
            String sql = "UPDATE auditoria_medica SET fecha_hora_inicio = ?, fecha_hora_fin = ?, " +
                       "tipo_auditoria = ?, hallazgos = ?, estado = ?, id_empleado = ? WHERE id_auditoria = ?";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    Timestamp.valueOf(auditoria.getFecha_hora_inicio()),
                    auditoria.getFecha_hora_fin() != null ? Timestamp.valueOf(auditoria.getFecha_hora_fin()) : null,
                    auditoria.getTipo_auditoria(),
                    auditoria.getHallazgos(),
                    auditoria.getEstado(),
                    auditoria.getId_empleado(),
                    auditoria.getId_auditoria());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id_auditoria) {
        try {
            String sql = "DELETE FROM auditoria_medica WHERE id_auditoria = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_auditoria);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AuditoriaMedica> mostrarPorEmpleado(int id_empleado) {
        String sql = "SELECT * FROM auditoria_medica WHERE id_empleado = ?";
        return jdbcTemplate.query(sql, new Object[]{id_empleado}, (rs, rowNum) -> new AuditoriaMedica(
                rs.getInt("id_auditoria"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_fin") != null ? rs.getTimestamp("fecha_hora_fin").toLocalDateTime() : null,
                rs.getString("tipo_auditoria"),
                rs.getString("hallazgos"),
                rs.getString("estado"),
                rs.getInt("id_empleado")
        ));
    }
}