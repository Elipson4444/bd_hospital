package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Reclamo {
    private int id_reclamo;
    private LocalDateTime fecha_hora_reclamo;
    private String descripcion;
    private String area_responsable;
    private String estado;
    private String tipo;
    private int id_paciente;

    public Reclamo(int id_reclamo, LocalDateTime fecha_hora_reclamo, String descripcion, String area_responsable,
            String estado, String tipo, int id_paciente) {
        this.id_reclamo = id_reclamo;
        this.fecha_hora_reclamo = fecha_hora_reclamo;
        this.descripcion = descripcion;
        this.area_responsable = area_responsable;
        this.estado = estado;
        this.tipo = tipo;
        this.id_paciente = id_paciente;
    }

    public int getId_reclamo() {
        return id_reclamo;
    }

    public void setId_reclamo(int id_reclamo) {
        this.id_reclamo = id_reclamo;
    }

    public LocalDateTime getFecha_hora_reclamo() {
        return fecha_hora_reclamo;
    }

    public void setFecha_hora_reclamo(LocalDateTime fecha_hora_reclamo) {
        this.fecha_hora_reclamo = fecha_hora_reclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea_responsable() {
        return area_responsable;
    }

    public void setArea_responsable(String area_responsable) {
        this.area_responsable = area_responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    
    
    
}
