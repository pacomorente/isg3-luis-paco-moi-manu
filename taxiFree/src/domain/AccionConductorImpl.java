package domain;

import java.util.List;

import data.ITrayectoDAO;
import data.IViajeDAO;
import data.JDBCTrayectoDAO;
import data.JDBCViajeDAO;

public class AccionConductorImpl implements IAccionConductor{

    private IViajeDAO vdao = new JDBCViajeDAO();
    private ITrayectoDAO tdao = new JDBCTrayectoDAO();
	
	private Conductor cond;
	private List<Trayecto> trayecto;
	
	public AccionConductorImpl(Conductor c, List<Trayecto> t){
		this.setCond(c);
		this.trayecto = t;
	}
	

	private void setCond(Conductor c) {
		this.cond=c;
		
	}


	@Override
	public Trayecto consultaTrayecto(Trayecto trayecto) {
		return tdao.selectTrayectoOID(trayecto);
	}

	@Override
	public boolean eliminaTrayecto(Trayecto tra) {
        tdao.deleteTrayectoOID(tra.getIdTrayecto());
        return true;
		
	}

	@Override
	public void insertarTrayecto(Trayecto tra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trayecto modificaTrayecto(Trayecto tra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viaje> verViajesAsignados(Viaje viaje) {
		return vdao.selectAllViajes();
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
