package co.edu.unbosque.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Laboratorio;

@Repository
public class LaboratorioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Laboratorio> mostrarTodo() {
        String sql = "SELECT * FROM laboratorio";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Laboratorio(
                rs.getLong("id_laboratorio"),
                rs.getLong("id_consulta"),
                rs.getString("tipo_examen"),
                rs.getTimestamp("fecha_hora_solicitud").toLocalDateTime(),
                rs.getString("resultado"),
                rs.getString("observaciones")
        ));
    }

    public Laboratorio mostrarPorId(Long id_laboratorio) {
        String sql = "SELECT * FROM laboratorio WHERE id_laboratorio = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_laboratorio}, (rs, rowNum) -> new Laboratorio(
                rs.getLong("id_laboratorio"),
                rs.getLong("id_consulta"),
                rs.getString("tipo_examen"),
                rs.getTimestamp("fecha_hora_solicitud").toLocalDateTime(),
                rs.getString("resultado"),
                rs.getString("observaciones")
        ));
    }

    public boolean guardar(Laboratorio laboratorio) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_laboratorio), 0) + 1 FROM laboratorio", Long.class);

            String sql = "INSERT INTO laboratorio (id_laboratorio, id_consulta, tipo_examen, fecha_hora_solicitud, resultado, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    laboratorio.getId_consulta(),
                    laboratorio.getTipo_examen(),
                    Timestamp.valueOf(laboratorio.getFecha_hora_solicitud()),
                    laboratorio.getResultado(),
                    laboratorio.getObservaciones()
            );

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Laboratorio laboratorio) {
        try {
            String sql = "UPDATE laboratorio SET id_consulta = ?, tipo_examen = ?, fecha_hora_solicitud = ?, resultado = ?, observaciones = ? WHERE id_laboratorio = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    laboratorio.getId_consulta(),
                    laboratorio.getTipo_examen(),
                    Timestamp.valueOf(laboratorio.getFecha_hora_solicitud()),
                    laboratorio.getResultado(),
                    laboratorio.getObservaciones(),
                    laboratorio.getId_laboratorio()
            );
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM laboratorio WHERE id_laboratorio = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}


