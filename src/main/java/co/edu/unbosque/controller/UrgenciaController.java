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

import co.edu.unbosque.entity.Urgencia;
import co.edu.unbosque.repository.UrgenciaRepository;

@RestController
@RequestMapping("/urgencia")
public class UrgenciaController {

    @Autowired
    private UrgenciaRepository repository;

    @GetMapping
    public List<Urgencia> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUrgencia(@PathVariable Long id) {
        Urgencia urgencia = repository.mostrarPorId(id);
        if (urgencia != null) {
            return ResponseEntity.ok(urgencia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Urgencia urgencia) {
        return repository.guardar(urgencia);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody Urgencia urgencia) {
        urgencia.setId_urgencia(id);
        return repository.actualizar(urgencia);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
