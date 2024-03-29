package data;

import java.util.List;

import domain.Pasajero;
import domain.Ruta;
import domain.Viaje;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IPasajeroDAO {
	public List<Pasajero> selectAllPasajeros();
	public String selectPasajeroOID(String nick);
	public Pasajero selectPasajero(String pasajeroOID);
	public void insert(Pasajero p, Ruta r, Viaje v);
	public List<Pasajero> selectPasajerosbyViaje(String oidviaje);
}
