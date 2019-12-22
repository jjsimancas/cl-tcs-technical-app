package cl.tcs.technical.app.service;

import cl.tcs.technical.app.models.dto.ProductosResponseDTO;
import cl.tcs.technical.app.models.entity.Producto;

import java.util.List;

public interface ProductosService {

    List<Producto> findAllById();
    Producto findById(Long id);
    ProductosResponseDTO addProduct(Producto producto);
    ProductosResponseDTO updateProduct(Producto producto);

}
