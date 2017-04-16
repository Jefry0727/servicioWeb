/**
 * 
 */
package co.edu.eam.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.model.Producto;
import co.edu.eam.model.Usuario;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @16/04/2017
 * @version 
 */
public class CarritoDTO {

	private String cantidad;

	private ProductoDTO productoDTO;

	private UsuarioDTO usuarioDTO;
	
	private String valorTotal;

	/**
	 * @return the cantidad
	 */
	public String getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}



	/**
	 * @return the valorTotal
	 */
	public String getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the productoDTO
	 */
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	/**
	 * @param productoDTO the productoDTO to set
	 */
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}

	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	
	
}
