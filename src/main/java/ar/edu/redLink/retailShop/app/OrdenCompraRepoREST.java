package ar.edu.redLink.retailShop.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ar.edu.redLink.retailShop.model.OrdenCompra;
import ar.edu.redLink.retailShop.app.DTO.ComprasDTO;

@RepositoryRestResource(path = "ordenes", excerptProjection = ComprasDTO.class)
public interface OrdenCompraRepoREST extends PagingAndSortingRepository<OrdenCompra, Integer>  {

	
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported = false)
	void delete(OrdenCompra producto);	

}
