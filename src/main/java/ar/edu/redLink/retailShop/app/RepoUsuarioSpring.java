package ar.edu.redLink.retailShop.app;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.redLink.retailShop.model.Usuario;


@RepositoryRestResource(path = "usuarios")
public interface RepoUsuarioSpring extends PagingAndSortingRepository<Usuario, Integer> {
	

	List<Usuario> findAll();

	Usuario findByUsername(String username);

	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported = false)
	void delete(Usuario user);
}
