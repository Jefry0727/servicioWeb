/**
 * 
 */
package co.edu.eam.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import co.edu.eam.dto.CarritoDTO;
import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Carrito;
import co.edu.eam.model.Producto;
import co.edu.eam.model.Usuario;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com> @13/04/2017
 * @version
 */
@Stateless
@WebService(name = "CarritoController", portName = "CarriControPort", targetNamespace = "http://co.edu.eam.ingsoft.distribuidos")
public class CarritoController {

	@EJB
	private PersistenceManagerLocal persistencia;
	

	@WebMethod(action = "AgregarCarrito", operationName = "operacionAgregarCarrito")
	public boolean agregarCarrito(@WebParam(name = "carritoDTO") CarritoDTO carritoDTO) {
		
		System.out.println(carritoDTO.getValorTotal() + " Este es el valor");
		
		Date fecha = new Date();
		
		Producto producto = new Producto();
		
		producto.setId(Integer.parseInt(carritoDTO.getProductoDTO().getId()));
		
		Usuario users = new Usuario();
		
		users.setId(Integer.parseInt(carritoDTO.getUsuarioDTO().getId()));
		
		Carrito carrito = new Carrito(1, Integer.parseInt(carritoDTO.getCantidad()), fecha, producto,users , Double.parseDouble(carritoDTO.getValorTotal()));

		if (validarProductos(carrito)) {

			try {
				
				persistencia.persist(carrito);

				return true;

			} catch (Exception e) {

				return false;

			}

		} else {

			return false;
		}

	}

	public boolean validarProductos(Carrito carrito) {

		Query querie = persistencia.createQuery("SELECT p FROM Producto p where p.id='" + carrito.getProducto().getId() + "'");

		Producto produc = (Producto) querie.getSingleResult();

		if ((produc.getCantidad().intValue()) <= (carrito.getCantidad().intValue())) {

			return false;

		}

		return true;

	}

	@WebMethod
	public List<Carrito> listarCarrito() {

		Query query = persistencia.createQuery("SELECT p FROM Carrito p ");

		List<Carrito> lista = (List<Carrito>) query.getResultList();

		return lista;

	}

}
