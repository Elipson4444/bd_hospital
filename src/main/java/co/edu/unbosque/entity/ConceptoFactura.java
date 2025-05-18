package co.edu.unbosque.entity;

public class ConceptoFactura {

    private int id_concepto;
    private Long id_factura;
    private String descripcion;
    private double precio_unitario;
    private String concepto;

    public ConceptoFactura(int id_concepto, Long id_factura, String descripcion, double precio_unitario,
            String concepto) {
        this.id_concepto = id_concepto;
        this.id_factura = id_factura;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.concepto = concepto;
    }

    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    

   
    

}
