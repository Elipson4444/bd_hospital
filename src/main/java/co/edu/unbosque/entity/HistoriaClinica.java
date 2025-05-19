package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class HistoriaClinica {

    private Long id_historia;
    private Long id_paciente;
    private LocalDateTime fecha_hora_creacion;
    private String observaciones;

    public HistoriaClinica (){
    }

    public HistoriaClinica(Long id_historia, Long id_paciente, LocalDateTime fecha_hora_creacion,
            String observaciones) {
        this.id_historia = id_historia;
        this.id_paciente = id_paciente;
        this.fecha_hora_creacion = fecha_hora_creacion;
        this.observaciones = observaciones;
    }

    public Long getId_historia() {
        return id_historia;
    }

    public void setId_historia(Long id_historia) {
        this.id_historia = id_historia;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public LocalDateTime getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }

    public void setFecha_hora_creacion(LocalDateTime fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    

    

}
