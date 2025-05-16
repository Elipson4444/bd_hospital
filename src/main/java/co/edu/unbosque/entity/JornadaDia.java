package co.edu.unbosque.entity;

public class JornadaDia {

    private Long id_jornada;
    private String dia_semana;

    public JornadaDia(Long id_jornada, String dia_semana) {
        this.id_jornada = id_jornada;
        this.dia_semana = dia_semana;
    }

    public Long getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(Long id_jornada) {
        this.id_jornada = id_jornada;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }
}