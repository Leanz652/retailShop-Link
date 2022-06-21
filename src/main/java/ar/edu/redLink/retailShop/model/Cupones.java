package ar.edu.redLink.retailShop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("3")
public class Cupones extends Promociones {

	
	private String codigoCupon;
	private int valorDeDescuento;
	private String descripcionCupon;
	private boolean estaUsado;
	
	

}
