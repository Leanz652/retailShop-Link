package ar.edu.redLink.retailShop.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.redLink.retailShop.model.ItemProducto;

@CrossOrigin
@RepositoryRestResource(path = "itemProducto")
public interface ItemProductoRepoREST extends PagingAndSortingRepository<ItemProducto, Integer> {



	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported = false)
	void delete(ItemProducto producto);	
	
	
}
