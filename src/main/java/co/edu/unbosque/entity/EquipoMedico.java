package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class EquipoMedico {

    private Long id_equipo_medico;
    private String nombre;
    private String marca;
    private LocalDateTime fecha_hora_adquisicion;
    private String modelo;
    private String estado;

    public EquipoMedico (){
    }

    public EquipoMedico(Long id_equipo_medico, String nombre, String marca, LocalDateTime fecha_hora_adquisicion,
            String modelo, String estado) {
        this.id_equipo_medico = id_equipo_medico;
        this.nombre = nombre;
        this.marca = marca;
        this.fecha_hora_adquisicion = fecha_hora_adquisicion;
        this.modelo = modelo;
        this.estado = estado;
    }

    public Long getId_equipo_medico() {
        return id_equipo_medico;
    }

    public void setId_equipo_medico(Long id_equipo_medico) {
        this.id_equipo_medico = id_equipo_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDateTime getFecha_hora_adquisicion() {
        return fecha_hora_adquisicion;
    }

    public void setFecha_hora_adquisicion(LocalDateTime fecha_hora_adquisicion) {
        this.fecha_hora_adquisicion = fecha_hora_adquisicion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    

}
