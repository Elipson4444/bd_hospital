package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Alergia;

@Repository
public class AlergiaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Alergia> mostrarTodo() {
        String sql = "SELECT * FROM alergias";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Alergia(
                rs.getInt("id_al"),
                rs.getString("descripcionl"),
                rs.getLong("id_historia")
        ));
    }

    public Alergia mostrarPorId(int id_al) {
        String sql = "SELECT * FROM alergias WHERE id_al = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_al }, (rs, rowNum) -> new Alergia(
                rs.getInt("id_al"),
                rs.getString("descripcionl"),
                rs.getLong("id_historia")
        ));
    }

    public boolean guardar(Alergia alergia) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_al), 0) + 1 FROM alergias", Integer.class);
            
            String sql = "INSERT INTO alergias (id_al, descripcionl, id_historia) VALUES (?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    alergia.getDescripcionl(),
                    alergia.getId_historia());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Alergia alergia) {
        try {
            String sql = "UPDATE alergias SET descripcionl = ?, id_historia = ? WHERE id_al = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    alergia.getDescripcionl(),
                    alergia.getId_historia(),
                    alergia.getId_al());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM alergias WHERE id_al = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
