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

import co.edu.unbosque.entity.Programa;
import co.edu.unbosque.repository.ProgramaRepository;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaRepository repository;

    @GetMapping
    public List<Programa> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPrograma(@PathVariable Long id) {
        Programa programa = repository.mostrarPorId(id);
        if (programa != null) {
            return ResponseEntity.ok(programa);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Programa programa) {
        return repository.guardar(programa);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody Programa programa) {
        programa.setId_programa(id);
        return repository.actualizar(programa);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
