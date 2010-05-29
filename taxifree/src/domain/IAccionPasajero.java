package domain;

import java.util.Collection;

/**
 * @uml.dependency  supplier="domain.Ruta"
 * @uml.dependency  supplier="domain.Pasajero"
 */
public interface IAccionPasajero {
	public Pasajero datosPasajero(String nick);
	public Collection<Viaje> buscarViaje(Ruta r);
	public void apuntarseAViaje(Pasajero pas,Ruta ruta, Viaje v);
	public Collection<Ruta> consultaRuta();
	public Ruta modificaRuta(Ruta r);
	public void eliminaRuta(Ruta r);
	public void setP(Pasajero p);
	public void setRuta(Ruta r);
	public Viaje seleccionaViajePasajero(String viajeID);
}
