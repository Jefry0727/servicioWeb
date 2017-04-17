/**
 * 
 */
package co.edu.eam.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.DetalleFactura;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @16/04/2017
 * @version 
 */
@Stateless
public class DetalleController {

	@EJB
	private PersistenceManagerLocal persistencia;
	
	
	public void crearDetalle(DetalleFactura detalle){
		
		persistencia.persist(detalle);
		
	}
	
}
