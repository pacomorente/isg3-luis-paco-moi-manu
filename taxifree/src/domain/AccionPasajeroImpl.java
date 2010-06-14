package domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import data.IConductorDAO;
import data.IPasajeroDAO;
import data.IRutaDAO;
import data.JDBCConductorDAO;
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
	
	public void apuntarseAViaje(Pasajero pas,Ruta ruta, Viaje v) {
		IPasajeroDAO pdao = new JDBCPasajeroDAO();
		pdao.insert(pas, ruta, v);
	}


	public Collection<Viaje> buscarViaje(Ruta r, String nick) {
		IConductorDAO condDAO = new JDBCConductorDAO();
		List<Viaje> res = new LinkedList<Viaje>();
		for(Viaje vp:v){
			//Parametros del viaje
			String origen = vp.getOrigen().toLowerCase();
			String destino = vp.getDestino().toLowerCase();
			String fecha = vp.getFecha();
			List<Pasajero> pasajeros = vp.getPasajeros();
			int numPas = pasajeros.size();
			String idViaje = vp.getViajeID();
			boolean anulado = vp.getAnulado();
			Conductor c = condDAO.selectConductorDeViaje(idViaje);
			
			//Paramentros de la ruta
			String desde = r.getOrigen();
			String hasta = r.getDestino();
			String fechaRuta = r.getFecha();
			
			//Comprobamos que el usuario no este ya en el viaje
			boolean incluido = false;
			for(Pasajero p: pasajeros){
				if(p.getNick().equals(nick)){
					incluido = true;
				}
			}
			
			
			if(!c.getNick().equals(nick) && !anulado && !incluido){
				if(destino.equals(hasta)){
					if(origen.equals(desde)){
						if(fechaRuta.equals(fecha) && numPas<4){
							res.add(vp);
						}
					}else{
						for(String o: vp.getPuntosIntermedios()){
							if(o.toLowerCase().equals(desde)){
								if(fechaRuta.equals(fecha) && numPas<4){
									res.add(vp);
								}
							}
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
	
	public List<Ruta> seleccionaRutasDelPasajero(String nick){
		IRutaDAO ruta = new JDBCRutaDAO();
		return ruta.selectRutaPasajero(nick);
	}
	
	
	public Viaje seleccionaViajePasajero(String viajeID){
		IPasajeroDAO ip = new JDBCPasajeroDAO();
		return ip.selectViajeDePasajero(viajeID);
	}


	public void eliminaRuta(Ruta r) {
		IRutaDAO rutaDAO = new JDBCRutaDAO();
		rutaDAO.deleteRuta(r);
	}


	public void modificaRuta(Ruta ra, Ruta rn) {
		IRutaDAO rutaDAO = new JDBCRutaDAO();
		rutaDAO.updateRuta(ra, rn);
	}
	
	public void modificaViajePasajero(String vidAnt, String vidNuevo, String idRuta){
		IPasajeroDAO pasDAO = new JDBCPasajeroDAO();
		pasDAO.actualizaViajeDePasajero(vidAnt, vidNuevo, idRuta);
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

	public Pasajero datosPasajero(String nick) {
		IPasajeroDAO pasajero = new JDBCPasajeroDAO();
		return pasajero.selectPasajero(nick);
	}
	
	public void setRuta(Ruta r){
		this.rutaDePasajero = r;
	}

	public Ruta seleccionaRuta(String idRuta) {
		IRutaDAO rDao = new JDBCRutaDAO();
		return rDao.selectRuta(idRuta);
	}
	
}
