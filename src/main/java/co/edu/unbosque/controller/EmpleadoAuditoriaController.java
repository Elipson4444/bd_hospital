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

import co.edu.unbosque.entity.EmpleadosAuditoria;
import co.edu.unbosque.repository.EmpleadosAuditoriaRepository;

@RestController
@RequestMapping("/empleadosauditoria")
public class EmpleadoAuditoriaController {

    @Autowired
    private EmpleadosAuditoriaRepository repository;

    @GetMapping
    public List<EmpleadosAuditoria> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        EmpleadosAuditoria ea = repository.mostrarPorId(id);
        if (ea != null) {
            return ResponseEntity.ok(ea);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody EmpleadosAuditoria ea) {
        return repository.guardar(ea);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody EmpleadosAuditoria ea) {
        ea.setId_ea(id.intValue()); // Conversión de Long a int si id_ea es int
        return repository.actualizar(ea);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
