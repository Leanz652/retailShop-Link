package ar.edu.redLink.retailShop.model;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class OrdenCompra {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente clienteComprador;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	
	private LocalDate fechaCompra;

	@OneToOne
	private ItemProducto itemComprado;
	
	@ManyToMany
	@JoinTable(
	  name = "orden_promo", 
	  joinColumns = @JoinColumn(name = "orden_id"), 
	  inverseJoinColumns = @JoinColumn(name = "promo_id"))
	private Collection<Promociones> promocionesAplicadas;
	
}