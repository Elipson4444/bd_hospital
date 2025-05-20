package co.edu.unbosque.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Paciente;

@Repository
public class PacienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Paciente> mostrarTodo() {
        String sql = "SELECT * FROM paciente";
        System.out.println("Mostrando");
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Paciente(
                rs.getLong("id_paciente"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getDate("fecha_nacimiento").toLocalDate(),
                rs.getString("sexo"),
                rs.getString("tipo_documento"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getLong("id_seguro")
        ));
    }

    public Paciente mostrarPorId(Long id_paciente) {
        String sql = "SELECT * FROM paciente WHERE id_paciente = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_paciente}, (rs, rowNum) -> new Paciente(
                rs.getLong("id_paciente"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getDate("fecha_nacimiento").toLocalDate(),
                rs.getString("sexo"),
                rs.getString("tipo_documento"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getLong("id_seguro")
        ));
    }

    public boolean guardar(Paciente paciente) {
        System.out.println("Guardando");
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_paciente), 0) + 1 FROM paciente", Long.class);
            
            String sql = "INSERT INTO paciente (id_paciente, nombre, apellido, fecha_nacimiento, sexo, tipo_documento, direccion, telefono, id_seguro) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    paciente.getNombre(),
                    paciente.getApellido(),
                    Date.valueOf(paciente.getFecha_nacimiento()),
                    paciente.getSexo(),
                    paciente.getTipo_documento(),
                    paciente.getDireccion(),
                    paciente.getTelefono(),
                    paciente.getId_seguro());
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Paciente paciente) {
        System.out.println("intentando actualizar");
        try {
            String sql = "UPDATE paciente SET nombre = ?, apellido = ?, fecha_nacimiento = ?, sexo = ?, " +
                         "tipo_documento = ?, direccion = ?, telefono = ?, id_seguro = ? WHERE id_paciente = ?";

            int rowsAffected = jdbcTemplate.update(sql,
                    paciente.getNombre(),
                    paciente.getApellido(),
                    Date.valueOf(paciente.getFecha_nacimiento()),
                    paciente.getSexo(),
                    paciente.getTipo_documento(),
                    paciente.getDireccion(),
                    paciente.getTelefono(),
                    paciente.getId_seguro(),
                    paciente.getId_paciente());

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Long id_paciente) {
        System.out.println("Eliminando");
        try {
            String sql = "DELETE FROM paciente WHERE id_paciente = ?";
            int rowsAffected = jdbcTemplate.update(sql, id_paciente);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Paciente> mostrarPorSeguro(Long id_seguro) {
        String sql = "SELECT * FROM paciente WHERE id_seguro = ?";
        return jdbcTemplate.query(sql, new Object[]{id_seguro}, (rs, rowNum) -> new Paciente(
                rs.getLong("id_paciente"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getDate("fecha_nacimiento").toLocalDate(),
                rs.getString("sexo"),
                rs.getString("tipo_documento"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getLong("id_seguro")
        ));
    }
}