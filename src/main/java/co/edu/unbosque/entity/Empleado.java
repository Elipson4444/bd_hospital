package co.edu.unbosque.entity;

public class Empleado {

    private Long id_empleado;
    private String nombre;
    private String apellido;
    private String cargo;
    private int id_tparea;
    private String tipoAreaNombre;

    

    public Empleado(Long id_empleado, String nombre, String apellido, String cargo, int id_tparea,
            String tipoAreaNombre) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.id_tparea = id_tparea;
        this.tipoAreaNombre = tipoAreaNombre;
    }

    public Empleado(Long id_empleado, String nombre, String apellido, String cargo, int id_tparea) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.id_tparea = id_tparea;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_tparea() {
        return id_tparea;
    }

    public void setId_tparea(int id_tparea) {
        this.id_tparea = id_tparea;
    }

    public String getTipoAreaNombre() {
        return tipoAreaNombre;
    }

    public void setTipoAreaNombre(String tipoAreaNombre) {
        this.tipoAreaNombre = tipoAreaNombre;
    }
    
    
    
}
