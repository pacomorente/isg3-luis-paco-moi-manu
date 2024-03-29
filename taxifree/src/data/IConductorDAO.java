package data;

import java.util.List;

import domain.Conductor;
import domain.Vehiculo;
import domain.Viaje;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IConductorDAO {

	public Conductor selectConductor(String nick);
	
	public String selectOIDConductor(String nickConductor);
	
	public List<Viaje>obtenerViajesOIDConductor(String nickconductor);
	
	public Viaje selectViajeConductor(String auxOIDCond);
	public String obtenerVehiculoOID(String oidc);
	
	public Vehiculo selectVehiculoConductor(String oidVehiculoConductor);
	public Viaje selectViaje(String idViaje);
	public Conductor selectConductorDeViaje(String viajeID);
	
	public Conductor selectConductorbyViaje(String oidviaje);
	
	public Viaje  cambiaEstadoViaje( String idViaje); // anular - activar viaje
	public void insertarViajeC(String nick, Viaje viaje);
	public boolean eliminaViajeC(String idViaje);
	
	public void insertarC(String oidc, String oidv,
			String oidveh);
	public void delete(String nick,String oidViaje);
	public Vehiculo obtenerVehiculo(String nick);
	public List<Viaje> obtenerViajesConductor(String nickConductor);
	public void actualizarPuntosConductor(String oidc, String tipo, int estrellas);
	public int obtenerPuntos (String nick);
	public void updateViaje(Viaje viaje);
	public boolean existePasajerosViaje(String idViaje);
	public boolean existeViaje(Viaje viaje);
	
	public boolean existeViajeAlta(Viaje v, String nick);
/*	
	public List<Conductor> sellectAllConductores();
	*/
}
