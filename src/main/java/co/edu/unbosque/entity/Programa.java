package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Programa {

    private Long id_programa;
    private String nombre;
    private String institucion;
    private LocalDateTime fecha_hora_inicio;
    private LocalDateTime fecha_hora_fin;
    private String estado;

    public Programa(Long id_programa, String nombre, String institucion, LocalDateTime fecha_hora_inicio,
            LocalDateTime fecha_hora_fin, String estado) {
        this.id_programa = id_programa;
        this.nombre = nombre;
        this.institucion = institucion;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.estado = estado;
    }

    public Long getId_programa() {
        return id_programa;
    }

    public void setId_programa(Long id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public LocalDateTime getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(LocalDateTime fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public LocalDateTime getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(LocalDateTime fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
