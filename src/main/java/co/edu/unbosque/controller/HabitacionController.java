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

import co.edu.unbosque.entity.Habitacion;
import co.edu.unbosque.repository.HabitacionRepository;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionRepository repository;

    @GetMapping
    public List<Habitacion> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerHabitacion(@PathVariable Long id) {
        Habitacion habitacion = repository.mostrarPorId(id);
        if (habitacion != null) {
            return ResponseEntity.ok(habitacion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Habitacion habitacion) {
        return repository.guardar(habitacion);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        habitacion.setId_habitacion(id);
        return repository.actualizar(habitacion);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
