package ar.edu.redLink.retailShop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Membresias extends Promociones {

	
	private String descripcionMembresia;
	private int porcentajeDto;
	
	public Membresias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Membresias(String descripcionMembresia, int porcentajeDto) {
		super();
		this.descripcionMembresia = descripcionMembresia;
		this.porcentajeDto = porcentajeDto;
	}
	public String getDescripcionMembresia() {
		return descripcionMembresia;
	}
	public void setDescripcionMembresia(String descripcionMembresia) {
		this.descripcionMembresia = descripcionMembresia;
	}
	public int getPorcentajeDto() {
		return porcentajeDto;
	}
	public void setPorcentajeDto(int porcentajeDto) {
		this.porcentajeDto = porcentajeDto;
	}

	
	

	
	
}
