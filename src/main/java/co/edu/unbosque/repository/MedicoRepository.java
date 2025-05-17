package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Medico;

@Repository
public class MedicoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Medico> mostrarTodo() {
        String sql = "SELECT * FROM medico";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Medico(
                rs.getLong("id_medico"),
                rs.getLong("numero_licencia"),
                rs.getString("especialidad"),
                rs.getInt("experiencia"),
                rs.getString("universidad"),
                rs.getLong("id_empleado")
        ));
    }

    public Medico mostrarPorId(Long id_medico) {
        String sql = "SELECT * FROM medico WHERE id_medico = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_medico }, (rs, rowNum) -> new Medico(
                rs.getLong("id_medico"),
                rs.getLong("numero_licencia"),
                rs.getString("especialidad"),
                rs.getInt("experiencia"),
                rs.getString("universidad"),
                rs.getLong("id_empleado")
        ));
    }

    public boolean guardar(Medico medico) {
        try {
            Long nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_medico), 0) + 1 FROM medico", Long.class);

            String sql = "INSERT INTO medico (id_medico, numero_licencia, especialidad, experiencia, universidad, id_empleado) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    medico.getNumero_licencia(),
                    medico.getEspecialidad(),
                    medico.getExperiencia(),
                    medico.getUniversidad(),
                    medico.getId_empleado()
            );

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Medico medico) {
        try {
            String sql = "UPDATE medico SET numero_licencia = ?, especialidad = ?, experiencia = ?, universidad = ?, id_empleado = ? " +
                         "WHERE id_medico = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    medico.getNumero_licencia(),
                    medico.getEspecialidad(),
                    medico.getExperiencia(),
                    medico.getUniversidad(),
                    medico.getId_empleado(),
                    medico.getId_medico()
            );
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            String sql = "DELETE FROM medico WHERE id_medico = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
