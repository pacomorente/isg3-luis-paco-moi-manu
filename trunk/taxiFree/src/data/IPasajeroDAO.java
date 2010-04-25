package data;

import java.util.List;

import domain.Pasajero;

/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public interface IPasajeroDAO {
	public List<Pasajero> selectAllPasajeros();
	public Pasajero selectPasajero(String nick);
}
