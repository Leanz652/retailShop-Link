package ar.edu.redLink.retailShop.app.DTO;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import ar.edu.redLink.retailShop.model.ItemProducto;
import ar.edu.redLink.retailShop.model.OrdenCompra;
import ar.edu.redLink.retailShop.model.Producto;
import ar.edu.redLink.retailShop.model.Vendedor;

@Projection(name = "compras", types = { OrdenCompra.class })
public interface ComprasDTO {

	@Value("#{target.itemComprado.productoSeleccionado}")
	ProductoDTO getItemComprado();
	  Vendedor getVendedor();
	 
	  LocalDate getFechaCompra();
	  String getId();
	 

}
