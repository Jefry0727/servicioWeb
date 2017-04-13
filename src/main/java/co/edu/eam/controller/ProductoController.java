/**
 * 
 */
package co.edu.eam.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Producto;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @12/04/2017
 * @version 
 */
@Stateless
@WebService
public class ProductoController {
	
	@EJB
	private PersistenceManagerLocal persistencia;
	
	@WebMethod
	public List<Producto> listarProductos(@WebParam(name = "nombreProducto")String nombre){
		
		Query query = persistencia.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE '%"+nombre+"%'");
		
		List <Producto> lista = (List<Producto>) query.getResultList();
		
		return lista;
		
	}
	
}
