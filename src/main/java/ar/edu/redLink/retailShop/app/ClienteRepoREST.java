package ar.edu.redLink.retailShop.app;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.redLink.retailShop.model.Cliente;


@CrossOrigin
@RepositoryRestResource(path = "clientes")
public interface ClienteRepoREST extends PagingAndSortingRepository<Cliente, UUID> {
	
	
	Optional<Cliente> findByUsuarioId(UUID id);
	
	@Override
	@RestResource(exported = false)
	void deleteById(UUID id);
	
	@Override
	@RestResource(exported = false)
	void delete(Cliente cliente);	

}
