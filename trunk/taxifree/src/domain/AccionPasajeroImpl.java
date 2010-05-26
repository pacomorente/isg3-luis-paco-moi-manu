package domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import data.IPasajeroDAO;
import data.IRutaDAO;
import data.JDBCPasajeroDAO;
import data.JDBCRutaDAO;

/**
 * @uml.dependency  supplier="domain.Pasajero"
 */
public class AccionPasajeroImpl implements IAccionPasajero{

	/**
	 * @uml.property  name="p"
	 * @uml.associationEnd  
	 */
	private Pasajero p;
	private List<Viaje> v;
	/**
	 * @uml.property  name="rutaDePasajero"
	 * @uml.associationEnd  
	 */
	private Ruta rutaDePasajero;
	
	public AccionPasajeroImpl(){
		v = new ViajeStore().getViajes();
	}
	
	public void apuntarseAViaje(Viaje v) {
		IPasajeroDAO pdao = new JDBCPasajeroDAO();
		pdao.insert(p, rutaDePasajero, v);
	}


	public Collection<Viaje> buscarViaje(Ruta r) {
		//Lo almacenamos aqui porque antes de apuntarse
		//a un viaje obligatoriamente lo tiene que buscar.
		rutaDePasajero = r;
		List<Viaje> res = new LinkedList<Viaje>();
		for(Viaje vp:v){
			String origen = vp.getOrigen().toLowerCase();
			String destino = vp.getDestino().toLowerCase();
			String desde = r.getOrigen();
			String hasta = r.getDestino();
			if(destino.equals(hasta)){
				if(origen.equals(desde)){
					res.add(vp);
				}else{
					for(String o: vp.getPuntosIntermedios()){
						if(o.toLowerCase().equals(desde)){
							res.add(vp);
						}
					}
				}
			}
		}
		return res;
	}


	public Collection<Ruta> consultaRuta() {
		IRutaDAO rdao = new JDBCRutaDAO();
		return rdao.selectAllRutas();
	}


	public void eliminaRuta(Ruta r) {
		// TODO Auto-generated method stub
		
	}


	public Ruta modificaRuta(Ruta r) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param  p
	 * @uml.property  name="p"
	 */
	public void setP(Pasajero p) {
		this.p = p;
	}

	/**
	 * @return
	 * @uml.property  name="p"
	 */
	public Pasajero getP() {
		return p;
	}
	
	
	
}
