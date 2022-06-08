package ar.edu.redLink.retailShop.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Producto {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated
	private TipoProducto tipoProducto;
	private Double precio;
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="PROVEEDOR_ID")
	private Proveedor proveedorDeProducto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Proveedor getProveedorDeProducto() {
		return proveedorDeProducto;
	}

	public void setProveedorDeProducto(Proveedor proveedorDeProducto) {
		this.proveedorDeProducto = proveedorDeProducto;
	}

	public Producto(TipoProducto tipoProducto, Double precio, String nombre, String descripcion,
			Proveedor proveedorDeProducto) {
		super();
		this.tipoProducto = tipoProducto;
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.proveedorDeProducto = proveedorDeProducto;
	}

	public Producto() {
		super();
	}

	
	
	
}
