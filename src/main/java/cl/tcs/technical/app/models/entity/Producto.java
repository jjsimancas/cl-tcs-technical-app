package cl.tcs.technical.app.models.entity;


import cl.tcs.technical.app.models.dto.ProductosResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "nombre_producto")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "producto")
    private String nombreProducto;

    @Column(name = "descripcion_prod")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "descripcion")
    private String descripcionProd;

    @Column(name = "cantidad")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "cantidad")
    private Integer cantidad;

    @Column(name = "marca_producto")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "marca")
    private String marcaProducto;

    @Column(name = "categoria")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "categoria")
    private String categoria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
