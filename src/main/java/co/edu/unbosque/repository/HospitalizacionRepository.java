package co.edu.unbosque.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Hospitalizacion;

@Repository
public class HospitalizacionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hospitalizacion> mostrarTodo() {
        String sql = "SELECT * FROM hospitalizacion";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Hospitalizacion(
                rs.getLong("id_hospitalizacion"),
                rs.getLong("id_paciente"),
                rs.getLong("id_habitacion"),
                rs.getObject("fecha_hora_ingresa", LocalDateTime.class),
                rs.getObject("fecha_hora_egreso", LocalDateTime.class),
                rs.getString("motivo"),
                rs.getString("diagnostico_ingreso"),
                rs.getString("diagnostico_egreso")
        ));
    }

    public Hospitalizacion mostrarPorId(Long id_hospitalizacion) {
        String sql = "SELECT * FROM hospitalizacion WHERE id_hospitalizacion = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_hospitalizacion }, (rs, rowNum) -> new Hospitalizacion(
                rs.getLong("id_hospitalizacion"),
                rs.getLong("id_paciente"),
                rs.getLong("id_habitacion"),
                rs.getObject("fecha_hora_ingresa", LocalDateTime.class),
                rs.getObject("fecha_hora_egreso", LocalDateTime.class),
                rs.getString("motivo"),
                rs.getString("diagnostico_ingreso"),
                rs.getString("diagnostico_egreso")
        ));
    }

    public boolean guardar(Hospitalizacion hospitalizacion) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_hospitalizacion), 0) + 1 FROM hospitalizacion", Long.class);

            String sql = "INSERT INTO hospitalizacion "
                    + "(id_hospitalizacion, id_paciente, id_habitacion, fecha_hora_ingresa, fecha_hora_egreso, motivo, diagnostico_ingreso, diagnostico_egreso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    hospitalizacion.getId_paciente(),
                    hospitalizacion.getId_habitacion(),
                    hospitalizacion.getFecha_hora_ingresa(),
                    hospitalizacion.getFecha_hora_egreso(),
                    hospitalizacion.getMotivo(),
                    hospitalizacion.getDiagnostico_ingreso(),
                    hospitalizacion.getDiagnostico_egreso());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Hospitalizacion hospitalizacion) {
        try {
            String sql = "UPDATE hospitalizacion SET "
                    + "id_paciente = ?, "
                    + "id_habitacion = ?, "
                    + "fecha_hora_ingresa = ?, "
                    + "fecha_hora_egreso = ?, "
                    + "motivo = ?, "
                    + "diagnostico_ingreso = ?, "
                    + "diagnostico_egreso = ? "
                    + "WHERE id_hospitalizacion = ?";

            int rowsAffected = jdbcTemplate.update(sql,
                    hospitalizacion.getId_paciente(),
                    hospitalizacion.getId_habitacion(),
                    hospitalizacion.getFecha_hora_ingresa(),
                    hospitalizacion.getFecha_hora_egreso(),
                    hospitalizacion.getMotivo(),
                    hospitalizacion.getDiagnostico_ingreso(),
                    hospitalizacion.getDiagnostico_egreso(),
                    hospitalizacion.getId_hospitalizacion());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM hospitalizacion WHERE id_hospitalizacion = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
