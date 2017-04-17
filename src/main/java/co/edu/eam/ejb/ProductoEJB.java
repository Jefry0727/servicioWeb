/**
 * 
 */
package co.edu.eam.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.edu.eam.model.Producto;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com> @16/04/2017
 * @version
 */
@Stateless
public class ProductoEJB {

	@EJB
	private PersistenceManagerLocal persistencia;

	public void actualizarProducto(Producto producto) {

		persistencia.update(producto);
	}

}
