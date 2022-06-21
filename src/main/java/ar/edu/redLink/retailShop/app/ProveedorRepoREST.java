package ar.edu.redLink.retailShop.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.redLink.retailShop.model.Proveedor;

@CrossOrigin
@RepositoryRestResource(path = "proveedores")
public interface ProveedorRepoREST extends PagingAndSortingRepository<Proveedor, Integer> {

	
	Optional<Proveedor> findByRazonSocial(String razonSocial);
	
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported = false)
	void delete(Proveedor provedor);	
}
