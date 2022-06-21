package ar.edu.redLink.retailShop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("1")
public class Membresias extends Promociones {

	
	private String descripcionMembresia;
	private int porcentajeDto;

	
	

	
	
}
