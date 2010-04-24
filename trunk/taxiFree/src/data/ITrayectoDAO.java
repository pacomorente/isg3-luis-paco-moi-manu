package data;

import java.sql.Connection;
import java.util.List;

import domain.Trayecto;



public interface ITrayectoDAO {
	public List<Trayecto> selectAllTrayectos();
	public Trayecto selectTrayectoOID(Trayecto trayecto);
	public void insertTrayectoOID(Trayecto trayecto,String userOID );
	public void deleteTrayectoOID(Connection conn,String viajeOID);
	public void updateTrayectoOID(Trayecto trayecto, String userOID);
	
}
