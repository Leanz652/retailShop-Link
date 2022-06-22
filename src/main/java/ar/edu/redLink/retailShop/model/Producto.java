package ar.edu.redLink.retailShop.model;


import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import ar.edu.redLink.retailShop.app.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Producto {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private boolean activo;
	
	@Enumerated
	@NotNull
	private TipoProducto tipoProducto;
	
	@NotNull
	private Double precio;
	@NotBlank
	private String nombre;
	@NotBlank
	@Column(length=1000000)
	private String descripcion;
	
	@ManyToOne
	private Vendedor vendedor;
	
	@OneToOne
	private Image imagen; 
	
	private LocalDate fechaDePublicacion;
	
	
	@ManyToOne
	@JoinColumn(name="PROVEEDOR_ID")
	private Proveedor proveedorDeProducto;

	
	
	
}
