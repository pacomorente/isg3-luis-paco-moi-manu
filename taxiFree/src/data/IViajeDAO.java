package data;

import java.util.List;

import domain.Viaje;

/**
 * @uml.dependency   supplier="data.IConductorDAO"
 * @uml.dependency   supplier="data.ConnectionManager"
 * @uml.dependency   supplier="data.IVehiculoDAO"
 * @uml.dependency   supplier="data.IPasajeroDAO"
 */
public interface IViajeDAO {
	public void insertViaje(Viaje v);
	public List<Viaje> selectAllViajes();
	public Viaje selectViaje(String s);
	public void deleteViaje(String ViajeOID);
	//public void updateViaje(Viaje v, String userOID);
}
