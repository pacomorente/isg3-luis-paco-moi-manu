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
		String oidc=conddao.selectOIDConductor(nickConductor);
		List<String> listaOIDViajeConductor= conddao.obtenerViajesOIDConductor(oidc);

		for (String auxOIDCond: listaOIDViajeConductor){
			
			 Viaje viajeCond = conddao.selectViajeConductor(auxOIDCond);
			 listaViajeConductor.add(viajeCond);

		}
		return listaViajeConductor;
	}
		
			
		public Vehiculo obtenerVehiculoC(String nickConductor) {
			String oidc=conddao.selectOIDConductor(nickConductor);
			String oidVehiculoConductor= conddao.obtenerVehiculoOID(oidc);

		     Vehiculo ve = conddao.selectVehiculoConductor(oidVehiculoConductor);
	
		return ve;
	}
		

		public Viaje consultaViaje(Viaje viaje) {
			//return 	viadao.selectTrayectoOID(trayecto);
			return null;
		}
	 
		public boolean eliminaViaje(Viaje viaje) {
	        //tdao.deleteTrayectoOID(tra.getIdTrayecto());
	        return true;
			
		}

	 
		public void insertarViaje(Viaje viaje) {
			// TODO Auto-generated method stub
			
		}

	 
		public Viaje  modificaViaje(Viaje viaje) {
			// TODO Auto-generated method stub
			return null;
		}


		public boolean eliminaVehiculo(Vehiculo vehiculo) {
			// TODO Auto-generated method stub
			return false;
		}


	 
		public void insertarVehiculo(Vehiculo vehiculo) {
			// TODO Auto-generated method stub
			
		}


	 
		public Vehiculo modificaVehiculo(Vehiculo vehiculo) {
			// TODO Auto-generated method stub
			return null;
		}





	
	
	
}
