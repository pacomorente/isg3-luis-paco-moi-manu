package modelado;

import java.util.Collection;

public interface IAccionPasajero {
	public Collection<Ruta> buscarRuta();
	public void apuntarseARuta(Ruta r);
	public Collection<Ruta> consultaRuta();
	public Ruta modificaRuta(Ruta r);
	public void eliminaRuta(Ruta r);
}
