package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class InscripcionPrograma {

    private Long id_inscripcion;
    private Long id_paciente;
    private Long id_programa;
    private Long id_empleado;
    private LocalDateTime fecha_hora_inscripcion;


    
    public InscripcionPrograma(Long id_inscripcion, Long id_paciente, Long id_programa, Long id_empleado,
            LocalDateTime fecha_hora_inscripcion) {
        this.id_inscripcion = id_inscripcion;
        this.id_paciente = id_paciente;
        this.id_programa = id_programa;
        this.id_empleado = id_empleado;
        this.fecha_hora_inscripcion = fecha_hora_inscripcion;
    }
    
    public Long getId_inscripcion() {
        return id_inscripcion;
    }
    public void setId_inscripcion(Long id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }
    public Long getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }
    public Long getId_programa() {
        return id_programa;
    }
    public void setId_programa(Long id_programa) {
        this.id_programa = id_programa;
    }
    public Long getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }
    public LocalDateTime getFecha_hora_inscripcion() {
        return fecha_hora_inscripcion;
    }
    public void setFecha_hora_inscripcion(LocalDateTime fecha_hora_inscripcion) {
        this.fecha_hora_inscripcion = fecha_hora_inscripcion;
    }

    
    

}
