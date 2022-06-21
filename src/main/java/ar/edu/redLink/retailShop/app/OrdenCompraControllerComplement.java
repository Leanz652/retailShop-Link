package ar.edu.redLink.retailShop.app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.edu.redLink.retailShop.model.Cliente;
import ar.edu.redLink.retailShop.model.ItemProducto;
import ar.edu.redLink.retailShop.model.OrdenCompra;
import ar.edu.redLink.retailShop.model.Producto;

import ar.edu.redLink.retailShop.model.Promociones;

@RepositoryRestController
@CrossOrigin
public class OrdenCompraControllerComplement {

	@Autowired
	ProductoRepoREST repoProducto;

	@Autowired
	VendedorRepoREST repoVendedor;

	@Autowired
	ClienteRepoREST repoCliente;

	@Autowired
	PromocionesRepoREST repoPromociones;

	@Autowired
	ItemProductoRepoREST repoItemProd;
	@Autowired
	OrdenCompraRepoREST repoOrdenCompra;

	@Transactional
	@PostMapping("/ordenes/purchase")
	public ResponseEntity<Object> finalizarCompra(@RequestParam("producto") Integer producto_id,
			@RequestParam("idComprador") UUID comprador_id, @RequestParam("cupon") Integer cupon_id,
			@RequestParam("factura") String factura) throws IOException {

		Optional<Producto> productoBuscado = repoProducto.findById(producto_id);
		Optional<Cliente> clienteBuscado = repoCliente.findById(comprador_id);
		Optional<Promociones> cuponBuscado = repoPromociones.findById(cupon_id);

		ItemProducto itemProducto = new ItemProducto();
		itemProducto.setCantidad(1);
		itemProducto.setPrecioUnitario(productoBuscado.get().getPrecio());
		itemProducto.setPruductoSeleccionado(productoBuscado.get());

		OrdenCompra ordenCompra = new OrdenCompra();
		ordenCompra.setComprador(clienteBuscado.get());
		ordenCompra.setFechaCompra(LocalDate.now());
		ordenCompra.setItemsComprados(itemProducto);

		if (!cuponBuscado.isEmpty()) {
			ordenCompra.setPromocionesAplicadas(Arrays.asList(cuponBuscado.get()));
		}

		ordenCompra.setVendedor(productoBuscado.get().getVendedor());

		repoItemProd.save(itemProducto);
		repoOrdenCompra.save(ordenCompra);

		return ResponseEntity.ok(null);
	}
}