package ar.edu.redLink.retailShop.app.apiDolar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dolar {
	
	private String venta;
	
	
	  public String getVenta() {
		return venta;
	}


	public void setVenta(String venta) {
		this.venta = venta;
	}


	@Override
	  public String toString() {
	    return "venta=" + venta;
	  }

}
