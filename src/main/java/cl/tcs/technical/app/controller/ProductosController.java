package cl.tcs.technical.app.controller;

import cl.tcs.technical.app.models.dto.ProductosResponseDTO;
import cl.tcs.technical.app.models.entity.Producto;
import cl.tcs.technical.app.service.ProductosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductosController {

    @Autowired
    private ProductosService productosService;


    @ApiOperation(value = "Lista completa de productos", response = List.class)
    @GetMapping("/producto")
    public List<Producto> findProducts() {
        return productosService.findAllById();
    }

    @ApiOperation(value = "Detalle de producto", response = Producto.class)
    @GetMapping("/producto/{id}")
    public Producto detailProduct(@PathVariable("id") Long id) {
        return productosService.findById(id);
    }

    @ApiOperation(value = "Crea producto en la base de datos", response = ProductosResponseDTO.class)
    @PostMapping("/producto")
    public ResponseEntity<ProductosResponseDTO> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok().body(productosService.addProduct(producto));
    }

    @ApiOperation(value = "Actualiza productos en la base de datos", response = ProductosResponseDTO.class)
    @PutMapping("/producto")
    public ProductosResponseDTO actualizarProducto(@RequestBody Producto producto) {
        return productosService.updateProduct(producto);
    }
}
