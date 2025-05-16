package co.edu.unbosque.entity;

public class Alergias {

    private int id_al;
    private String descripcion;
    private int id_historia;

    public Alergias(int id_al, String descripcion, int id_historia) {
        this.id_al = id_al;
        this.descripcion = descripcion;
        this.id_historia = id_historia;
    }

    public int getId_al() {
        return id_al;
    }
    public void setId_al(int id_al) {
        this.id_al = id_al;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getId_historia() {
        return id_historia;
    }
    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    



}
