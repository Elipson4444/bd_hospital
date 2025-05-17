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

import co.edu.unbosque.entity.Hospitalizacion;
import co.edu.unbosque.repository.HospitalizacionRepository;

@RestController
@RequestMapping("/hospitalizacion")
public class HospitalizacionController {

    @Autowired
    private HospitalizacionRepository repository;

    @GetMapping
    public List<Hospitalizacion> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerHospitalizacion(@PathVariable Long id) {
        Hospitalizacion hospitalizacion = repository.mostrarPorId(id);
        if (hospitalizacion != null) {
            return ResponseEntity.ok(hospitalizacion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Hospitalizacion hospitalizacion) {
        return repository.guardar(hospitalizacion);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody Hospitalizacion hospitalizacion) {
        hospitalizacion.setId_hospitalizacion(id);
        return repository.actualizar(hospitalizacion);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
