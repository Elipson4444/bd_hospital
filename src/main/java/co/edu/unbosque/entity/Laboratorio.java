package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Laboratorio {

    private Long id_laboratorio;
    private Long id_consulta;
    private String tipo_examen;
    private LocalDateTime fecha_hora_solicitud;
    private String resultado;
    private String observaciones;
    
    public Laboratorio(Long id_laboratorio, Long id_consulta, String tipo_examen, LocalDateTime fecha_hora_solicitud,
            String resultado, String observaciones) {
        this.id_laboratorio = id_laboratorio;
        this.id_consulta = id_consulta;
        this.tipo_examen = tipo_examen;
        this.fecha_hora_solicitud = fecha_hora_solicitud;
        this.resultado = resultado;
        this.observaciones = observaciones;
    }

    public Long getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(Long id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public Long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Long id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getTipo_examen() {
        return tipo_examen;
    }

    public void setTipo_examen(String tipo_examen) {
        this.tipo_examen = tipo_examen;
    }

    public LocalDateTime getFecha_hora_solicitud() {
        return fecha_hora_solicitud;
    }

    public void setFecha_hora_solicitud(LocalDateTime fecha_hora_solicitud) {
        this.fecha_hora_solicitud = fecha_hora_solicitud;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    


}
