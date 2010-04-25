package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.Trayecto;

/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public class JDBCTrayectoDAO implements ITrayectoDAO{
	private Connection conn;
	IViajeDAO vdao;
    
	public JDBCTrayectoDAO() {
		conn = ConnectionManager.getInstance().checkOut();
		vdao = new JDBCViajeDAO();
    }
	
	

    protected void finalize() {
        ConnectionManager.getInstance().checkIn(conn);
    }
	
    public void deleteTrayectoOID(String idTrayecto) {
		// TODO Auto-generated method stub
		/* comprobar si existen viajes con pasajeros, o bien se podría
		 * poner el viaje como dado de baja 
		 * AÑADIR CAMPO EN LA TABLA VIAJE: Baja:boolean
		 */
		//if ( ! vdao.existePasajeroViaje(conn, t.getOrigenTrayecto(),t.getDestinoTrayecto(), viajeOID)){
			//vdao.deleteViaje(conn,viajeOID);
		//}else{
			//lanzar mensaje de no borrar o PONER VIAJE A "BAJA"
		//}
        String sql = "DELETE FROM Trayecto WHERE (orderid = ?) ";
        PreparedStatement stmt = null;

        String TrayectoOID = selectOIDOfTrayecto(idTrayecto);

        if (TrayectoOID!=null) {
        
        
        
        vdao.deleteViaje(conn, TrayectoOID);


        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idTrayecto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
        }
        }	
		
		
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

	
    private String selectOIDOfTrayecto(String trayectoID) {
        PreparedStatement stmt = null;
        ResultSet result = null;
        String oidTrayecto = null;
        String sql = "SELECT * FROM Trayecto WHERE (orderid = ?) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, trayectoID);
            result = stmt.executeQuery();

            if (result.next()) {
                oidTrayecto = result.getString("OIDTrayecto");
            }
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
        return oidTrayecto;
    }

}
