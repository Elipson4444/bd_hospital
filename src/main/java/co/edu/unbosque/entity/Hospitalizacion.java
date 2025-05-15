package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Hospitalizacion {

    private Long id_hospitalizacion;
    private Long id_paciente;
    private Long id_habitacion;
    private LocalDateTime fecha_hora_ingresa;
    private LocalDateTime fecha_hora_egreso;
    private String motivo;
    
    public Hospitalizacion(Long id_hospitalizacion, Long id_paciente, Long id_habitacion,
            LocalDateTime fecha_hora_ingresa, LocalDateTime fecha_hora_egreso, String motivo) {
        this.id_hospitalizacion = id_hospitalizacion;
        this.id_paciente = id_paciente;
        this.id_habitacion = id_habitacion;
        this.fecha_hora_ingresa = fecha_hora_ingresa;
        this.fecha_hora_egreso = fecha_hora_egreso;
        this.motivo = motivo;
    }

    public Long getId_hospitalizacion() {
        return id_hospitalizacion;
    }

    public void setId_hospitalizacion(Long id_hospitalizacion) {
        this.id_hospitalizacion = id_hospitalizacion;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Long getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Long id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public LocalDateTime getFecha_hora_ingresa() {
        return fecha_hora_ingresa;
    }

    public void setFecha_hora_ingresa(LocalDateTime fecha_hora_ingresa) {
        this.fecha_hora_ingresa = fecha_hora_ingresa;
    }

    public LocalDateTime getFecha_hora_egreso() {
        return fecha_hora_egreso;
    }

    public void setFecha_hora_egreso(LocalDateTime fecha_hora_egreso) {
        this.fecha_hora_egreso = fecha_hora_egreso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
