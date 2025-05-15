package co.edu.unbosque.entity;

public class Medico {
    
    private Long id_medico;
    private Long numero_licencia;
    private String especialidad;
    private int experiencia;
    private String universidad;
    private Long id_empleado;
    
    public Medico(Long id_medico, Long numero_licencia, String especialidad, int experiencia, String universidad,
            Long id_empleado) {
        this.id_medico = id_medico;
        this.numero_licencia = numero_licencia;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.universidad = universidad;
        this.id_empleado = id_empleado;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public Long getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(Long numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }


    


}
