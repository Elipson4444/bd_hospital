package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Consulta {

    private Long id_consulta;
    private Long id_paciente;
    private Long id_medico;
    private Long id_historia;
    private LocalDateTime fecha_hora_creacion;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;

    public Consulta (){
    }

    public Consulta(Long id_consulta, Long id_paciente, Long id_medico, Long id_historia,
            LocalDateTime fecha_hora_creacion, String motivo, String diagnostico, String tratamiento,
            String observaciones) {
        this.id_consulta = id_consulta;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.id_historia = id_historia;
        this.fecha_hora_creacion = fecha_hora_creacion;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public Long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Long id_consulta) {
        this.id_consulta = id_consulta;
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

    public Long getId_historia() {
        return id_historia;
    }

    public void setId_historia(Long id_historia) {
        this.id_historia = id_historia;
    }

    public LocalDateTime getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }

    public void setFecha_hora_creacion(LocalDateTime fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    

    

}
