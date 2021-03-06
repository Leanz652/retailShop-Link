package ar.edu.redLink.retailShop.model;

import java.util.Collection;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vendedor {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private String nombre;
	
	@Enumerated
	private TipoDNI tipoDni;
	private String dni;
	
	@OneToOne 
	private Usuario usuario;
		
	@OneToMany (mappedBy="vendedor")
	private Collection<Producto> productosPublicados;
	  
	@OneToMany(mappedBy = "vendedor") 
	private Collection<OrdenCompra> ventasRealizadas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDNI getTipoDni() {
		return tipoDni;
	}

	public void setTipoDni(TipoDNI tipoDni) {
		this.tipoDni = tipoDni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Producto> getProductosPublicados() {
		return productosPublicados;
	}

	public void setProductosPublicados(Collection<Producto> productosPublicados) {
		this.productosPublicados = productosPublicados;
	}

	public Collection<OrdenCompra> getVentasRealizadas() {
		return ventasRealizadas;
	}

	public void setVentasRealizadas(Collection<OrdenCompra> ventasRealizadas) {
		this.ventasRealizadas = ventasRealizadas;
	}

	public Vendedor(String id, String nombre, TipoDNI tipoDni, String dni, Usuario usuario,
			Collection<Producto> productosPublicados, Collection<OrdenCompra> ventasRealizadas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoDni = tipoDni;
		this.dni = dni;
		this.usuario = usuario;
		this.productosPublicados = productosPublicados;
		this.ventasRealizadas = ventasRealizadas;
	}

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
