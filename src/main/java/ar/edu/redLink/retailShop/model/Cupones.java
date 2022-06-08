package ar.edu.redLink.retailShop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Cupones extends Promociones {

	
	private String codigoCupon;
	private int porcentajeDto;
	private String descripcionCupon;
	private String proveedorDuenio;
	public Cupones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cupones(String codigoCupon, int porcentajeDto, String descripcionCupon, String proveedorDuenio) {
		super();
		this.codigoCupon = codigoCupon;
		this.porcentajeDto = porcentajeDto;
		this.descripcionCupon = descripcionCupon;
		this.proveedorDuenio = proveedorDuenio;
	}
	public String getCodigoCupon() {
		return codigoCupon;
	}
	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}
	public int getPorcentajeDto() {
		return porcentajeDto;
	}
	public void setPorcentajeDto(int porcentajeDto) {
		this.porcentajeDto = porcentajeDto;
	}
	public String getDescripcionCupon() {
		return descripcionCupon;
	}
	public void setDescripcionCupon(String descripcionCupon) {
		this.descripcionCupon = descripcionCupon;
	}
	public String getProveedorDuenio() {
		return proveedorDuenio;
	}
	public void setProveedorDuenio(String proveedorDuenio) {
		this.proveedorDuenio = proveedorDuenio;
	}

	

}
