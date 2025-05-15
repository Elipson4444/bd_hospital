package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class Paciente {

    private Long id_paciente;
    private String nombre;
    private String apellido;
    private LocalDateTime fecha_nacimiento;
    private String sexo;
    private String tipo_documento;
    private String direccion;
    private String telefono;
    private Long id_seguro;



    public Paciente(Long id_paciente, String nombre, String apellido, LocalDateTime fecha_nacimiento, String sexo,
            String tipo_documento, String direccion, String telefono, Long id_seguro) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.tipo_documento = tipo_documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_seguro = id_seguro;
    }



    public Long getId_paciente() {
        return id_paciente;
    }



    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
    }



    public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }



    public String getSexo() {
        return sexo;
    }



    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



    public String getTipo_documento() {
        return tipo_documento;
    }



    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public Long getId_seguro() {
        return id_seguro;
    }



    public void setId_seguro(Long id_seguro) {
        this.id_seguro = id_seguro;
    }

    

    



}
