package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.TipoFactura;

@Repository
public class TipoFacturaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TipoFactura> mostrarTodo() {
        String sql = "SELECT * FROM tipo_factura";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TipoFactura(
                rs.getInt("id_tipo"),
                rs.getString("tipo")
        ));
    }

    public TipoFactura mostrarPorId(int id_tipo) {
        String sql = "SELECT * FROM tipo_factura WHERE id_tipo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_tipo}, (rs, rowNum) -> new TipoFactura(
                rs.getInt("id_tipo"),
                rs.getString("tipo")
        ));
    }

    public boolean guardar(TipoFactura tipoFactura) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_tipo), 0) + 1 FROM tipo_factura", Integer.class);

            String sql = "INSERT INTO tipo_factura (id_tipo, tipo) VALUES (?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    tipoFactura.getTipo());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(TipoFactura tipoFactura) {
        try {
            String sql = "UPDATE tipo_factura SET tipo = ? WHERE id_tipo = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    tipoFactura.getTipo(),
                    tipoFactura.getId_tipo());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM tipo_factura WHERE id_tipo = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
