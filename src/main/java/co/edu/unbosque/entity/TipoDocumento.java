package co.edu.unbosque.entity;

public class TipoDocumento {
    private int id_tpdocumento;
    private String tipo;
    
    public TipoDocumento(int id_tpdocumento, String tipo) {
        this.id_tpdocumento = id_tpdocumento;
        this.tipo = tipo;
    }

    public int getId_tpdocumento() {
        return id_tpdocumento;
    }

    public void setId_tpdocumento(int id_tpdocumento) {
        this.id_tpdocumento = id_tpdocumento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
