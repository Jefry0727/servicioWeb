package co.edu.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	private String password;

	//bi-directional many-to-one association to Carrito
//	@OneToMany(mappedBy="usuario")
//	private List<Carrito> carritos;

	//bi-directional many-to-one association to Factura
//	@OneToMany(mappedBy="usuario")
//	private List<Factura> facturas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
//		carrito.setUsuario(this);
//
//		return carrito;
//	}
//
//	public Carrito removeCarrito(Carrito carrito) {
//		getCarritos().remove(carrito);
//		carrito.setUsuario(null);
//
//		return carrito;
//	}

//	public List<Factura> getFacturas() {
//		return this.facturas;
//	}
//
//	public void setFacturas(List<Factura> facturas) {
//		this.facturas = facturas;
//	}
//
//	public Factura addFactura(Factura factura) {
//		getFacturas().add(factura);
//		factura.setUsuario(this);
//
//		return factura;
//	}
//
//	public Factura removeFactura(Factura factura) {
//		getFacturas().remove(factura);
//		factura.setUsuario(null);
//
//		return factura;
//	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}