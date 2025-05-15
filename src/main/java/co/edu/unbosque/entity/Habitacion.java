package co.edu.unbosque.entity;

public class Habitacion {
     private Long id_habitacion;

    private int numero;

    private int piso;

    private String estado;

    public Habitacion(Long id_habitacion, int numero, int piso, String estado) {
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
    }

    public Long getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Long id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
