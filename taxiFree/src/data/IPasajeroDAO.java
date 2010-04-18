package data;

import java.util.List;

import domain.Pasajero;

public interface IPasajeroDAO {
	public List<Pasajero> selectAllPasajeros();
	public Pasajero selectPasajero(String nick);
}
