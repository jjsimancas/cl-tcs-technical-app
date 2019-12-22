package cl.tcs.technical.app;

import cl.tcs.technical.app.config.Constantes;
import cl.tcs.technical.app.models.dto.ProductosResponseDTO;
import cl.tcs.technical.app.models.entity.Producto;
import cl.tcs.technical.app.service.ProductosService;
import cl.tcs.technical.app.service.ProductosServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SpringBootTest
class ClTcsTechnicalAppApplicationTests {

	@Mock
	private ProductosServiceImpl productosService;

	@Test
	void contextLoads() {
	}

	@Test
	public void addProductServiceTest() {
		Producto producto = new Producto();
		producto.setNombreProducto("Correa Multicanal 5PK2033");
		producto.setDescripcionProd("correa motor Symbol 1.6 8v");
		producto.setCantidad(200);
		producto.setMarcaProducto("BANDO");
		producto.setCategoria("correas");
		ProductosResponseDTO productosResponseDTO = new ProductosResponseDTO();
		productosResponseDTO.setResponseCode(1);
		productosResponseDTO.setMensaje(Constantes.MSG_CREADO);
		Mockito.when(productosService.addProduct(producto)).thenReturn(productosResponseDTO);
		Assertions.assertEquals(productosService.addProduct(producto), productosResponseDTO);
	}

}
