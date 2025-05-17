package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.entity.Consulta;
import co.edu.unbosque.repository.ConsultaRepository;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @GetMapping
    public List<Consulta> obtenerTodas() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerConsultaPorId(@PathVariable Long id) {
        Consulta consulta = repository.mostrarPorId(id);
        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<Consulta> obtenerConsultasPorPaciente(@PathVariable Long idPaciente) {
        return repository.mostrarPorPaciente(idPaciente);
    }

    @GetMapping("/medico/{idMedico}")
    public List<Consulta> obtenerConsultasPorMedico(@PathVariable Long idMedico) {
        return repository.mostrarPorMedico(idMedico);
    }

    @GetMapping("/historia/{idHistoria}")
    public List<Consulta> obtenerConsultasPorHistoria(@PathVariable Long idHistoria) {
        return repository.mostrarPorHistoria(idHistoria);
    }

    @PostMapping
    public boolean crearConsulta(@RequestBody Consulta consulta) {
        return repository.guardar(consulta);
    }

    @PutMapping("/{id}")
    public boolean actualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        consulta.setId_consulta(id);
        return repository.actualizar(consulta);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarConsulta(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}