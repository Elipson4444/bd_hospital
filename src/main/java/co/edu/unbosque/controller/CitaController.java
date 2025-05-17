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

import co.edu.unbosque.entity.Cita;
import co.edu.unbosque.repository.CitaRepository;

@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaRepository repository;

    @GetMapping
    public List<Cita> obtenerTodas() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCitaPorId(@PathVariable Long id) {
        Cita cita = repository.mostrarPorId(id);
        if (cita != null) {
            return ResponseEntity.ok(cita);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<Cita> obtenerCitasPorPaciente(@PathVariable Long idPaciente) {
        return repository.mostrarPorPaciente(idPaciente);
    }

    @GetMapping("/medico/{idMedico}")
    public List<Cita> obtenerCitasPorMedico(@PathVariable Long idMedico) {
        return repository.mostrarPorMedico(idMedico);
    }

    @GetMapping("/estado/{estado}")
    public List<Cita> obtenerCitasPorEstado(@PathVariable String estado) {
        return repository.mostrarPorEstado(estado);
    }

    @PostMapping
    public boolean crearCita(@RequestBody Cita cita) {
        return repository.guardar(cita);
    }

    @PutMapping("/{id}")
    public boolean actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
        cita.setId_cita(id);
        return repository.actualizar(cita);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarCita(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}