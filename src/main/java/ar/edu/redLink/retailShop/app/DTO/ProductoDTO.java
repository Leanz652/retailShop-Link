package ar.edu.redLink.retailShop.app.DTO;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import ar.edu.redLink.retailShop.model.Producto;

@Projection(name = "producto",types = {Producto.class})
public interface ProductoDTO {
	
	String getNombre();
	
	Double getPrecio();
	
	String getId();
	
	boolean getActivo();
	
	LocalDate getFechaDePublicacion();
	
	@Value("#{target.imagen.getId()}")
	int getIdImagen();

}
