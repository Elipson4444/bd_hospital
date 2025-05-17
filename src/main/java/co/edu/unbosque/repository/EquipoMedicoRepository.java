package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.EquipoMedico;

@Repository
public class EquipoMedicoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EquipoMedico> mostrarTodo() {
        String sql = "SELECT * FROM equipo_medico";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new EquipoMedico(
                rs.getLong("id_equipo_medico"),
                rs.getString("nombre"),
                rs.getString("marca"),
                rs.getTimestamp("fecha_hora_adquisicion").toLocalDateTime(),
                rs.getString("modelo"),
                rs.getString("estado")
        ));
    }

    public EquipoMedico mostrarPorId(Long id_equipo_medico) {
        String sql = "SELECT * FROM equipo_medico WHERE id_equipo_medico = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_equipo_medico }, (rs, rowNum) -> new EquipoMedico(
                rs.getLong("id_equipo_medico"),
                rs.getString("nombre"),
                rs.getString("marca"),
                rs.getTimestamp("fecha_hora_adquisicion").toLocalDateTime(),
                rs.getString("modelo"),
                rs.getString("estado")
        ));
    }

    public boolean guardar(EquipoMedico equipo) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_equipo_medico), 0) + 1 FROM equipo_medico", Long.class);

            String sql = "INSERT INTO equipo_medico (id_equipo_medico, nombre, marca, fecha_hora_adquisicion, modelo, estado) VALUES (?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    equipo.getNombre(),
                    equipo.getMarca(),
                    Timestamp.valueOf(equipo.getFecha_hora_adquisicion()),
                    equipo.getModelo(),
                    equipo.getEstado());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(EquipoMedico equipo) {
        try {
            String sql = "UPDATE equipo_medico SET nombre = ?, marca = ?, fecha_hora_adquisicion = ?, modelo = ?, estado = ? WHERE id_equipo_medico = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    equipo.getNombre(),
                    equipo.getMarca(),
                    Timestamp.valueOf(equipo.getFecha_hora_adquisicion()),
                    equipo.getModelo(),
                    equipo.getEstado(),
                    equipo.getId_equipo_medico());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id_equipo_medico) {
        try {
            String sql = "DELETE FROM equipo_medico WHERE id_equipo_medico = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_equipo_medico);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
