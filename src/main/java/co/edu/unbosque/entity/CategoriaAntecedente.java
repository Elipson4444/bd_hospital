package co.edu.unbosque.entity;

public class CategoriaAntecedente {

    private Long id_categoria_antecedente;
    private String nombre;

    public CategoriaAntecedente(Long id_categoria_antecedente, String nombre) {
        this.id_categoria_antecedente = id_categoria_antecedente;
        this.nombre = nombre;
    }

    public Long getId_categoria_antecedente() {
        return id_categoria_antecedente;
    }

    public void setId_categoria_antecedente(Long id_categoria_antecedente) {
        this.id_categoria_antecedente = id_categoria_antecedente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

}
