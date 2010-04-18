package modelado;

import java.util.Collection;

public class AccionPasajeroImpl implements IAccionPasajero{

	Pasajero p;
	
	public AccionPasajeroImpl(Pasajero p){
		this.p = p;
	}
	
	public void apuntarseARuta(Ruta r) {
		
	}

	@Override
	public Collection<Ruta> buscarRuta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Ruta> consultaRuta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminaRuta(Ruta r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ruta modificaRuta(Ruta r) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
