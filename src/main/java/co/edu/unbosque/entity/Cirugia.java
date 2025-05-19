package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Cirugia {

    private Long id_cirugia;
    private Long id_paciente;
    private String nombre_paciente;
    private String apellido_paciente;
    private Long id_medico;
    private String nombre_medico;
    private String apellido_medico;
    private LocalDateTime fecha_hora;
    private String tipo_procedimiento;
    private String diagnostico;
    private String observaciones;

    


    public Cirugia() {
    }

    public Cirugia(Long id_cirugia, Long id_paciente, String nombre_paciente, String apellido_paciente, Long id_medico,
            String nombre_medico, String apellido_medico, LocalDateTime fecha_hora, String tipo_procedimiento,
            String diagnostico, String observaciones) {
        this.id_cirugia = id_cirugia;
        this.id_paciente = id_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paciente = apellido_paciente;
        this.id_medico = id_medico;
        this.nombre_medico = nombre_medico;
        this.apellido_medico = apellido_medico;
        this.fecha_hora = fecha_hora;
        this.tipo_procedimiento = tipo_procedimiento;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }

    public Cirugia(Long id_cirugia, Long id_paciente, Long id_medico, LocalDateTime fecha_hora,
            String tipo_procedimiento, String diagnostico, String observaciones) {
        this.id_cirugia = id_cirugia;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha_hora = fecha_hora;
        this.tipo_procedimiento = tipo_procedimiento;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }

    public Long getId_cirugia() {
        return id_cirugia;
    }

    public void setId_cirugia(Long id_cirugia) {
        this.id_cirugia = id_cirugia;
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

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getTipo_procedimiento() {
        return tipo_procedimiento;
    }

    public void setTipo_procedimiento(String tipo_procedimiento) {
        this.tipo_procedimiento = tipo_procedimiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
