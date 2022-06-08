package ar.edu.redLink.retailShop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cliente {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombreApellido;
	private LocalDate fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	private TipoDNI tipoDocumento;
	private String numeroDocumento;
	private String telefono;
	
	@OneToMany( mappedBy = "clienteComprador" ,cascade = CascadeType.ALL)
	private Collection<OrdenCompra> comprasEfectuadas;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Tarjeta> tarjetasRegistradas;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CarritoCompra carritoItems;
	
	@ManyToMany
	@JoinTable(
			name = "CLIENTES_MEMBRESIAS",
			joinColumns = @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "MEMBRESIAS_ID", referencedColumnName = "id"))
	private Collection<Membresias> suscripciones;
	
	
	public Cliente(String nombreApellido, LocalDate fechaNacimiento, TipoDNI tipoDocumento, String numeroDocumento,
			String telefono, String email, Usuario usuario) {
		super();
		this.nombreApellido = nombreApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.usuario = usuario;
		this.comprasEfectuadas = new ArrayList<OrdenCompra>();
		this.tarjetasRegistradas = new ArrayList<Tarjeta>();
		this.suscripciones = new ArrayList<Membresias>();
	}
	
	public Cliente() {
		super();
	}


	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public TipoDNI getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(TipoDNI tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Collection<OrdenCompra> getComprasEfectuadas() {
		return comprasEfectuadas;
	}

	public void setComprasEfectuadas(Collection<OrdenCompra> comprasEfectuadas) {
		this.comprasEfectuadas = comprasEfectuadas;
	}

	public Collection<Tarjeta> getTarjetasRegistradas() {
		return tarjetasRegistradas;
	}

	public void setTarjetasRegistradas(Collection<Tarjeta> tarjetasRegistradas) {
		this.tarjetasRegistradas = tarjetasRegistradas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public CarritoCompra getCarritoItems() {
		return carritoItems;
	}

	public Collection<Membresias> getSuscripciones() {
		return suscripciones;
	}


	public void setSuscripciones(Collection<Membresias> suscripciones) {
		this.suscripciones = suscripciones;
	} 
	
}
