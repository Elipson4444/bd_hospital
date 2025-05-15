package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Cita {

    private Long id_cita;
    private Long id_paciente;
    private Long id_medico;
    private LocalDateTime fecha_hora_cita;
    private String estado;

    public Cita(Long id_cita, Long id_paciente, Long id_medico, LocalDateTime fecha_hora_cita, String estado) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha_hora_cita = fecha_hora_cita;
        this.estado = estado;
    }

    public Long getId_cita() {
        return id_cita;
    }

    public void setId_cita(Long id_cita) {
        this.id_cita = id_cita;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public LocalDateTime getFecha_hora_cita() {
        return fecha_hora_cita;
    }

    public void setFecha_hora_cita(LocalDateTime fecha_hora_cita) {
        this.fecha_hora_cita = fecha_hora_cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
