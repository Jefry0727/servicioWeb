/**
 * 
 */
package co.edu.eam.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import co.edu.eam.model.Carrito;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @16/04/2017
 * @version 
 */
@Stateless
public class CarritoEJB {

	@EJB
	private PersistenceManagerLocal persistencia;
	
	public void eliminarCarrito(Integer idProducto, Integer idUsuario) {

		Query query = persistencia.createQuery(
				"SELECT c FROM Carrito c where c.producto.id = " + idProducto + " and c.usuario.id = " + idUsuario);

		System.out.println(query.toString());

		Carrito carrito = (Carrito) query.getSingleResult();

		//System.out.println(carrito.getCantidad());

		persistencia.remove(carrito.getClass(), carrito.getId());

	}
	
}
