package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.JornadaDia;

@Repository
public class JornadaDiaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<JornadaDia> mostrarTodo() {
        String sql = "SELECT * FROM jornada_dia";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new JornadaDia(
                rs.getLong("id_jornada"),
                rs.getString("dia_semana")
        ));
    }

    public JornadaDia mostrarPorId(Long id_jornada) {
        String sql = "SELECT * FROM jornada_dia WHERE id_jornada = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_jornada }, (rs, rowNum) -> new JornadaDia(
                rs.getLong("id_jornada"),
                rs.getString("dia_semana")
        ));
    }

    public boolean guardar(JornadaDia jornadaDia) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_jornada), 0) + 1 FROM jornada_dia", Long.class);

            String sql = "INSERT INTO jornada_dia (id_jornada, dia_semana) VALUES (?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    jornadaDia.getDia_semana());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(JornadaDia jornadaDia) {
        try {
            String sql = "UPDATE jornada_dia SET dia_semana = ? WHERE id_jornada = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    jornadaDia.getDia_semana(),
                    jornadaDia.getId_jornada());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id_jornada) {
        try {
            String sql = "DELETE FROM jornada_dia WHERE id_jornada = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_jornada);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
