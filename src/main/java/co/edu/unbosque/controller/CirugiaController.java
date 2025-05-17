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

import co.edu.unbosque.entity.Cirugia;
import co.edu.unbosque.repository.CirugiaRepository;

@RestController
@RequestMapping("/cirugia")
public class CirugiaController {

    @Autowired
    private CirugiaRepository repository;

    @GetMapping
    public List<Cirugia> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCirugia(@PathVariable Long id) {
        Cirugia cirugia = repository.mostrarPorId(id);
        if (cirugia != null) {
            return ResponseEntity.ok(cirugia);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<Cirugia> obtenerPorPaciente(@PathVariable Long idPaciente) {
        return repository.mostrarPorPaciente(idPaciente);
    }

    @GetMapping("/medico/{idMedico}")
    public List<Cirugia> obtenerPorMedico(@PathVariable Long idMedico) {
        return repository.mostrarPorMedico(idMedico);
    }

    @PostMapping
    public boolean crear(@RequestBody Cirugia cirugia) {
        return repository.guardar(cirugia);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody Cirugia cirugia) {
        cirugia.setId_cirugia(id);
        return repository.actualizar(cirugia);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}