package domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @uml.dependency   supplier="domain.Pasajero"
 */
public class AccionPasajeroImpl implements IAccionPasajero{

	private Pasajero p;
	private Collection<Viaje> v;
	
	public AccionPasajeroImpl(Pasajero p, Collection<Viaje> v){
		this.setP(p);
		this.v = v;
	}
	
	public void apuntarseAViaje(Ruta r) {
		
	}

	@Override
	public Collection<Viaje> buscarViaje(Ruta r) {
		List<Viaje> res = new LinkedList<Viaje>();
		for(Viaje vp:v){
			if(vp.getDestino().equals(r.getDestino())){
				if(vp.getOrigen().equals(r.getOrigen())){
					res.add(vp);
				}else{
					if(vp.getPuntosIntermedios().contains(r.getOrigen())){
						res.add(vp);
					}
				}
			}
		}
		return res;
	}

	@Override
	public Collection<Viaje> consultaRuta() {
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

	public void setP(Pasajero p) {
		this.p = p;
	}

	public Pasajero getP() {
		return p;
	}
	
	
	
}
