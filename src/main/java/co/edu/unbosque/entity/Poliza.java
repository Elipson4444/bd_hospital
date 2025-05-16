package co.edu.unbosque.entity;

public class Poliza {

    private int id_poliza;
    private String nombre;
    private String contacto;
    
    public Poliza(int id_poliza, String nombre, String contacto) {
        this.id_poliza = id_poliza;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public int getId_poliza() {
        return id_poliza;
    }

    public void setId_poliza(int id_poliza) {
        this.id_poliza = id_poliza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    

}
