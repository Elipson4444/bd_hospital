package co.edu.unbosque.entity;

public class SeguroSalud {
    private Long id_seguro;
    private String nombre;
    private String tipo;
    private String cobertura;
    private String contacto;

    public SeguroSalud(Long id_seguro, String nombre, String tipo, String cobertura, String contacto) {
        this.id_seguro = id_seguro;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cobertura = cobertura;
        this.contacto = contacto;
    }

    public Long getId_seguro() {
        return id_seguro;
    }

    public void setId_seguro(Long id_seguro) {
        this.id_seguro = id_seguro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

}
