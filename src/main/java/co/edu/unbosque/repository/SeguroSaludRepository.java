package co.edu.unbosque.repository;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.SeguroSalud;

@Repository
public class SeguroSaludRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SeguroSalud> findAll() {
        String sql = "SELECT * FROM seguro_salud";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new SeguroSalud(
                rs.getLong("id_seguro"),
                rs.getString("nombre"),
                rs.getString("tipo"),
                rs.getString("cobertura"),
                rs.getString("contacto")));
    }

    public SeguroSalud findById(Long id_seguro) {
        String sql = "SELECT * FROM seguro_salud WHERE id_seguro = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_seguro }, (rs, rowNum) -> new SeguroSalud(
                rs.getLong("id_seguro"),
                rs.getString("nombre"),
                rs.getString("tipo"),
                rs.getString("cobertura"),
                rs.getString("contacto")));
    }

    public Long save(SeguroSalud seguro) {
    
    Long nextId = jdbcTemplate.queryForObject(
        "SELECT NVL(MAX(id_seguro), 0) + 1 FROM seguro_salud", Long.class);
    
    
    String sql = "INSERT INTO seguro_salud (id_seguro, nombre, tipo, cobertura, contacto) VALUES (?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, 
        nextId,
        seguro.getNombre(),
        seguro.getTipo(),
        seguro.getCobertura(),
        seguro.getContacto());
    
    return nextId;
}

    public int update(SeguroSalud seguro) {
        String sql = "UPDATE seguro_salud SET nombre = ?, tipo = ?, cobertura = ?, contacto = ? WHERE id_seguro = ?";
        return jdbcTemplate.update(sql,
                seguro.getNombre(),
                seguro.getTipo(),
                seguro.getCobertura(),
                seguro.getContacto(),
                seguro.getId_seguro());
    }

    public int delete(Long id_seguro) {
        String sql = "DELETE FROM seguro_salud WHERE id_seguro = ?";
        return jdbcTemplate.update(sql, id_seguro);
    }
}