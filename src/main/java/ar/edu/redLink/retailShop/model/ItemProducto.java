package ar.edu.redLink.retailShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemProducto {


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name= "PRODUCTO_ID")
	private Producto pruductoSeleccionado;
	private int cantidad;
	private Double precioUnitario;
	
	public ItemProducto(Producto pruductoSeleccionado, int cantidad, Double precioUnitario) {
		super();
		this.pruductoSeleccionado = pruductoSeleccionado;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	
	public ItemProducto() {
		super();
	}

	public Producto getPruductoSeleccionado() {
		return pruductoSeleccionado;
	}

	public void setPruductoSeleccionado(Producto pruductoSeleccionado) {
		this.pruductoSeleccionado = pruductoSeleccionado;
	}





	public int getCantidad() {
		return cantidad;
	}





	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}





	public Double getPrecioUnitario() {
		return precioUnitario;
	}





	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}





	public Double precioFinal() {
		return cantidad*precioUnitario;
	}

}
