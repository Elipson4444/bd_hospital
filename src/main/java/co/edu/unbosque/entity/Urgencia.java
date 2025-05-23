package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Urgencia {

    private Long id_urgencia;
    private Long id_paciencia;
    private LocalDateTime fecha_hora;
    private String motivo;
    private String acciones_realizadas;
    private String resultado;

    public Urgencia (){
    }
    
    public Urgencia(Long id_urgencia, Long id_paciencia, LocalDateTime fecha_hora, String motivo,
            String acciones_realizadas, String resultado) {
        this.id_urgencia = id_urgencia;
        this.id_paciencia = id_paciencia;
        this.fecha_hora = fecha_hora;
        this.motivo = motivo;
        this.acciones_realizadas = acciones_realizadas;
        this.resultado = resultado;
    }


    public Long getId_urgencia() {
        return id_urgencia;
    }


    public void setId_urgencia(Long id_urgencia) {
        this.id_urgencia = id_urgencia;
    }


    public Long getId_paciencia() {
        return id_paciencia;
    }


    public void setId_paciencia(Long id_paciencia) {
        this.id_paciencia = id_paciencia;
    }


    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }


    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


    public String getMotivo() {
        return motivo;
    }


    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public String getAcciones_realizadas() {
        return acciones_realizadas;
    }


    public void setAcciones_realizadas(String acciones_realizadas) {
        this.acciones_realizadas = acciones_realizadas;
    }


    public String getResultado() {
        return resultado;
    }


    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
    
    


}
