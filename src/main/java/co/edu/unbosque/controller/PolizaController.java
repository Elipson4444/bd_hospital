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

import co.edu.unbosque.entity.Poliza;
import co.edu.unbosque.repository.PolizaRepository;

@RestController
@RequestMapping("/poliza")
public class PolizaController {

    @Autowired
    private PolizaRepository repository;

    @GetMapping
    public List<Poliza> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPoliza(@PathVariable Long id) {
        Poliza poliza = repository.mostrarPorId(id);
        if (poliza != null) {
            return ResponseEntity.ok(poliza);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody Poliza poliza) {
        return repository.guardar(poliza);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody Poliza poliza) {
        poliza.setId_poliza(id.intValue()); // Conversión de Long a int
        return repository.actualizar(poliza);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
