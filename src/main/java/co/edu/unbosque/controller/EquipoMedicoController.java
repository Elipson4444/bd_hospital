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

import co.edu.unbosque.entity.EquipoMedico;
import co.edu.unbosque.repository.EquipoMedicoRepository;

@RestController
@RequestMapping("/equipo-medico")
public class EquipoMedicoController {

    @Autowired
    private EquipoMedicoRepository repository;

    @GetMapping
    public List<EquipoMedico> obtenerTodos() {
        return repository.mostrarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEquipoMedico(@PathVariable Long id) {
        EquipoMedico equipo = repository.mostrarPorId(id);
        if (equipo != null) {
            return ResponseEntity.ok(equipo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public boolean crear(@RequestBody EquipoMedico equipo) {
        return repository.guardar(equipo);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable Long id, @RequestBody EquipoMedico equipo) {
        equipo.setId_equipo_medico(id);
        return repository.actualizar(equipo);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return repository.eliminar(id);
    }
}
