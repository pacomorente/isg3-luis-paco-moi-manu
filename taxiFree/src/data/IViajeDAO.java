package data;

import java.sql.Connection;
import java.util.List;

import domain.Viaje;

/**
 * @uml.dependency  supplier="data.IConductorDAO"
 * @uml.dependency  supplier="data.IPasajeroDAO"
 * @uml.dependency  supplier="data.ConnectionManager"
 * @uml.dependency  supplier="data.IVehiculoDAO"
 */
public interface IViajeDAO {
	public void insertViaje(Viaje v);
	public List<Viaje> selectAllViajes();
	public Viaje selectViaje(String s);
	public List<Viaje> selectViajes(Connection con, String oidPasajero);
	public void deleteViaje(String ViajeOID);
	//public void updateViaje(Viaje v, String userOID);
	public Viaje selectViajeConductor(Connection con,String oidViajeConductor);
	//public List<String> obtenerViajesOIDConductor(Connection conn, String oidc);
}
