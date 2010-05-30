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
	public void insertViaje(Connection conn, String OIDViaje, Viaje v );
	public List<Viaje> selectAllViajes();
	public Viaje selectViaje(Connection conn, String s);
	public String selectViajeOID(Connection con,String idViaje);
	public List<Viaje> selectViajes(Connection con, String oidPasajero);
	public void deleteViaje(String ViajeOID);
	//public void modificaViaje(Connection con, String userOID);
	public Viaje selectViajeConductor(Connection con,String oidViajeConductor);
	//public List<String> obtenerViajesOIDConductor(Connection conn, String oidc);
	public Viaje  cambiaEstadoViaje(Connection con, String idViaje);
	public boolean  eliminaViaje(Connection con, String idViaje);
	public void updateViaje(Connection conn, Viaje viaje);
	public boolean existePasajerosViaje(Connection con, String idViaje);
}
