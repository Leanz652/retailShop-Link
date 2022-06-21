
  package ar.edu.redLink.retailShop.app;
  
  import java.util.List; import java.util.Optional; import java.util.UUID;
  
  import org.springframework.data.repository.PagingAndSortingRepository; import
  org.springframework.data.rest.core.annotation.RepositoryRestResource; import
  org.springframework.data.rest.core.annotation.RestResource;
  
  import ar.edu.redLink.retailShop.model.Usuario;
  
  
  @RepositoryRestResource(path = "usuarios") public interface UsuarioRepoREST
  extends PagingAndSortingRepository<Usuario, String> {
  
  
  List<Usuario> findAll();
  
  Optional<Usuario> findByUsername(String username);
  
  @Override
  
  @RestResource(exported = false) void deleteById(String id);
  
  @Override
  
  @RestResource(exported = false) void delete(Usuario user); }
 