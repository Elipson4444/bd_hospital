package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.entity.Prescripcion;
import co.edu.unbosque.repository.PrescripcionRepository;

@RestController
@RequestMapping("/prescripcion")
public class PrescripcionController {

    @Autowired
    private PrescripcionRepository repository;

    @GetMapping
    public List<Prescripcion> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPrescripcion(@PathVariable int id) {
        Prescripcion prescripcion = repository.mostrarPorId(id);
        if (prescripcion != null) {
            return ResponseEntity.ok(prescripcion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Prescripcion prescripcion) {
        return repository.guardar(prescripcion);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody Prescripcion prescripcion) {
        prescripcion.setId_prescripcion(id);
        return repository.actualizar(prescripcion);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
