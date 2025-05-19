package co.edu.unbosque.entity;

public class Antecedente {

    private int id_af;
    private String descripcion;
    private String tipo;
    private int id_historia;

    
    
    public Antecedente() {
    }



    public Antecedente(int id_af, String descripcion, String tipo, int id_historia) {
        this.id_af = id_af;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.id_historia = id_historia;
    }


    public int getId_af() {
        return id_af;
    }


    public void setId_af(int id_af) {
        this.id_af = id_af;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getId_historia() {
        return id_historia;
    }


    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }


    

    



    


    
    
}
