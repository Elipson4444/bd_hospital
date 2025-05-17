package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.EmpleadosAuditoria;

@Repository
public class EmpleadosAuditoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmpleadosAuditoria> mostrarTodo() {
        String sql = "SELECT * FROM EMPLEADOS_AUDITORIA";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new EmpleadosAuditoria(
                rs.getInt("id_ea"),
                rs.getInt("id_empleado"),
                rs.getInt("id_auditoria")
        ));
    }

    public EmpleadosAuditoria mostrarPorId(Long id_ea) {
        String sql = "SELECT * FROM EMPLEADOS_AUDITORIA WHERE id_ea = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_ea}, (rs, rowNum) -> new EmpleadosAuditoria(
                rs.getInt("id_ea"),
                rs.getInt("id_empleado"),
                rs.getInt("id_auditoria")
        ));
    }

    public boolean guardar(EmpleadosAuditoria ea) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_ea), 0) + 1 FROM EMPLEADOS_AUDITORIA", Integer.class);

            String sql = "INSERT INTO EMPLEADOS_AUDITORIA (id_ea, id_empleado, id_auditoria) VALUES (?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    ea.getId_empleado(),
                    ea.getId_auditoria());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(EmpleadosAuditoria ea) {
        try {
            String sql = "UPDATE EMPLEADOS_AUDITORIA SET id_empleado = ?, id_auditoria = ? WHERE id_ea = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    ea.getId_empleado(),
                    ea.getId_auditoria(),
                    ea.getId_ea());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM EMPLEADOS_AUDITORIA WHERE id_ea = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
