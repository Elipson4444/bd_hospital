package co.edu.unbosque.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Diagnostico;

@Repository
public class DiagnosticoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Diagnostico> mostrarTodo() {
        String sql = "SELECT * FROM diagnostico";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Diagnostico(
                rs.getInt("id_diagnostico"),
                rs.getString("diagnostico_ingreso"),
                rs.getString("diagnostico_egreso"),
                rs.getInt("id_paciento")
        ));
    }

    public Diagnostico mostrarPorId(int id_diagnostico) {
        String sql = "SELECT * FROM diagnostico WHERE id_diagnostico = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id_diagnostico }, (rs, rowNum) -> new Diagnostico(
                rs.getInt("id_diagnostico"),
                rs.getString("diagnostico_ingreso"),
                rs.getString("diagnostico_egreso"),
                rs.getInt("id_paciento")
        ));
    }

    public boolean guardar(Diagnostico diagnostico) {
        try {
            Integer nextId = jdbcTemplate.queryForObject(
                "SELECT NVL(MAX(id_diagnostico), 0) + 1 FROM diagnostico", Integer.class);

            String sql = "INSERT INTO diagnostico (id_diagnostico, diagnostico_ingreso, diagnostico_egreso, id_paciento) VALUES (?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    nextId,
                    diagnostico.getDiagnostico_ingreso(),
                    diagnostico.getDiagnostico_egreso(),
                    diagnostico.getId_paciento());

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Diagnostico diagnostico) {
        try {
            String sql = "UPDATE diagnostico SET diagnostico_ingreso = ?, diagnostico_egreso = ?, id_paciento = ? WHERE id_diagnostico = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                    diagnostico.getDiagnostico_ingreso(),
                    diagnostico.getDiagnostico_egreso(),
                    diagnostico.getId_paciento(),
                    diagnostico.getId_diagnostico());
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM diagnostico WHERE id_diagnostico = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
