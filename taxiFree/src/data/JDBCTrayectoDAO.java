package data;

import java.util.List;
import java.sql.Connection;

import domain.Trayecto;

/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public class JDBCTrayectoDAO implements ITrayectoDAO{

	IViajeDAO vdao;
    
	public JDBCTrayectoDAO() {
		vdao = new JDBCViajeDAO();
    }
	
	@Override
	public void deleteTrayectoOID(Connection conn, String viajeOID) {
		// TODO Auto-generated method stub
		/* comprobar si existen viajes con pasajeros, o bien se podría
		 * poner el viaje como dado de baja 
		 * AÑADIR CAMPO EN LA TABLA VIAJE: Baja:boolean
		 */
		//if ( ! vdao.existePasajeroViaje(conn, t.getOrigenTrayecto(),t.getDestinoTrayecto(), viajeOID)){
			vdao.deleteViaje(conn,viajeOID);
		//}else{
			//lanzar mensaje de no borrar o PONER VIAJE A "BAJA"
		//}
		
		
		
	}

	@Override
	public void insertTrayectoOID(Trayecto trayecto, String userOID) {
		// TODO Auto-generated method stub
		/*
		 * añadir trayecto en la tabla VIAJE
		 */
		
	}

	@Override
	public List<Trayecto> selectAllTrayectos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trayecto selectTrayectoOID(Trayecto trayecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTrayectoOID(Trayecto trayecto, String userOID) {
		// TODO Auto-generated method stub
		/*
		 * añadir trayecto en la tabla VIAJE
		 */
	}

}
