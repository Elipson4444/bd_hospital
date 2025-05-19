package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class EventoAdverso {

    private Long id_evento;
    private LocalDateTime fecha_hora_evento;
    private String tipo_evento;
    private String gravedad;
    private String ubicacion;
    private String estado;
    private String acciones_tomadas;
    private Long id_paciente;

    public EventoAdverso (){
    }

    public EventoAdverso(Long id_evento, LocalDateTime fecha_hora_evento, String tipo_evento, String gravedad,
            String ubicacion, String estado, String acciones_tomadas, Long id_paciente) {
        this.id_evento = id_evento;
        this.fecha_hora_evento = fecha_hora_evento;
        this.tipo_evento = tipo_evento;
        this.gravedad = gravedad;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.acciones_tomadas = acciones_tomadas;
        this.id_paciente = id_paciente;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public LocalDateTime getFecha_hora_evento() {
        return fecha_hora_evento;
    }

    public void setFecha_hora_evento(LocalDateTime fecha_hora_evento) {
        this.fecha_hora_evento = fecha_hora_evento;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAcciones_tomadas() {
        return acciones_tomadas;
    }

    public void setAcciones_tomadas(String acciones_tomadas) {
        this.acciones_tomadas = acciones_tomadas;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }
}
