package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.JornadaLaboral;

@Repository
public class JornadaLaboralRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<JornadaLaboral> mostrarTodo() {
        String sql = "SELECT * FROM jornada_laboral";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new JornadaLaboral(
                rs.getInt("id_jornada"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_cierre").toLocalDateTime(),
                rs.getInt("id_empleado")
        ));
    }

    public JornadaLaboral mostrarPorId(Long id_jornada) {
        String sql = "SELECT * FROM jornada_laboral WHERE id_jornada = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_jornada}, (rs, rowNum) -> new JornadaLaboral(
                rs.getInt("id_jornada"),
                rs.getTimestamp("fecha_hora_inicio").toLocalDateTime(),
                rs.getTimestamp("fecha_hora_cierre").toLocalDateTime(),
                rs.getInt("id_empleado")
        ));
    }

    public boolean guardar(JornadaLaboral jornada) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_jornada), 0) + 1 FROM jornada_laboral", Integer.class);

            String sql = "INSERT INTO jornada_laboral (id_jornada, fecha_hora_inicio, fecha_hora_cierre, id_empleado) " +
                         "VALUES (?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    Timestamp.valueOf(jornada.getFecha_hora_inicio()),
                    Timestamp.valueOf(jornada.getFecha_hora_cierre()),
                    jornada.getId_empleado());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(JornadaLaboral jornada) {
        try {
            String sql = "UPDATE jornada_laboral SET fecha_hora_inicio = ?, fecha_hora_cierre = ?, id_empleado = ? " +
                         "WHERE id_jornada = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    Timestamp.valueOf(jornada.getFecha_hora_inicio()),
                    Timestamp.valueOf(jornada.getFecha_hora_cierre()),
                    jornada.getId_empleado(),
                    jornada.getId_jornada());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM jornada_laboral WHERE id_jornada = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
