package co.edu.unbosque.entity;

import java.time.LocalDateTime;

public class MantenimientoMedico {

    private Long id_mantenimiento;
    private LocalDateTime fecha;
    private Long id_equipo_medico;

    
    public MantenimientoMedico(Long id_mantenimiento, LocalDateTime fecha, Long id_equipo_medico) {
        this.id_mantenimiento = id_mantenimiento;
        this.fecha = fecha;
        this.id_equipo_medico = id_equipo_medico;
    }


    public Long getId_mantenimiento() {
        return id_mantenimiento;
    }


    public void setId_mantenimiento(Long id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }


    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    public Long getId_equipo_medico() {
        return id_equipo_medico;
    }


    public void setId_equipo_medico(Long id_equipo_medico) {
        this.id_equipo_medico = id_equipo_medico;
    }

}
