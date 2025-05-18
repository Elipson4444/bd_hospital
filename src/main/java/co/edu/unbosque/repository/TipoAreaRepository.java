package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.TipoArea;

@Repository
public class TipoAreaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TipoArea> mostrarTodo() {
        String sql = "SELECT * FROM tipo_area";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TipoArea(
                rs.getInt("id_tparea"),
                rs.getString("tipo")
        ));
    }

    public TipoArea mostrarPorId(int id_tparea) {
        String sql = "SELECT * FROM tipo_area WHERE id_tparea = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_tparea }, (rs, rowNum) -> new TipoArea(
                rs.getInt("id_tparea"),
                rs.getString("tipo")
        ));
    }

    public boolean guardar(TipoArea tipoArea) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_tparea), 0) + 1 FROM tipo_area", Integer.class);
            
            String sql = "INSERT INTO tipo_area (id_tparea, tipo) VALUES (?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    tipoArea.getTipo());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(TipoArea tipoArea) {
        try {
            String sql = "UPDATE tipo_area SET tipo = ? WHERE id_tparea = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    tipoArea.getTipo(),
                    tipoArea.getId_tparea());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM tipo_area WHERE id_tparea = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
