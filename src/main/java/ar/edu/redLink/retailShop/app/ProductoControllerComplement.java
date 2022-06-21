package ar.edu.redLink.retailShop.app;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
@PostMapping("/productos/publicar") public ResponseEntity<Object>
  uplaodImage(@RequestParam("image") MultipartFile
  file, @RequestParam("producto") String producto, @RequestParam("idVendedor") UUID idVendedor ) throws IOException {
  	
	Image imagenProducto = new Image();
	imagenProducto = Image.builder() .name(file.getOriginalFilename())
			  .type(file.getContentType())
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
	  productoFinal.setProveedor(proveedor.get());
	  productoFinal.setFechaDePublicacion(LocalDate.now());

	  repoProducto.save(productoFinal);
  
	  return ResponseEntity.ok(null); 
  }
}
