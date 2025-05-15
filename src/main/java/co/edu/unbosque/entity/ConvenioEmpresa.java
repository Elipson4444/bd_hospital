package co.edu.unbosque.entity;

public class ConvenioEmpresa {

    private Long id_seguro_salud;
    private String nombre;
    private String contacto;


    
    public ConvenioEmpresa(Long id_seguro_salud, String nombre, String contacto) {
        this.id_seguro_salud = id_seguro_salud;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    
    public Long getId_seguro_salud() {
        return id_seguro_salud;
    }
    public void setId_seguro_salud(Long id_seguro_salud) {
        this.id_seguro_salud = id_seguro_salud;
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
