package co.edu.unbosque.entity;

public class Diagnostico {

    private int id_diagnostico;
    private String diagnostico_ingreso;
    private String diagnostico_egreso;
    private int id_paciento;

    public Diagnostico(int id_diagnostico, String diagnostico_ingreso, String diagnostico_egreso, int id_paciento) {
        this.id_diagnostico = id_diagnostico;
        this.diagnostico_ingreso = diagnostico_ingreso;
        this.diagnostico_egreso = diagnostico_egreso;
        this.id_paciento = id_paciento;
    }

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public String getDiagnostico_ingreso() {
        return diagnostico_ingreso;
    }

    public void setDiagnostico_ingreso(String diagnostico_ingreso) {
        this.diagnostico_ingreso = diagnostico_ingreso;
    }

    public String getDiagnostico_egreso() {
        return diagnostico_egreso;
    }

    public void setDiagnostico_egreso(String diagnostico_egreso) {
        this.diagnostico_egreso = diagnostico_egreso;
    }

    public int getId_paciento() {
        return id_paciento;
    }

    public void setId_paciento(int id_paciento) {
        this.id_paciento = id_paciento;
    }

    
    

}
