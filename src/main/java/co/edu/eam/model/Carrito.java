package co.edu.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	// bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	public Carrito() {
	}
	
	

	/**
	 * @param id
	 * @param cantidad
	 * @param fecha
	 * @param producto
	 * @param usuario
	 * @param valorTotal
	 */
	public Carrito(Integer id, Integer cantidad, Date fecha, Producto producto, Usuario usuario,
			BigDecimal valorTotal) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.producto = producto;
		this.usuario = usuario;
		this.valorTotal = valorTotal;
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}