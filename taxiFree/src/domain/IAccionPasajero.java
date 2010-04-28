package domain;

import java.util.Collection;

/**
 * @uml.dependency  supplier="domain.Ruta"
 * @uml.dependency  supplier="domain.Pasajero"
 */
public interface IAccionPasajero {
	public Collection<Viaje> buscarViaje(Ruta r);
	public void apuntarseAViaje(Ruta r);
	public Collection<Ruta> consultaRuta();
	public Ruta modificaRuta(Ruta r);
	public void eliminaRuta(Ruta r);
}
