package ar.edu.redLink.retailShop.model;

import java.util.Collection;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Entity
@Data
public class Vendedor {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
	private UUID id;
	
	private String nombre;
	@Enumerated
	private TipoDNI tipoDni;
	private String dni;
	
	@OneToOne 
	private Usuario usuario;
		
	@OneToMany (mappedBy="vendedor")
	private Collection<Producto> productosPublicados;
	  
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL) private
	Collection<OrdenCompra> ventasRealizadas;
	  
	@Transient
	private Collection<Membresias> membresiasParaClientes;
	 
	
	
}
