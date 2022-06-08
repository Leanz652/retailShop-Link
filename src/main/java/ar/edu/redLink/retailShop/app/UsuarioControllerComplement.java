package ar.edu.redLink.retailShop.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.redLink.retailShop.model.Usuario;
import ar.edu.redLink.retailShop.model.Vendedor;

@RepositoryRestController
public class UsuarioControllerComplement {

	@Autowired
	RepoUsuarioSpring repoUsuarioSpring;
	
	
	@Autowired
	RepoVendedor repoVendedor ;
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/vendedores/pepe/{usuarioId}")
	@ResponseBody
	public ResponseEntity<Vendedor> getVendedor(
			@PathVariable("usuarioId") Integer usuarioId ) {
		
		Optional<Vendedor> opcionalUsuario = repoVendedor.findById(usuarioId);
		if(opcionalUsuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Vendedor vendedor = opcionalUsuario.get();
		return ResponseEntity.accepted().body(vendedor);
	}
	
	
}
