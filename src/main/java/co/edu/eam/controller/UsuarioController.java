/**
 * 
 */
package co.edu.eam.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Usuario;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @12/04/2017
 * @version 
 */
@Stateless
public class UsuarioController {
	
	@EJB
	private PersistenceManagerLocal persisUsers;
	
	/**
	 * 
	 * <p><b>Funcion que crea los usuario y los guarda en la base de datos </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         12/04/2017
	 * @version 1.0
	 * @param usuario
	 * @return
	 */
	public boolean crearUsuario (Usuario usuario){
		
		try{
			
			persisUsers.persist(usuario);
			
			return true;
			
		}catch (Exception e) {
			
			return false;
			
		}
		
		
	}

}
