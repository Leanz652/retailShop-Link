package ar.edu.redLink.retailShop.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;
	private LocalDate fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	private TipoDNI tipoDocumento;
	
	@NotBlank
	private String numeroDocumento;
	private String telefono;
	
	@OneToMany( mappedBy = "clienteComprador" ,cascade = CascadeType.ALL)
	private Collection<OrdenCompra> comprasEfectuadas;
	
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Usuario usuario;	
}