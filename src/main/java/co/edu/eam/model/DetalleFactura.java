package co.edu.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the detalle_factura database table.
 * 
 */
@Entity
@Table(name="detalle_factura")
@NamedQuery(name="DetalleFactura.findAll", query="SELECT d FROM DetalleFactura d")
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="valor_total")
	private double valorTotal;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	public DetalleFactura() {
	}
	
	

	/**
	 * @param id
	 * @param cantidad
	 * @param fecha
	 * @param valorTotal
	 * @param factura
	 * @param producto
	 */
	public DetalleFactura(Integer id, Integer cantidad, Date fecha, double valorTotal, Factura factura,
			Producto producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.valorTotal = valorTotal;
		this.factura = factura;
		this.producto = producto;
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

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}