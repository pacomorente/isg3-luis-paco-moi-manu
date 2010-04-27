package domain;

import java.util.List;

import data.IVehiculoDAO;
import data.IViajeDAO;
import data.JDBCVehiculoDAO;
import data.JDBCViajeDAO;

/**
 * @author   morentefj
 */
public class AccionConductorImpl implements IAccionConductor{

    /**
	 * @uml.property  name="viadao"
	 * @uml.associationEnd  
	 */
    private IViajeDAO viadao = new JDBCViajeDAO();
    /**
	 * @uml.property  name="vehdao"
	 * @uml.associationEnd  
	 */
    private IVehiculoDAO vehdao = new JDBCVehiculoDAO();
	
	/**
	 * @uml.property  name="cond"
	 * @uml.associationEnd  
	 */
	private Conductor cond;
	private List<Viaje> viaje;
	
	public AccionConductorImpl(Conductor c, List<Viaje> v){
		this.setCond(c);
		this.viaje = v;
	}
	

	/**
	 * @param  c
	 * @uml.property  name="cond"
	 */
	private void setCond(Conductor c) {
		this.cond=c;
		
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

 
	public List<Viaje> verViajesAsignados(Viaje viaje) {
		return viadao.selectAllViajes();
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

	/*@Override
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
*/



	
	
	
}
