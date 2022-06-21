package ar.edu.redLink.retailShop.app;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ar.edu.redLink.retailShop.model.Cliente;
import ar.edu.redLink.retailShop.model.RolUsuario;
import ar.edu.redLink.retailShop.model.Usuario;
import ar.edu.redLink.retailShop.model.Vendedor;

@RepositoryRestController
public class UsuarioControllerComplement {

	@Autowired
	UsuarioRepoREST repoUsuarioSpring;
	
	
	@Autowired
	VendedorRepoREST repoVendedor ;
	
	
	@Autowired
	ClienteRepoREST repoCliente;

	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/usuarios/login")
    public ResponseEntity<ResponseLogin> getLogin(@RequestBody Usuario usuario) {

    	ResponseLogin response = new ResponseLogin();
    	
    	System.out.println(usuario);
    	Optional<Usuario> usuarioABuscar = repoUsuarioSpring.findByUsername(usuario.getUsername());
    	if (usuarioABuscar.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
    	if (!(usuarioABuscar.get().getPassword().equals(usuario.getPassword())) ) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    	}
    	
    	if (usuarioABuscar.get().getRol() == RolUsuario.VENDEDOR) {
        	Optional<Vendedor> vendedorABuscar = repoVendedor.findByUsuarioId(usuarioABuscar.get().getId());
        	response.setIdRol(vendedorABuscar.get().getId());
    	}
    	
    	if (usuarioABuscar.get().getRol() == RolUsuario.CLIENTE) {
        	Optional<Cliente> clienteABuscar = repoCliente.findByUsuarioId(usuarioABuscar.get().getId());
        	response.setIdRol(clienteABuscar.get().getId());
    	}    	
    	    	
    	response.setId(usuarioABuscar.get().getId());
    	response.setRol(usuarioABuscar.get().getRol());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	
}
