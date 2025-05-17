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

import co.edu.unbosque.entity.Reclamo;
import co.edu.unbosque.repository.ReclamoRepository;

@RestController
@RequestMapping("/reclamo")
public class ReclamoController {

    @Autowired
    private ReclamoRepository repository;

    @GetMapping
    public List<Reclamo> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerReclamo(@PathVariable int id) {
        Reclamo reclamo = repository.mostrarPorId(id);
        if (reclamo != null) {
            return ResponseEntity.ok(reclamo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Reclamo reclamo) {
        return repository.guardar(reclamo);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody Reclamo reclamo) {
        reclamo.setId_reclamo(id);
        return repository.actualizar(reclamo);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
