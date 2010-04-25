package data;

import java.util.List;

import domain.Trayecto;



/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public interface ITrayectoDAO {
	public List<Trayecto> selectAllTrayectos();
	public Trayecto selectTrayectoOID(Trayecto trayecto);
	public void insertTrayectoOID(Trayecto trayecto,String userOID );
	public void deleteTrayectoOID(String viajeOID);
	public void updateTrayectoOID(Trayecto trayecto, String userOID);
	
}
