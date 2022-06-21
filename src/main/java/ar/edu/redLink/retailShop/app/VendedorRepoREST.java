package ar.edu.redLink.retailShop.app;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.redLink.retailShop.model.Vendedor;

@CrossOrigin
@RepositoryRestResource(path = "vendedores")
public interface VendedorRepoREST extends PagingAndSortingRepository<Vendedor, UUID> {

	@Override
	@RestResource(exported = false)
	void deleteById(UUID id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Vendedor entity) ;
	
	Optional<Vendedor> findByUsuarioId(UUID id);
	
	@RestResource
	Page<Vendedor> findByNombre	(String nombre,Pageable page);

}
