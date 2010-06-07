package domain;

import java.util.ArrayList;
import java.util.List;

import data.IConductorDAO;
import data.JDBCConductorDAO;

/**
 * @author    morentefj
 */
public class AccionConductorImpl implements IAccionConductor{

 
    /**
	 * @uml.property  name="conddao"
	 * @uml.associationEnd  
	 */
    private IConductorDAO conddao = new JDBCConductorDAO();

	
	private List<Viaje> listaViajeConductor=new ArrayList<Viaje>();
	
	public AccionConductorImpl(){

	}
	

	public List<Viaje> verViajesAsignados(String nickConductor) {
		listaViajeConductor= conddao.obtenerViajesConductor(nickConductor);
		
		return listaViajeConductor;
	}
		
			
		public Vehiculo obtenerVehiculoC(String nickConductor) {
			Vehiculo ve=conddao.obtenerVehiculo(nickConductor);
	
		return ve;
	}
		
		public Conductor datosConductor(String nickConductor) {
			Conductor user=conddao.selectConductor(nickConductor);

	
		return user;
	}

		public int verPuntosActualesConductor(String nickConductor){
			return conddao.obtenerPuntos(nickConductor);
		}
		
		public boolean existeViaje(Viaje viaje){
			return conddao.existeViaje(viaje);
		}

		public Viaje consultaViaje(String idViaje) {
				Viaje viaje = new Viaje();
				viaje = conddao.selectViaje(idViaje);
				return viaje;
		}
		
		public void updateViajeConductor(Viaje viaje) {
			
			conddao.updateViaje(viaje);

		}
	 

		public boolean existePasajerosViaje(String idViaje){
			return conddao.existePasajerosViaje(idViaje);
		}
	 
		public void insertarViajeConductor(String nick,Viaje viaje) {
			
			 conddao.insertarViajeC(nick,viaje);
			
		}

	 
		public Viaje  cambiaEstadoViaje( String idViaje) {
			return conddao.cambiaEstadoViaje(idViaje);
			
		}
		
		public boolean eliminaViaje( String idViaje){
			return conddao.eliminaViajeC(idViaje);
		}

	
}
