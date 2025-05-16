package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Factura {

    private Long id_factura;
    private Long id_paciente;
    private LocalDateTime fecha_hora_emision;
    private Long total;
    private String metodo_pago;
    private String estado;
    
    public Factura(Long id_factura, Long id_paciente, LocalDateTime fecha_hora_emision, Long total, String metodo_pago,
            String estado) {
        this.id_factura = id_factura;
        this.id_paciente = id_paciente;
        this.fecha_hora_emision = fecha_hora_emision;
        this.total = total;
        this.metodo_pago = metodo_pago;
        this.estado = estado;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public LocalDateTime getFecha_hora_emision() {
        return fecha_hora_emision;
    }

    public void setFecha_hora_emision(LocalDateTime fecha_hora_emision) {
        this.fecha_hora_emision = fecha_hora_emision;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    

}
