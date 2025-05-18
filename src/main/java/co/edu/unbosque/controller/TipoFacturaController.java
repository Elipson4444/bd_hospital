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

import co.edu.unbosque.entity.TipoFactura;
import co.edu.unbosque.repository.TipoFacturaRepository;

@RestController
@RequestMapping("/tipo-factura")
public class TipoFacturaController {

    @Autowired
    private TipoFacturaRepository repository;

    @GetMapping
    public List<TipoFactura> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        TipoFactura tipoFactura = repository.mostrarPorId(id);
        if (tipoFactura != null) {
            return ResponseEntity.ok(tipoFactura);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody TipoFactura tipoFactura) {
        return repository.guardar(tipoFactura);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody TipoFactura tipoFactura) {
        tipoFactura.setId_tipo(id);
        return repository.actualizar(tipoFactura);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
