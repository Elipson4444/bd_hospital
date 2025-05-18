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

import co.edu.unbosque.entity.TipoReclamo;
import co.edu.unbosque.repository.TipoReclamoRepository;

@RestController
@RequestMapping("/tiporeclamo")
public class TipoReclamoController {

    @Autowired
    private TipoReclamoRepository repository;

    @GetMapping
    public List<TipoReclamo> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        TipoReclamo tipo = repository.mostrarPorId(id);
        if (tipo != null) {
            return ResponseEntity.ok(tipo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody TipoReclamo tipoReclamo) {
        return repository.guardar(tipoReclamo);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody TipoReclamo tipoReclamo) {
        tipoReclamo.setId_tpreclamo(id);
        return repository.actualizar(tipoReclamo);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
