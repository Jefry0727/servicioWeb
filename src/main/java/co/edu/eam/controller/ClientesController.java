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
import co.edu.eam.model.Cliente;
import co.edu.eam.model.Usuario;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com> @11/04/2017
 * @version
 */
@Stateless
@WebService
public class ClientesController {

	@EJB
	private PersistenceManagerLocal persistencia;

	@EJB
	private UsuarioController usersCliente;

	/**
	 * 
	 */
	public ClientesController() {
		super();
	}
	/**
	 * 
	 * <p><b>Funcion que crea el cliente y el usuario </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         12/04/2017
	 * @version 1.0
	 * @param cliente
	 * @param password
	 * @param nombreUsuario
	 * @return
	 */
	@WebMethod(action = "crearElCliente", operationName = "operacionCrear")
	public String crearCliente(@WebParam(name = "client") Cliente cliente,
			@WebParam(name = "contrasenia") String password, @WebParam(name = "usuario") String nombreUsuario) {

		String respuesta = "OK";

		try {

			/**
			 * Se guarda en cliente en la base de datos
			 */
			persistencia.persist(cliente);

			/**
			 * Se ejecuta un createQuery para traer el id del cliente que se
			 * guardo
			 */
			Query query = persistencia
					.createQuery("SELECT c FROM Cliente c where c.cedula='" + cliente.getCedula() + "'");

			/**
			 * Se obtiene el resultado tipo cliente que se guardo anteriomente
			 */
			Cliente result = (Cliente) query.getSingleResult();

			/**
			 * Instancia del objeto tipo Usuairo
			 */
			Usuario users = new Usuario();

			users.setNombreUsuario(nombreUsuario);

			users.setPassword(password);

			users.setId(1);

			users.setCliente(result);

			/**
			 * Se llama el controlador EJB que creara el Usuario
			 */
			boolean response = usersCliente.crearUsuario(users);

			if (!response) {

				respuesta = "ERROR";

				return respuesta;

			}

			return respuesta;
		} catch (Exception e) {

			respuesta = "ERRORS";

			return respuesta;

		}

	}

}
