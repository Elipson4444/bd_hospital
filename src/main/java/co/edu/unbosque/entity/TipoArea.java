package co.edu.unbosque.entity;

public class TipoArea {

    private int id_tparea;
    private String tipo;

    public TipoArea (){
    }

    public TipoArea(int id_tparea, String tipo) {
        this.id_tparea = id_tparea;
        this.tipo = tipo;
    }


    public int getId_tparea() {
        return id_tparea;
    }


    public void setId_tparea(int id_tparea) {
        this.id_tparea = id_tparea;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

}
