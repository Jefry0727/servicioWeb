/**
 * 
 */
package co.edu.eam.controller;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Carrito;

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
		
		try{
			
			persistencia.persist(carrito);
			
			return true;
			
		}catch (Exception e) {

			return false;
			
		}
		
		
		
	}

}
