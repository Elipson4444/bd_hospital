package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Cita {

    private Long id_cita;
    private Long id_paciente;
    private String nombre_paciente;
    private String apellido_paciente;
    private Long id_medico;
    private String nombre_medico;
    private String apellido_medico;
    private LocalDateTime fecha_hora_cita;
    private String estado;

    public Cita (){
    }

    public Cita(Long id_cita, Long id_paciente, String nombre_paciente, String apellido_paciente, Long id_medico,
            String nombre_medico, String apellido_medico, LocalDateTime fecha_hora_cita, String estado) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paciente = apellido_paciente;
        this.id_medico = id_medico;
        this.nombre_medico = nombre_medico;
        this.apellido_medico = apellido_medico;
        this.fecha_hora_cita = fecha_hora_cita;
        this.estado = estado;
    }

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

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getApellido_medico() {
        return apellido_medico;
    }

    public void setApellido_medico(String apellido_medico) {
        this.apellido_medico = apellido_medico;
    }

    
    
}
