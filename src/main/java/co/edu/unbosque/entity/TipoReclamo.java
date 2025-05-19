package co.edu.unbosque.entity;

public class TipoReclamo {

    private int id_tpreclamo;
    private String tipo;

    public TipoReclamo (){
    }

    public TipoReclamo(int id_tpreclamo, String tipo) {
        this.id_tpreclamo = id_tpreclamo;
        this.tipo = tipo;
    }

    public int getId_tpreclamo() {
        return id_tpreclamo;
    }

    public void setId_tpreclamo(int id_tpreclamo) {
        this.id_tpreclamo = id_tpreclamo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
