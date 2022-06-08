package ar.edu.redLink.retailShop.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Data
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@NotBlank
	@Email
	private String username;
	
	@NotBlank
	@Size(min = 8, max = 15)
	@JsonIgnore
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RolUsuario rol;
	
	public boolean esAdministrador() {
		return rol == RolUsuario.ADMINISTRADOR;
	}
	
	public boolean esCliente() {
		return rol == RolUsuario.CLIENTE;
	}
	
	public boolean esVendedor() {
		return rol == RolUsuario.VENDEDOR;
	}
}
