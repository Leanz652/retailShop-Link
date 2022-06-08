package ar.edu.redLink.retailShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarjeta implements MetodoPago {


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String numeroTarjeta;
	
	private String clave;
	
	public Tarjeta() {

	}

}
