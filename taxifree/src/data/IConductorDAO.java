package data;

import java.util.List;

import domain.Conductor;
import domain.Vehiculo;
import domain.Viaje;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IConductorDAO {
	public List<Conductor> sellectAllConductores();
	public Conductor selectConductor(String nick);
	
	public String selectOIDConductor(String nickConductor);
	
	public List<String>obtenerViajesOIDConductor(String oidc);
	
	public Viaje selectViajeConductor(String auxOIDCond);
	public String obtenerVehiculoOID(String oidc);
	
	public Vehiculo selectVehiculoConductor(String oidVehiculoConductor);
	public Viaje selectViaje(String idViaje);
	
	public Conductor selectConductorbyViaje(String oidviaje);
	
	public Viaje  cambiaEstadoViaje( String idViaje); // anular - activar viaje
	public void insertarViajeC(String nick, Viaje viaje);
	public boolean eliminaViajeC(String idViaje);
	
	public void insertarC(String oidc, String oidv,
			String oidveh);
	public void delete(String nick,String oidViaje);
	
}
