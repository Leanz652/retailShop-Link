package ar.edu.redLink.retailShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="item_producto")
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
