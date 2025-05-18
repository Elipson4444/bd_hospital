package co.edu.unbosque.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Factura;

@Repository
public class FacturaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Factura> mostrarTodo() {
        String sql = "SELECT * FROM factura";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToFactura(rs));
    }

    public Factura mostrarPorId(Long id_factura) {
        String sql = "SELECT * FROM factura WHERE id_factura = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_factura }, (rs, rowNum) -> mapRowToFactura(rs));
    }

    public boolean guardar(Factura factura) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_factura), 0) + 1 FROM factura", Long.class);

            String sql = "INSERT INTO factura (id_factura, id_paciente, fecha_hora_emision, total, metodo_pago, estado, id_tipo, id_concepto) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            int rowsAffected = jdbcTemplate.update(sql,
                nextId,
                factura.getId_paciente(),
                Timestamp.valueOf(factura.getFecha_hora_emision()),
                factura.getTotal(),
                factura.getMetodo_pago(),
                factura.getEstado(),
                factura.getId_tipo(),
                factura.getId_concepto()
            );

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Factura factura) {
        try {
            String sql = "UPDATE factura SET id_paciente = ?, fecha_hora_emision = ?, total = ?, metodo_pago = ?, estado = ?, id_tipo = ?, id_concepto = ? WHERE id_factura = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                factura.getId_paciente(),
                Timestamp.valueOf(factura.getFecha_hora_emision()),
                factura.getTotal(),
                factura.getMetodo_pago(),
                factura.getEstado(),
                factura.getId_tipo(),
                factura.getId_concepto(),
                factura.getId_factura()
            );

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id_factura) {
        try {
            String sql = "DELETE FROM factura WHERE id_factura = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_factura);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private Factura mapRowToFactura(ResultSet rs) throws SQLException {
        Factura factura = new Factura();
        factura.setId_factura(rs.getLong("id_factura"));
        factura.setId_paciente(rs.getLong("id_paciente"));
        Timestamp ts = rs.getTimestamp("fecha_hora_emision");
        factura.setFecha_hora_emision(ts != null ? ts.toLocalDateTime() : null);
        factura.setTotal(rs.getLong("total"));
        factura.setMetodo_pago(rs.getString("metodo_pago"));
        factura.setEstado(rs.getString("estado"));
        factura.setId_tipo(rs.getInt("id_tipo"));
        factura.setId_concepto(rs.getInt("id_concepto"));
        return factura;
    }
}
