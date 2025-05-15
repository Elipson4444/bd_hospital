package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.entity.SeguroSalud;
import co.edu.unbosque.repository.SeguroSaludRepository;

@RestController
@RequestMapping("/seguro-salud")
public class SeguroSaludController {

    @Autowired
    private SeguroSaludRepository repository;

    @GetMapping
    public List<SeguroSalud> obtenerTodos() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public SeguroSalud obtenerSeguro(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public String crear(@RequestBody SeguroSalud seguro) {
        Long idGenerado = repository.save(seguro);
        return "Seguro de salud creado correctamente con ID: " + idGenerado;
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id, @RequestBody SeguroSalud seguro) {
        seguro.setId_seguro(id);
        repository.update(seguro);
        return "Seguro de salud con ID: " + id + " actualizado correctamente";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.delete(id);
        return "Seguro de salud con ID: " + id + " eliminado correctamente";
    }
}