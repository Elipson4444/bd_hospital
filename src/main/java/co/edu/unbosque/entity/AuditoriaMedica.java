package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class AuditoriaMedica {

    private int id_auditoria;
    private LocalDateTime fecha_hora_inicio;
    private LocalDateTime fecha_hora_fin;
    private String tipo_auditoria;
    private String hallazgos;
    private String estado;
    private int id_empleado;

    public AuditoriaMedica (){
    }
    
    public AuditoriaMedica(int id_auditoria, LocalDateTime fecha_hora_inicio, LocalDateTime fecha_hora_fin,
            String tipo_auditoria, String hallazgos, String estado, int id_empleado) {
        this.id_auditoria = id_auditoria;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.tipo_auditoria = tipo_auditoria;
        this.hallazgos = hallazgos;
        this.estado = estado;
        this.id_empleado = id_empleado;
    }

    public int getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public LocalDateTime getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(LocalDateTime fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public LocalDateTime getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(LocalDateTime fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public String getTipo_auditoria() {
        return tipo_auditoria;
    }

    public void setTipo_auditoria(String tipo_auditoria) {
        this.tipo_auditoria = tipo_auditoria;
    }

    public String getHallazgos() {
        return hallazgos;
    }

    public void setHallazgos(String hallazgos) {
        this.hallazgos = hallazgos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    

}
