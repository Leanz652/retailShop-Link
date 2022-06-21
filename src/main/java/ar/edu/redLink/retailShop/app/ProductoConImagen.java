package ar.edu.redLink.retailShop.app;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.redLink.retailShop.model.Producto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoConImagen {

	public Producto producto;
	public MultipartFile file;
	
	
}
