package data;

import java.util.List;

import domain.Viaje;

public interface IViajeDAO {
	public void insertViaje(Viaje v, String userOID);
	public List<Viaje> selectAllViajes();
	public Viaje selectViaje(String s);
	public void deleteViaje(String numViaje);
	public void updateViaje(Viaje v, String userOID);
}
