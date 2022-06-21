package ar.edu.redLink.retailShop.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.redLink.retailShop.model.Cupones;
import ar.edu.redLink.retailShop.model.Promociones;

@CrossOrigin
@RepositoryRestResource(path = "promociones")
public interface PromocionesRepoREST extends PagingAndSortingRepository<Promociones, Integer> {

	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Promociones entity) ;
	
	Optional<Cupones>  findByCodigoCupon(String codigo);

}
