package ar.edu.redLink.retailShop.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.redLink.retailShop.app.DTO.ProductoDTO;
import ar.edu.redLink.retailShop.model.Producto;

@CrossOrigin
@RepositoryRestResource(path = "productos",excerptProjection = ProductoDTO.class)
public interface ProductoRepoREST extends PagingAndSortingRepository<Producto, Integer> {

	
	Optional<Producto> findById(Integer id);
	
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported = false)
	void delete(Producto producto);	

}
