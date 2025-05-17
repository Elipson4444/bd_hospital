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

import co.edu.unbosque.entity.HistoriaClinica;
import co.edu.unbosque.repository.HistoriaClinicaRepository;

@RestController
@RequestMapping("/historia-clinica")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaRepository repository;

    @GetMapping
    public List<HistoriaClinica> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerHistoriaClinica(@PathVariable Long id) {
        HistoriaClinica historiaClinica = repository.mostrarPorId(id);
        if (historiaClinica != null) {
            return ResponseEntity.ok(historiaClinica);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paciente/{id_paciente}")
    public List<HistoriaClinica> obtenerPorPaciente(@PathVariable Long id_paciente) {
        return repository.mostrarPorPaciente(id_paciente);
    }

    @PostMapping
    public boolean crear(@RequestBody HistoriaClinica historiaClinica) {
        return repository.guardar(historiaClinica);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        historiaClinica.setId_historia(id);
        return repository.actualizar(historiaClinica);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}