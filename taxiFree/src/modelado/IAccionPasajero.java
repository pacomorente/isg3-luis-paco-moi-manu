package modelado;

import java.util.Collection;

public interface IAccionPasajero {
	public Collection<Viaje> buscarViaje(Ruta r);
	public void apuntarseAViaje(Ruta r);
	public Collection<Viaje> consultaRuta();
	public Ruta modificaRuta(Ruta r);
	public void eliminaRuta(Ruta r);
}
