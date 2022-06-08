package ar.edu.redLink.retailShop.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.redLink.retailShop.model.Producto;
import ar.edu.redLink.retailShop.model.Proveedor;

@RepositoryRestController
public class ProductoControllerComplement {

@Autowired
RepoProducto repoProducto;

@Autowired
RepoProveedor repoProveedor;



@RequestMapping(method = RequestMethod.POST, value = "productos/especial")
public @ResponseBody String getProductos(@RequestBody Proveedor provedor) {
	return provedor.toString();
}





@RequestMapping(method = RequestMethod.POST, value = "productos/especial/{id}")
public @ResponseBody String getProductos23( @PathVariable("id") Integer productoId, @RequestBody Integer provedorId) {
	Optional<Producto> producto = repoProducto.findById(productoId);
	Optional<Proveedor> provedor = repoProveedor.findById(provedorId);
	producto.get().setProveedorDeProducto(provedor.get());
	return producto.get().toString();
}

}
