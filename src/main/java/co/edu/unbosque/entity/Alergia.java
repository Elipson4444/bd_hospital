package co.edu.unbosque.entity;

public class Alergias {

    private int id_al;
    private String descripcionl;
    private long id_historia;

    public Alergias(int id_al, String descripcionl, long id_historia) {
        this.id_al = id_al;
        this.descripcionl = descripcionl;
        this.id_historia = id_historia;
    }

    public int getId_al() {
        return id_al;
    }

    public void setId_al(int id_al) {
        this.id_al = id_al;
    }

    public String getDescripcionl() {
        return descripcionl;
    }

    public void setDescripcionl(String descripcionl) {
        this.descripcionl = descripcionl;
    }

    public long getId_historia() {
        return id_historia;
    }

    public void setId_historia(long id_historia) {
        this.id_historia = id_historia;
    }

    
    

}
