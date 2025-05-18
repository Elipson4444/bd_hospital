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

import co.edu.unbosque.entity.TipoDocumento;
import co.edu.unbosque.repository.TipoDocumentoRepository;

@RestController
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoRepository repository;

    @GetMapping
    public List<TipoDocumento> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        TipoDocumento tipoDocumento = repository.mostrarPorId(id);
        if (tipoDocumento != null) {
            return ResponseEntity.ok(tipoDocumento);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody TipoDocumento tipoDocumento) {
        return repository.guardar(tipoDocumento);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody TipoDocumento tipoDocumento) {
        tipoDocumento.setId_tpdocumento(id);
        return repository.actualizar(tipoDocumento);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}
