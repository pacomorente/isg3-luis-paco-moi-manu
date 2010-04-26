package domain;

import java.util.List;

import data.IVehiculoDAO;
import data.IViajeDAO;
import data.JDBCVehiculoDAO;
import data.JDBCViajeDAO;

public class AccionConductorImpl implements IAccionConductor{

    private IViajeDAO viadao = new JDBCViajeDAO();
    private IVehiculoDAO vehdao = new JDBCVehiculoDAO();
	
	private Conductor cond;
	private List<Viaje> viaje;
	
	public AccionConductorImpl(Conductor c, List<Viaje> v){
		this.setCond(c);
		this.viaje = v;
	}
	

	private void setCond(Conductor c) {
		this.cond=c;
		
	}


	@Override
	public Viaje consultaViaje(Viaje viaje) {
		//return 	viadao.selectTrayectoOID(trayecto);
		return null;
	}
	@Override
	public boolean eliminaViaje(Viaje viaje) {
        //tdao.deleteTrayectoOID(tra.getIdTrayecto());
        return true;
		
	}

	@Override
	public void insertarViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Viaje  modificaViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viaje> verViajesAsignados(Viaje viaje) {
		return viadao.selectAllViajes();
	}


	@Override
	public boolean eliminaVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void insertarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}


	@Override
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
