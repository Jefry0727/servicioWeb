package co.edu.eam.model;

import java.io.Serializable;
import javax.persistence.*;
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

	public Carrito() {
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

}