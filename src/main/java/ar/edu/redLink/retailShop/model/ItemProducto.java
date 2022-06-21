package ar.edu.redLink.retailShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ItemProducto {


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name= "PRODUCTO_ID")
	private Producto pruductoSeleccionado;
		
	private int cantidad;
	private Double precioUnitario;
	
	public Double precioFinal() {
		return precioUnitario * cantidad;
	}
}
