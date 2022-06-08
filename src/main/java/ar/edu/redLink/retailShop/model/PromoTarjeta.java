package ar.edu.redLink.retailShop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@DiscriminatorValue("2")
public class PromoTarjeta extends Promociones {

	private String descripcionPromoTarjeta;
	private int porcentajeDto;
	public PromoTarjeta(String descripcionPromoTarjeta, int porcentajeDto) {
		super();
		this.descripcionPromoTarjeta = descripcionPromoTarjeta;
		this.porcentajeDto = porcentajeDto;
	}
		

	public PromoTarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}
}
