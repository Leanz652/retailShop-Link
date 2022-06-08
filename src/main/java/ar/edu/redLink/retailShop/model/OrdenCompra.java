package ar.edu.redLink.retailShop.model;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
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
	@Transient
	private Collection<ItemProducto> itemsComprados;
	@Transient
	private Collection<Promociones> promocionesAplicadas;
	
	
	
	public OrdenCompra() {
		super();

	}	
	
	public OrdenCompra(Cliente clienteComprador, Vendedor vendedor, Collection<ItemProducto> itemsComprados,
			Collection<Promociones> promocionesAplicadas) {
		super();
		this.clienteComprador = clienteComprador;
		this.vendedor = vendedor;
		this.itemsComprados = itemsComprados;
		this.promocionesAplicadas = promocionesAplicadas;
		this.fechaCompra = LocalDate.now();
	}
	
	
	
	public Cliente getClienteComprador() {
		return clienteComprador;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public Collection<ItemProducto> getItemsComprados() {
		return itemsComprados;
	}
	public Collection<Promociones> getPromocionesAplicadas() {
		return promocionesAplicadas;
	}
	
	public Double montoFinalSinPromo() {
		return itemsComprados.stream().mapToDouble(item -> item.precioFinal()).sum();
	}
	
	// TODO - Implementar lógica de aplicar promociones 
	public Double montoFinalConPromo() {
		return itemsComprados.stream().mapToDouble(item -> item.precioFinal()).sum();
	}

}
