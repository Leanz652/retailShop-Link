package ar.edu.redLink.retailShop.model;


import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class CarritoCompra {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Transient
	private Collection<ItemProducto> productosAComprar;

	
}
