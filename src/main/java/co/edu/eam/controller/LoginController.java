/**
 * 
 */
package co.edu.eam.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Usuario;

	

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @12/04/2017
 * @version 
 */
@Stateless
@WebService(name = "LoginController", portName = "LogCtlPort", targetNamespace = "http://co.edu.eam.ingsoft.distribuidos")
public class LoginController {
	
	@EJB
	private PersistenceManagerLocal persistencia;
	
	@WebMethod(action = "login", operationName = "operacionLogin")
	public Usuario login(@WebParam(name="nombre_usuario")String user, @WebParam(name="contrasenia")String password){
		
		try{
			
			System.out.println(user+", "+ password);
			
			Query query = persistencia.createQuery("SELECT m FROM Usuario m where m.nombreUsuario='"+user+"' and m.password = '"+password+"'");
			
			Usuario result = (Usuario) query.getSingleResult();
				
			return result;
			
		}catch (Exception e) {
			
			return null;
			
		}
	
	}
}
