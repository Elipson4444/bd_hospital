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

import co.edu.unbosque.entity.JornadaDia;
import co.edu.unbosque.repository.JornadaDiaRepository;

@RestController
@RequestMapping("/jornada_dia")
public class JornadaDiaController {

    @Autowired
    private JornadaDiaRepository repository;

    @GetMapping
    public List<JornadaDia> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerJornadaDia(@PathVariable Long id) {
        JornadaDia jornadaDia = repository.mostrarPorId(id);
        if (jornadaDia != null) {
            return ResponseEntity.ok(jornadaDia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody JornadaDia jornadaDia) {
        return repository.guardar(jornadaDia);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody JornadaDia jornadaDia) {
        jornadaDia.setId_jornada(id);
        return repository.actualizar(jornadaDia);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
