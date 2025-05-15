package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Habitacion;

@Repository
public class HabitacionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Habitacion> mostrarTodo() {
        String sql = "SELECT * FROM habitacion";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Habitacion(
                rs.getLong("id_habitacion"),  
                rs.getInt("numero"),
                rs.getInt("piso"),
                rs.getString("estado")
        ));
    }

    public Habitacion mostrarPorId(Long id_habitacion) {  
        String sql = "SELECT * FROM habitacion WHERE id_habitacion = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_habitacion }, (rs, rowNum) -> new Habitacion(
                rs.getLong("id_habitacion"),  
                rs.getInt("numero"),
                rs.getInt("piso"),
                rs.getString("estado"))
        );
    }


    public boolean guardar(Habitacion habitacion) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_habitacion), 0) + 1 FROM habitacion", Long.class);
            
            String sql = "INSERT INTO habitacion (id_habitacion, numero, piso, estado) VALUES (?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql, 
                    nextId,
                    habitacion.getNumero(),
                    habitacion.getPiso(),
                    habitacion.getEstado());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Habitacion habitacion) {
        try {
            String sql = "UPDATE habitacion SET numero = ?, piso = ?, estado = ? WHERE id_habitacion = ?";
            int rowsAffected = jdbcTemplate.update(sql, 
                    habitacion.getNumero(), 
                    habitacion.getPiso(), 
                    habitacion.getEstado(),
                    habitacion.getId_habitacion());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM habitacion WHERE id_habitacion = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    
}