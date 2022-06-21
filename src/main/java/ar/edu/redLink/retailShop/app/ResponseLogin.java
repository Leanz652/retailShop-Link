package ar.edu.redLink.retailShop.app;

import java.util.UUID;

import ar.edu.redLink.retailShop.model.Cliente;
import ar.edu.redLink.retailShop.model.RolUsuario;
import ar.edu.redLink.retailShop.model.Vendedor;
import lombok.Data;

@Data
public class ResponseLogin {

	private String id;
	private RolUsuario rol;	
	private String idRol;
}
