package ar.edu.redLink.retailShop.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private UUID id;

	@NotBlank
	@Email
	private String username;


    @JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank
	@Size(min = 8, max = 15)
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
