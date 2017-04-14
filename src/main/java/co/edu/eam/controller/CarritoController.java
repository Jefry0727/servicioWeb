/**
 * 
 */
package co.edu.eam.controller;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Carrito;
import co.edu.eam.model.Producto;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @13/04/2017
 * @version 
 */

@WebService
public class CarritoController {
	
	@EJB
	private PersistenceManagerLocal persistencia;
	
	@WebMethod
	public boolean agregarCarrito(@WebParam(name= "carrito")Carrito carrito){
		
		if(validarProductos(carrito)){
			
			try{
				
				persistencia.persist(carrito);
				
				return true;
				
			}catch (Exception e) {

				return false;
				
			}
			
		}else{
			
			return false;
		}
		
		
		
		
		
	}
	
	public boolean validarProductos(Carrito carrito){
		
		Query querie = persistencia.createQuery("SELECT p FROM Producto f where p.id='" + carrito.getId() + "'");

		Producto produc = (Producto) querie.getSingleResult();

		if ((produc.getCantidad().intValue()) > (carrito.getCantidad().intValue())) {

			return false;

		}
		
		return true;
		
	}

}
