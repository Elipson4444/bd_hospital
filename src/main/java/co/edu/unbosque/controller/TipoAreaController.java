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

import co.edu.unbosque.entity.TipoArea;
import co.edu.unbosque.repository.TipoAreaRepository;

@RestController
@RequestMapping("/tipoarea")
public class TipoAreaController {

    @Autowired
    private TipoAreaRepository repository;

    @GetMapping
    public List<TipoArea> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTipoArea(@PathVariable int id) {
        TipoArea tipoArea = repository.mostrarPorId(id);
        if (tipoArea != null) {
            return ResponseEntity.ok(tipoArea);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody TipoArea tipoArea) {
        return repository.guardar(tipoArea);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody TipoArea tipoArea) {
        tipoArea.setId_tparea(id);
        return repository.actualizar(tipoArea);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
