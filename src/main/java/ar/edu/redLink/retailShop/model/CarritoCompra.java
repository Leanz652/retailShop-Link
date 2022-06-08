package ar.edu.redLink.retailShop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CarritoCompra {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Transient
	private Collection<ItemProducto> productosAComprar;

	public CarritoCompra() {
		super();
		this.productosAComprar = new ArrayList<ItemProducto>();
	}

	public Collection<ItemProducto> getProductosAComprar() {
		return productosAComprar;
	}

	public void setProductosAComprar(Collection<ItemProducto> productosAComprar) {
		this.productosAComprar = productosAComprar;
	}
	
	
	public void vaciarCarrito() {
		productosAComprar.clear();
	}
	
	public void agregarItemACarrito(ItemProducto item) {
		productosAComprar.add(item);
	}
	
	public void borrarItemDeCarrito(ItemProducto item) {
		productosAComprar.remove(item);
	}
	
	public Double montoCarrito() {
		return productosAComprar.stream().mapToDouble(producto -> producto.precioFinal()).sum();
	}
	
	
	
	
}
