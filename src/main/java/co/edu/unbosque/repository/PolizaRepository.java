package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Poliza;

@Repository
public class PolizaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Poliza> mostrarTodo() {
        String sql = "SELECT * FROM poliza";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Poliza(
                rs.getInt("id_poliza"),
                rs.getString("nombre"),
                rs.getString("contacto")
        ));
    }

    public Poliza mostrarPorId(Long id_poliza) {
        String sql = "SELECT * FROM poliza WHERE id_poliza = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_poliza }, (rs, rowNum) -> new Poliza(
                rs.getInt("id_poliza"),
                rs.getString("nombre"),
                rs.getString("contacto"))
        );
    }

    public boolean guardar(Poliza poliza) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_poliza), 0) + 1 FROM poliza", Integer.class);

            String sql = "INSERT INTO poliza (id_poliza, nombre, contacto) VALUES (?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    poliza.getNombre(),
                    poliza.getContacto());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Poliza poliza) {
        try {
            String sql = "UPDATE poliza SET nombre = ?, contacto = ? WHERE id_poliza = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    poliza.getNombre(),
                    poliza.getContacto(),
                    poliza.getId_poliza());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM poliza WHERE id_poliza = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
