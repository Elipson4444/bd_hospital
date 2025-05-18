package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Empleado;

@Repository
public class EmpleadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Empleado> mostrarTodo() {
        String sql = "SELECT * FROM empleado";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Empleado(
                rs.getLong("id_empleado"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("cargo"),
                rs.getInt("id_tparea")
        ));
    }

    public Empleado mostrarPorId(Long id_empleado) {
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_empleado}, (rs, rowNum) -> new Empleado(
                rs.getLong("id_empleado"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("cargo"),
                rs.getInt("id_tparea")
        ));
    }

    public boolean guardar(Empleado empleado) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_empleado), 0) + 1 FROM empleado", Long.class);

            String sql = "INSERT INTO empleado (id_empleado, nombre, apellido, cargo, id_tparea) VALUES (?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getCargo(),
                    empleado.getId_tparea());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Empleado empleado) {
        try {
            String sql = "UPDATE empleado SET nombre = ?, apellido = ?, cargo = ?, id_tparea = ? WHERE id_empleado = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getCargo(),
                    empleado.getId_tparea(),
                    empleado.getId_empleado());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM empleado WHERE id_empleado = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
