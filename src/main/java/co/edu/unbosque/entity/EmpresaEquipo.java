package co.edu.unbosque.entity;

public class EmpresaEquipo {

    private Long id_seguro_salud;
    private Long id_equipo_medico;
    private Long pk_empresa_equipo;

    public EmpresaEquipo(Long id_seguro_salud, Long id_equipo_medico, Long pk_empresa_equipo) {
        this.id_seguro_salud = id_seguro_salud;
        this.id_equipo_medico = id_equipo_medico;
        this.pk_empresa_equipo = pk_empresa_equipo;
    }
    
    public Long getId_seguro_salud() {
        return id_seguro_salud;
    }
    public void setId_seguro_salud(Long id_seguro_salud) {
        this.id_seguro_salud = id_seguro_salud;
    }
    public Long getId_equipo_medico() {
        return id_equipo_medico;
    }
    public void setId_equipo_medico(Long id_equipo_medico) {
        this.id_equipo_medico = id_equipo_medico;
    }
    public Long getPk_empresa_equipo() {
        return pk_empresa_equipo;
    }
    public void setPk_empresa_equipo(Long pk_empresa_equipo) {
        this.pk_empresa_equipo = pk_empresa_equipo;
    }

    


}
