package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.ConceptoFactura;

@Repository
public class ConceptoFacturaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ConceptoFactura> mostrarTodo() {
        String sql = "SELECT * FROM concepto_de_factura";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ConceptoFactura(
                rs.getInt("id_concepto"),
                rs.getLong("id_factura"),
                rs.getString("descripcion"),
                rs.getDouble("precio_unitario"),
                rs.getString("concepto")
        ));
    }

    public ConceptoFactura mostrarPorId(int id_concepto) {
        String sql = "SELECT * FROM concepto_de_factura WHERE id_concepto = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{ id_concepto }, (rs, rowNum) -> new ConceptoFactura(
                rs.getInt("id_concepto"),
                rs.getLong("id_factura"),
                rs.getString("descripcion"),
                rs.getDouble("precio_unitario"),
                rs.getString("concepto")
        ));
    }

    public boolean guardar(ConceptoFactura conceptoFactura) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                    "SELECT NVL(MAX(id_concepto), 0) + 1 FROM concepto_de_factura", Integer.class);

            String sql = "INSERT INTO concepto_de_factura (id_concepto, id_factura, descripcion, precio_unitario, concepto) " +
                         "VALUES (?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    conceptoFactura.getId_factura(),
                    conceptoFactura.getDescripcion(),
                    conceptoFactura.getPrecio_unitario(),
                    conceptoFactura.getConcepto());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(ConceptoFactura conceptoFactura) {
        try {
            String sql = "UPDATE concepto_de_factura SET id_factura = ?, descripcion = ?, precio_unitario = ?, concepto = ? " +
                         "WHERE id_concepto = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    conceptoFactura.getId_factura(),
                    conceptoFactura.getDescripcion(),
                    conceptoFactura.getPrecio_unitario(),
                    conceptoFactura.getConcepto(),
                    conceptoFactura.getId_concepto());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM concepto_de_factura WHERE id_concepto = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
