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

import co.edu.unbosque.entity.Alergia;
import co.edu.unbosque.repository.AlergiaRepository;

@RestController
@RequestMapping("/alergia")
public class AlergiaController {

    @Autowired
    private AlergiaRepository repository;

    @GetMapping
    public List<Alergia> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlergia(@PathVariable int id) {
        Alergia alergia = repository.mostrarPorId(id);
        if (alergia != null) {
            return ResponseEntity.ok(alergia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Alergia alergia) {
        return repository.guardar(alergia);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody Alergia alergia) {
        alergia.setId_al(id);
        return repository.actualizar(alergia);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
