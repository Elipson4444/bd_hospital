package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Antecedente;

@Repository
public class AntecedenteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Antecedente> mostrarTodo() {
        String sql = "SELECT * FROM ANTECEDENTES";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Antecedente(
                rs.getInt("id_af"),  
                rs.getString("descripcion"),
                rs.getString("tipo"),
                rs.getInt("id_historia")
        ));
    }

    public Antecedente mostrarPorId(int id_af) {  
        String sql = "SELECT * FROM ANTECEDENTES WHERE id_af = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_af }, (rs, rowNum) -> new Antecedente(
                rs.getInt("id_af"),  
                rs.getString("descripcion"),
                rs.getString("tipo"),
                rs.getInt("id_historia"))
        );
    }

    public boolean guardar(Antecedente antecedente) {
        try {
            int nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_af), 0) + 1 FROM ANTECEDENTES", Integer.class);
            
            String sql = "INSERT INTO ANTECEDENTES (id_af, descripcion, tipo, id_historia) VALUES (?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql, 
                    nextId,
                    antecedente.getDescripcion(),
                    antecedente.getTipo(),
                    antecedente.getId_historia());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace(); // Para propósitos de depuración
            return false;
        }
    }

    public boolean actualizar(Antecedente antecedente) {
        try {
            String sql = "UPDATE ANTECEDENTES SET descripcion = ?, tipo = ?, id_historia = ? WHERE id_af = ?";
            int rowsAffected = jdbcTemplate.update(sql, 
                    antecedente.getDescripcion(), 
                    antecedente.getTipo(), 
                    antecedente.getId_historia(),
                    antecedente.getId_af());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM ANTECEDENTES WHERE id_af = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Antecedente> mostrarPorHistoria(int id_historia) {
        String sql = "SELECT * FROM ANTECEDENTES WHERE id_historia = ?";
        return jdbcTemplate.query(sql, new Object[] { id_historia }, (rs, rowNum) -> new Antecedente(
                rs.getInt("id_af"),  
                rs.getString("descripcion"),
                rs.getString("tipo"),
                rs.getInt("id_historia"))
        );
    }
}