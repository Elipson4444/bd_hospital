package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class JornadaLaboral {

    private int id_jornada;
    private LocalDateTime fecha_hora_inicio;
    private LocalDateTime fecha_hora_cierre;
    private int id_empleado;

    
    public JornadaLaboral(int id_jornada, LocalDateTime fecha_hora_inicio, LocalDateTime fecha_hora_cierre,
            int id_empleado) {
        this.id_jornada = id_jornada;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_cierre = fecha_hora_cierre;
        this.id_empleado = id_empleado;
    }


    public int getId_jornada() {
        return id_jornada;
    }


    public void setId_jornada(int id_jornada) {
        this.id_jornada = id_jornada;
    }


    public LocalDateTime getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }


    public void setFecha_hora_inicio(LocalDateTime fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }


    public LocalDateTime getFecha_hora_cierre() {
        return fecha_hora_cierre;
    }


    public void setFecha_hora_cierre(LocalDateTime fecha_hora_cierre) {
        this.fecha_hora_cierre = fecha_hora_cierre;
    }


    public int getId_empleado() {
        return id_empleado;
    }


    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }


    

}
