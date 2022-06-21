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
public interface ClienteRepoREST extends PagingAndSortingRepository<Cliente, String> {
	
	
	Optional<Cliente> findByUsuarioId(String id);
	
	@Override
	@RestResource(exported = false)
	void deleteById(String id);
	
	@Override
	@RestResource(exported = false)
	void delete(Cliente cliente);	

}
