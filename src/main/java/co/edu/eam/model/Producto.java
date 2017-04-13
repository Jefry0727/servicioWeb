package co.edu.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cantidad;

	private String nombre;

	private BigDecimal valor;

	//bi-directional many-to-one association to Carrito
//	@OneToMany(mappedBy="producto")
//	private List<Carrito> carritos;

	//bi-directional many-to-one association to DetalleFactura
//	@OneToMany(mappedBy="producto")
//	private List<DetalleFactura> detalleFacturas;

	public Producto() {
	}
	
	

	/**
	 * @param id
	 */
	public Producto(Integer id) {
		super();
		this.id = id;
	}
	



	/**
	 * @param id
	 * @param cantidad
	 */
	public Producto(Integer id, Integer cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

//	public List<Carrito> getCarritos() {
//		return this.carritos;
//	}
//
//	public void setCarritos(List<Carrito> carritos) {
//		this.carritos = carritos;
//	}

//	public Carrito addCarrito(Carrito carrito) {
//		getCarritos().add(carrito);
//		carrito.setProducto(this);
//
//		return carrito;
//	}
//
//	public Carrito removeCarrito(Carrito carrito) {
//		getCarritos().remove(carrito);
//		carrito.setProducto(null);
//
//		return carrito;
//	}

//	public List<DetalleFactura> getDetalleFacturas() {
//		return this.detalleFacturas;
//	}
//
//	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
//		this.detalleFacturas = detalleFacturas;
//	}
//
//	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
//		getDetalleFacturas().add(detalleFactura);
//		detalleFactura.setProducto(this);
//
//		return detalleFactura;
//	}
//
//	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
//		getDetalleFacturas().remove(detalleFactura);
//		detalleFactura.setProducto(null);
//
//		return detalleFactura;
//	}

}