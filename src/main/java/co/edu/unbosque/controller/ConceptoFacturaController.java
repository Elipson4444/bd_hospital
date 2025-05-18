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

import co.edu.unbosque.entity.ConceptoFactura;
import co.edu.unbosque.repository.ConceptoFacturaRepository;

@RestController
@RequestMapping("/concepto-factura")
public class ConceptoFacturaController {

    @Autowired
    private ConceptoFacturaRepository repository;

    @GetMapping
    public List<ConceptoFactura> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerConcepto(@PathVariable int id) {
        ConceptoFactura concepto = repository.mostrarPorId(id);
        if (concepto != null) {
            return ResponseEntity.ok(concepto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody ConceptoFactura concepto) {
        return repository.guardar(concepto);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody ConceptoFactura concepto) {
        concepto.setId_concepto(id);
        return repository.actualizar(concepto);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
