package ar.edu.redLink.retailShop.app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import ar.edu.redLink.retailShop.model.Producto;
import ar.edu.redLink.retailShop.model.ProductoDTO;
import ar.edu.redLink.retailShop.model.Proveedor;
import ar.edu.redLink.retailShop.model.Vendedor;

@RepositoryRestController
public class ProductoControllerComplement {

	@Autowired
	ProductoRepoREST repoProducto;

	@Autowired
	ProveedorRepoREST repoProveedor;

	@Autowired
	ImageRepository imagenRepository;

	@Autowired
	VendedorRepoREST repoVendedor;

	@Transactional
	@PostMapping("/productos/publicar")
	public ResponseEntity<Object> uploadProduct(@RequestParam("image") MultipartFile file,
			@RequestParam("producto") String producto, @RequestParam("idVendedor") String idVendedor) throws IOException {

		Image imagenProducto = new Image();
		imagenProducto = Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(ImageUtility.compressImage(file.getBytes())).build();
		imagenRepository.save(imagenProducto);

		Gson g = new Gson();
		ProductoDTO productoACrear = g.fromJson(producto, ProductoDTO.class);

		Optional<Vendedor> vendedor = repoVendedor.findByUsuarioId(idVendedor);
		Optional<Proveedor> proveedor = repoProveedor.findByRazonSocial(productoACrear.getProveedor());

		System.out.print(productoACrear.toString());

		Producto productoFinal = new Producto();
		productoFinal.setImagen(imagenProducto);
		productoFinal.setNombre(productoACrear.getNombre());
		productoFinal.setPrecio(productoACrear.getPrecio());
		productoFinal.setDescripcion(productoACrear.getDescripcion());
		productoFinal.setTipoProducto(productoACrear.getTipoProducto());
		productoFinal.setVendedor(vendedor.get());
		productoFinal.setProveedorDeProducto(proveedor.get());
		productoFinal.setFechaDePublicacion(LocalDate.now());
		productoFinal.setActivo(true);

		repoProducto.save(productoFinal);

		return ResponseEntity.ok(null);
	}
	
	

	@Transactional
	@DeleteMapping("/productos/eliminar/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer producto_id) throws IOException {

		Optional<Producto> productoAEliminar = repoProducto.findById(producto_id);

		Producto productoADarDeBaja = productoAEliminar.get();
		productoADarDeBaja.setActivo(false);
		repoProducto.save(productoADarDeBaja);

		return ResponseEntity.ok(null);
	}
	
	
	@Transactional
	@PatchMapping("/productos/modificar/")
	public ResponseEntity<Object> editProduct(@RequestParam("precio") Double precio, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("id") Integer id_producto) throws IOException {

		Optional<Producto> productoAEditar = repoProducto.findById(id_producto);

		Producto productoEditado = productoAEditar.get();
		productoEditado.setDescripcion(descripcion);
		productoEditado.setPrecio(precio);
		productoEditado.setNombre(nombre);
		repoProducto.save(productoEditado);

		return ResponseEntity.ok(null);
	}

}