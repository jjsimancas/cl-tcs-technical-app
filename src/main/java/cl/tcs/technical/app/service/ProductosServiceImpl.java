package cl.tcs.technical.app.service;

import cl.tcs.technical.app.exceptions.TCSExceptions;
import cl.tcs.technical.app.models.dto.ProductosResponseDTO;
import cl.tcs.technical.app.models.entity.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static cl.tcs.technical.app.config.Constantes.*;

@Repository
public class ProductosServiceImpl implements ProductosService {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductosServiceImpl.class);


    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAllById() {
        Query query = entityManager.createNativeQuery("SELECT * FROM productos", Producto.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(Long id) {
        LOGGER.info("[Buscando Producto por ID]");
        Producto pro = new Producto();
        ProductosResponseDTO productosResponseDTO = new ProductosResponseDTO();
        try{
            Query query = entityManager.createNativeQuery("select * from productos where id_producto = ?", Producto.class);
            query.setParameter(1, id);
            pro = (Producto) query.getSingleResult();
            LOGGER.info("[Producto Encontrado]");
        }catch (Exception ex){
            LOGGER.info("[Producto No Encontrado]");
            pro.setNombreProducto(MSG_NO_ENCONTRADO);
        }

        return pro;
    }

    @Transactional
    @Override
    public ProductosResponseDTO addProduct(Producto producto) {
        LOGGER.info("[Registrando Producto]");
        ProductosResponseDTO productosResponseDTO = new ProductosResponseDTO();
        int resp = 0;
        try {
            Query query = entityManager.createNativeQuery("insert into productos(nombre_producto, descripcion_prod, cantidad, " +
                    "marca_producto, categoria) values(?, ?, ?, ?, ?)");
            query.setParameter(1, producto.getNombreProducto());
            query.setParameter(2, producto.getDescripcionProd());
            query.setParameter(3, producto.getCantidad());
            query.setParameter(4, producto.getMarcaProducto());
            query.setParameter(5, producto.getCategoria());
            resp = query.executeUpdate();
            if (resp == 1) {
                productosResponseDTO.setResponseCode(resp);
                productosResponseDTO.setMensaje(MSG_CREADO);
                LOGGER.info("[Producto Registrado]");
            }
        } catch (Exception ex) {
            throw new TCSExceptions(MSG_FALLO);
        }

        return productosResponseDTO;
    }

    @Transactional
    @Override
    public ProductosResponseDTO updateProduct(Producto producto) {
        LOGGER.info("[Actualizando Producto]");
        ProductosResponseDTO productosResponseDTO = new ProductosResponseDTO();
        try {
            Query query = entityManager.createNativeQuery("update productos set nombre_producto= :nombreProducto, " +
                    "descripcion_prod= :descripcion, cantidad= :cantidad, marca_producto= :marcaProducto, " +
                    "categoria= :categoria where id_producto= :id");
            query.setParameter("id", producto.getId());
            query.setParameter("nombreProducto", producto.getNombreProducto());
            query.setParameter("descripcion", producto.getDescripcionProd());
            query.setParameter("cantidad", producto.getCantidad());
            query.setParameter("marcaProducto", producto.getMarcaProducto());
            query.setParameter("categoria", producto.getCategoria());

            productosResponseDTO.setResponseCode(query.executeUpdate());
            productosResponseDTO.setMensaje("Producto Actualizado");
        } catch (Exception ex) {
            throw new TCSExceptions(MSG_FALLO);
        }
        LOGGER.info("[Producto Actualizado]");
        return productosResponseDTO;
    }
}
