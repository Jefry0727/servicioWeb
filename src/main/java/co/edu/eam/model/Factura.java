package co.edu.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String numero;

	@Column(name="valor_total")
	private double valorTotal;

	//bi-directional many-to-one association to DetalleFactura
//	@OneToMany(mappedBy="factura")
//	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Factura() {
	}
	
	

	/**
	 * @param id
	 * @param fecha
	 * @param numero
	 * @param valorTotal
	 * @param usuario
	 */
	public Factura(Integer id, Date fecha, String numero, double valorTotal, Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.usuario = usuario;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

//	public List<DetalleFactura> getDetalleFacturas() {
//		return this.detalleFacturas;
//	}
//
//	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
//		this.detalleFacturas = detalleFacturas;
//	}

//	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
//		getDetalleFacturas().add(detalleFactura);
//		detalleFactura.setFactura(this);
//
//		return detalleFactura;
//	}
//
//	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
//		getDetalleFacturas().remove(detalleFactura);
//		detalleFactura.setFactura(null);
//
//		return detalleFactura;
//	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}