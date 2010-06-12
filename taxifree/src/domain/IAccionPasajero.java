package domain;

import java.util.Collection;
import java.util.List;

/**
 * @uml.dependency  supplier="domain.Ruta"
 * @uml.dependency  supplier="domain.Pasajero"
 */
public interface IAccionPasajero {
	public Pasajero datosPasajero(String nick);
	public Collection<Viaje> buscarViaje(Ruta r, String nick);
	public void apuntarseAViaje(Pasajero pas,Ruta ruta, Viaje v);
	public Collection<Ruta> consultaRuta();
	public void modificaRuta(Ruta ra, Ruta rn);
	public void modificaViajePasajero(String vidAnt, String vidNuevo, String idRuta);
	public void eliminaRuta(Ruta r);
	public void setP(Pasajero p);
	public void setRuta(Ruta r);
	public Viaje seleccionaViajePasajero(String viajeID);
	public List<Ruta> seleccionaRutasDelPasajero(String nick);
	public Ruta seleccionaRuta(String idRuta);
}
