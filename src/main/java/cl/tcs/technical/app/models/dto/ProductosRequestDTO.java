package cl.tcs.technical.app.models.dto;

public class ProductosRequestDTO {

    private String nombreProducto;
    private String descripcionProd;
    private Integer cantidad;
    private String marcaProducto;
    private String categoria;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
