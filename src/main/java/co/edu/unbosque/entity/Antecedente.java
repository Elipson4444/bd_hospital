package co.edu.unbosque.entity;

public class Antecedente {

    private Long id_antecedente;
    private Long id_historia;
    private String descripcion;
    private Long categoria;


    public Antecedente(Long id_antecedente, Long id_historia, String descripcion, Long categoria) {
        this.id_antecedente = id_antecedente;
        this.id_historia = id_historia;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }


    public Long getId_antecedente() {
        return id_antecedente;
    }


    public void setId_antecedente(Long id_antecedente) {
        this.id_antecedente = id_antecedente;
    }


    public Long getId_historia() {
        return id_historia;
    }


    public void setId_historia(Long id_historia) {
        this.id_historia = id_historia;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Long getCategoria() {
        return categoria;
    }


    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }


    
    
}
