package domain;

import java.util.Collection;

/**
 * @uml.dependency  supplier="domain.Ruta"
 * @uml.dependency  supplier="domain.Pasajero"
 */
public interface IAccionPasajero {
	public Pasajero datosPasajero(String nick);
	public Collection<Viaje> buscarViaje(Ruta r);
	public void apuntarseAViaje(Viaje v);
	public Collection<Ruta> consultaRuta();
	public Ruta modificaRuta(Ruta r);
	public void eliminaRuta(Ruta r);
	public void setP(Pasajero p);
}
