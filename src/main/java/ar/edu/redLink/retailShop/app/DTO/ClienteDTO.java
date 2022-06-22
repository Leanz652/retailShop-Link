package ar.edu.redLink.retailShop.app.DTO;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import ar.edu.redLink.retailShop.model.Cliente;

@Projection(name = "clientes", types = { Cliente.class })
public interface ClienteDTO {

	@Value("#{target.itemsComprados.productoSeleccionado}")
	ProductoDTO getItemsComprados();

	  String getNombre();
	  String getApellido();
	  Collection<ComprasDTO> getComprasEfectuadas();	 

}
