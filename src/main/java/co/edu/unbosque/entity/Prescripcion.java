package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Prescripcion {

    private int id_prescripcion;
    private Long id_consulta;
    private LocalDateTime fecha_hora;
    private String indicaciones_generales;

    public Prescripcion (){
    }


    public Prescripcion(int id_prescripcion, Long id_consulta, LocalDateTime fecha_hora,
            String indicaciones_generales) {
        this.id_prescripcion = id_prescripcion;
        this.id_consulta = id_consulta;
        this.fecha_hora = fecha_hora;
        this.indicaciones_generales = indicaciones_generales;
    }


    public int getId_prescripcion() {
        return id_prescripcion;
    }


    public void setId_prescripcion(int id_prescripcion) {
        this.id_prescripcion = id_prescripcion;
    }


    public Long getId_consulta() {
        return id_consulta;
    }


    public void setId_consulta(Long id_consulta) {
        this.id_consulta = id_consulta;
    }


    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }


    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


    public String getIndicaciones_generales() {
        return indicaciones_generales;
    }


    public void setIndicaciones_generales(String indicaciones_generales) {
        this.indicaciones_generales = indicaciones_generales;
    }

    
    

}
