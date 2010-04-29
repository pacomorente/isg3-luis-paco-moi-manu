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
	public String selectOIDConductor(String nickConcductor);
	public List<String>obtenerViajesOIDConductor(String oidc);
	public Viaje selectViajeConductor(String auxOIDCond);
	public String obtenerVehiculoOID(String oidc);
	public Vehiculo selectVehiculoConductor(String oidVehiculoConductor);
}
