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

import co.edu.unbosque.entity.Antecedente;
import co.edu.unbosque.repository.AntecedenteRepository;

@RestController
@RequestMapping("/antecedente")
public class AntecedenteController {

    @Autowired
    private AntecedenteRepository repository;

    @GetMapping
    public List<Antecedente> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAntecedente(@PathVariable int id) {
        Antecedente antecedente = repository.mostrarPorId(id);
        if (antecedente != null) {
            return ResponseEntity.ok(antecedente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/historia/{id_historia}")
    public List<Antecedente> obtenerPorHistoria(@PathVariable int id_historia) {
        return repository.mostrarPorHistoria(id_historia);
    }

    @PostMapping
    public boolean crear(@RequestBody Antecedente antecedente) {
        return repository.guardar(antecedente);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody Antecedente antecedente) {
        antecedente.setId_af(id);
        return repository.actualizar(antecedente);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}