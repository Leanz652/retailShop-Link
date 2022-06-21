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
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="orden_compra")
public class OrdenCompra {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "id")
	private Cliente clienteComprador;
	
	@ManyToOne
	@JoinColumn(name = "VENDEDOR_ID", referencedColumnName = "id")
	private Vendedor vendedor;
	
	private LocalDate fechaCompra;

	@OneToOne
	private ItemProducto itemsComprados;
	
	@ManyToMany
	@JoinTable(
	  name = "orden_promo", 
	  joinColumns = @JoinColumn(name = "orden_id"), 
	  inverseJoinColumns = @JoinColumn(name = "promo_id"))
	private Collection<Promociones> promocionesAplicadas;
	
}
