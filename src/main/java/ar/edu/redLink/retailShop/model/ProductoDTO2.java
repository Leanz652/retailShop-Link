package ar.edu.redLink.retailShop.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO2 {
	private Double precio;
	private TipoProducto tipoProducto;
	private String descripcion;
	private String nombre;
	private String proveedor;
	private UUID idVendedor;
}