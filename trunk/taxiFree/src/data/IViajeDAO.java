package data;

import java.util.List;

import java.sql.Connection;

import domain.Viaje;

/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public interface IViajeDAO {
	public void insertViaje(Viaje v, String userOID);
	public List<Viaje> selectAllViajes();
	public Viaje selectViaje(String s);
	public void deleteViaje(Connection conn, String ViajeOID);
	public void updateViaje(Viaje v, String userOID);
}
