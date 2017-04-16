/**
 * 
 */
package co.edu.eam.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import co.edu.eam.dto.ItemsDTO;
import co.edu.eam.ejb.PersistenceManagerLocal;
import co.edu.eam.model.Carrito;
import co.edu.eam.model.Cliente;
import co.edu.eam.model.DetalleFactura;
import co.edu.eam.model.Factura;
import co.edu.eam.model.Producto;
import co.edu.eam.model.Usuario;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com> @12/04/2017
 * @version
 */
@Stateless
@WebService
public class FacturaController {

	@EJB
	private PersistenceManagerLocal persistencia;

	@WebMethod
	public String crearCompra(@WebParam(name = "id_usuario") Integer id,
			@WebParam(name = "total_factura") Double total_fac,
			@WebParam(name = "detalles_factura") List<ItemsDTO> items) {

		String result = "";
		
		Producto validor = validarItems(items);
		
		if (validor == null) {

			/**
			 * Crea el usuario y setea el id para adicionarlo en la factura como
			 * foranea
			 */
			Usuario usuario = new Usuario();
			usuario.setId(id);

			/**
			 * Crea la fecha actual que servira para guardar la fecha de factura
			 */
			Date fecha = new Date();

			/**
			 * Obtiene el ultimo id y suma una unidad mas para formar la nueva
			 * factura
			 */
			Query query = persistencia.createQuery("SELECT MAX(f.id) FROM Factura f");

			/**
			 * Nuevo numero
			 */
			int aux = ((Integer) query.getSingleResult()).intValue() + 1;

			/**
			 * Nuevo numero mas un C antes del numero
			 */
			String num_fac = "C " + aux;

			/**
			 * Objeto Factura que se va a guardar en la base de datos
			 */
			Factura factura = new Factura(1, fecha, num_fac, total_fac, usuario);

			/**
			 * Guardado de la factura
			 */
			persistencia.persist(factura);

			/**
			 * Busca la factura que se acabo de guardar para obtener el id que
			 * sera la foranea de detalle factura
			 */
			query = persistencia.createQuery("SELECT f FROM Factura f where f.numero='" + num_fac + "'");

			/**
			 * factura obtenida en la busqueda
			 */
			factura = (Factura) query.getSingleResult();

			/**
			 * for que guarda los detalles de facturas
			 */
			for (ItemsDTO itemsDTO : items) {

				query = persistencia.createQuery("SELECT p FROM Producto p where p.id='" + itemsDTO.getId() + "'");

				Producto producto = (Producto) query.getSingleResult();

				aux = (Integer.parseInt(itemsDTO.getCantidad())) - (producto.getCantidad().intValue());

				producto.setCantidad(aux);

				persistencia.update(producto);

				DetalleFactura detalle = new DetalleFactura(0, Integer.parseInt(itemsDTO.getCantidad()), fecha, Integer.parseInt(itemsDTO.getValorTotal()),
						factura, producto);

				persistencia.persist(detalle);

				eliminarCarrito(producto.getId(), usuario.getId());

			}
			
			result = "Exito";
			
			return result;

		} else {
			
			result = "El producto " + validor.getNombre() + " solo tiene disponible " + validor.getCantidad();

		 return result;

		}

	}

	public Producto validarItems(List<ItemsDTO> items) {

		for (ItemsDTO itemsDTO : items) {

			Query querie = persistencia.createQuery("SELECT p FROM Producto p where p.id='" + itemsDTO.getId() + "'");

			Producto produc = (Producto) querie.getSingleResult();

			if ((produc.getCantidad().intValue()) <= (Integer.parseInt(itemsDTO.getCantidad()))) {

				return produc;

			}

		}

		return null;

	}

	public void eliminarCarrito(Integer idProducto, Integer idUsuario) {

		Query query = persistencia.createQuery(
				"SELECT c FROM Carrito c where c.producto.id = " + idProducto + " and c.usuario.id = " + idUsuario);

		System.out.println(query.toString());

		Carrito carrito = (Carrito) query.getSingleResult();

		System.out.println(carrito.getCantidad());

		persistencia.remove(carrito.getClass(), carrito.getId());

	}

}
