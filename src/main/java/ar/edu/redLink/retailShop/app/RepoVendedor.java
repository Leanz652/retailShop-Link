package ar.edu.redLink.retailShop.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.redLink.retailShop.model.Vendedor;

@RepositoryRestResource(path = "vendedores")
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer> {

	@Override
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Vendedor entity) ;
	
	
	@RestResource
	Page<Vendedor> findByNombre	(String nombre,Pageable page);

}
