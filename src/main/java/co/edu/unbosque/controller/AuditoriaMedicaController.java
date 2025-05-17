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

import co.edu.unbosque.entity.AuditoriaMedica;
import co.edu.unbosque.repository.AuditoriaMedicaRepository;

@RestController
@RequestMapping("/auditoria-medica")
public class AuditoriaMedicaController {

    @Autowired
    private AuditoriaMedicaRepository repository;

    @GetMapping
    public List<AuditoriaMedica> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAuditoria(@PathVariable int id) {
        AuditoriaMedica auditoria = repository.mostrarPorId(id);
        if (auditoria != null) {
            return ResponseEntity.ok(auditoria);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/empleado/{id_empleado}")
    public List<AuditoriaMedica> obtenerPorEmpleado(@PathVariable int id_empleado) {
        return repository.mostrarPorEmpleado(id_empleado);
    }

    @PostMapping
    public boolean crear(@RequestBody AuditoriaMedica auditoria) {
        return repository.guardar(auditoria);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody AuditoriaMedica auditoria) {
        auditoria.setId_auditoria(id);
        return repository.actualizar(auditoria);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}