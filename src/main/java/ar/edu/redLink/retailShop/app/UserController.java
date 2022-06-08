package ar.edu.redLink.retailShop.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.redLink.retailShop.model.Cliente;
import ar.edu.redLink.retailShop.model.Usuario;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	RepoUsuarioSpring repoUsuario;
	
	@Autowired
	RepoClienteSpring repoCliente;
	
	
	@PostMapping("/usuario")
	public String post(@RequestBody @Valid Usuario usuario, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			repoUsuario.save(usuario);
			return "Se guardo ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach
			(campoConError -> System.out.print(campoConError.getField()));
			return "Con errores";
		}
	}
	
	@PostMapping("/cliente")
	public String post(@RequestBody @Valid Cliente cliente, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			repoCliente.save(cliente);
			return "Se guardo ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach
			(campoConError -> System.out.print(campoConError.getField()));
			return "Con errores";
		}
	}

}
