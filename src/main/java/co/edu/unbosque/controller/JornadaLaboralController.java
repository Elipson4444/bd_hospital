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

import co.edu.unbosque.entity.JornadaLaboral;
import co.edu.unbosque.repository.JornadaLaboralRepository;

@RestController
@RequestMapping("/jornada-laboral")
public class JornadaLaboralController {

    @Autowired
    private JornadaLaboralRepository repository;

    @GetMapping
    public List<JornadaLaboral> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        JornadaLaboral jornada = repository.mostrarPorId(id);
        if (jornada != null) {
            return ResponseEntity.ok(jornada);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody JornadaLaboral jornada) {
        return repository.guardar(jornada);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody JornadaLaboral jornada) {
        jornada.setId_jornada(id.intValue());
        return repository.actualizar(jornada);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
