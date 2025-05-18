package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.TipoReclamo;

@Repository
public class TipoReclamoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TipoReclamo> mostrarTodo() {
        String sql = "SELECT * FROM tipo_reclamo";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TipoReclamo(
                rs.getInt("id_tpreclamo"),
                rs.getString("tipo")
        ));
    }

    public TipoReclamo mostrarPorId(int id_tpreclamo) {
        String sql = "SELECT * FROM tipo_reclamo WHERE id_tpreclamo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_tpreclamo}, (rs, rowNum) -> new TipoReclamo(
                rs.getInt("id_tpreclamo"),
                rs.getString("tipo")
        ));
    }

    public boolean guardar(TipoReclamo tipoReclamo) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_tpreclamo), 0) + 1 FROM tipo_reclamo", Integer.class);

            String sql = "INSERT INTO tipo_reclamo (id_tpreclamo, tipo) VALUES (?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    tipoReclamo.getTipo());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(TipoReclamo tipoReclamo) {
        try {
            String sql = "UPDATE tipo_reclamo SET tipo = ? WHERE id_tpreclamo = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    tipoReclamo.getTipo(),
                    tipoReclamo.getId_tpreclamo());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM tipo_reclamo WHERE id_tpreclamo = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
