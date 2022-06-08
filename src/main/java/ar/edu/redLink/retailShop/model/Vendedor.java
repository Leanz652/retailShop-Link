package ar.edu.redLink.retailShop.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity
//@Data
public class Vendedor {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	@Enumerated
	private TipoDNI tipoDni;
	private String dni;
	@OneToOne
	private Usuario usuario;
	
	@OneToMany
	private Collection<Producto> productosPublicados;
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
	private Collection<OrdenCompra> ventasRealizadas;
	@Transient
	private Collection<Membresias> membresiasParaClientes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Collection<Membresias> getMembresiasParaClientes() {
		return membresiasParaClientes;
	}
	public void setMembresiasParaClientes(Collection<Membresias> membresiasParaClientes) {
		this.membresiasParaClientes = membresiasParaClientes;
	}
	public Vendedor(String nombre, TipoDNI tipoDni, String dni, Usuario usuario,
			Collection<Producto> productosPublicados, Collection<OrdenCompra> ventasRealizadas,
			Collection<Membresias> membresiasParaClientes) {
		super();
		this.nombre = nombre;
		this.tipoDni = tipoDni;
		this.dni = dni;
		this.usuario = usuario;
		this.productosPublicados = productosPublicados;
		this.ventasRealizadas = ventasRealizadas;
		this.membresiasParaClientes = membresiasParaClientes;
	}
	public Vendedor() {
		super();
	}
	
	
}
