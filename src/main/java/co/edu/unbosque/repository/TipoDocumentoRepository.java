package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.TipoDocumento;

@Repository
public class TipoDocumentoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TipoDocumento> mostrarTodo() {
        String sql = "SELECT * FROM tipo_documento";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TipoDocumento(
                rs.getInt("id_tpdocumento"),
                rs.getString("tipo")
        ));
    }

    public TipoDocumento mostrarPorId(int id_tpdocumento) {
        String sql = "SELECT * FROM tipo_documento WHERE id_tpdocumento = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_tpdocumento }, (rs, rowNum) -> new TipoDocumento(
                rs.getInt("id_tpdocumento"),
                rs.getString("tipo")
        ));
    }

    public boolean guardar(TipoDocumento tipoDocumento) {
        try {
            int nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_tpdocumento), 0) + 1 FROM tipo_documento", Integer.class);

            String sql = "INSERT INTO tipo_documento (id_tpdocumento, tipo) VALUES (?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    tipoDocumento.getTipo());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(TipoDocumento tipoDocumento) {
        try {
            String sql = "UPDATE tipo_documento SET tipo = ? WHERE id_tpdocumento = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    tipoDocumento.getTipo(),
                    tipoDocumento.getId_tpdocumento());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM tipo_documento WHERE id_tpdocumento = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
