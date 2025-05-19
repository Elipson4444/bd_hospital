package co.edu.unbosque.entity;

public class EmpleadosAuditoria {

    private int id_ea;
    private int id_empleado;
    private int id_auditoria;

    public EmpleadosAuditoria (){
    }

    public EmpleadosAuditoria(int id_ea, int id_empleado, int id_auditoria) {
        this.id_ea = id_ea;
        this.id_empleado = id_empleado;
        this.id_auditoria = id_auditoria;
    }

    public int getId_ea() {
        return id_ea;
    }

    public void setId_ea(int id_ea) {
        this.id_ea = id_ea;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    

    

}
