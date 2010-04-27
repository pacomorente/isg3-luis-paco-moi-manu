package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.Viaje;

public class JDBCViajeDAO implements IViajeDAO {

	
    private Connection conn;

    IUsuarioDAO usudao;

    IVehiculoDAO vehdao;
    
    IPasajeroDAO pasdao;



    public JDBCViajeDAO() {
        conn = ConnectionManager.getInstance().checkOut();
        usudao = new JDBCUsuarioDAO();
        vehdao = new JDBCVehiculoDAO();
        pasdao = new JDBCPasajeroDAO();
        
    }

    protected void finalize() {
        ConnectionManager.getInstance().checkIn(conn);
    }
	
	public void deleteViaje(String ViajeOID) {
		
		String sql = "DELETE FROM Viaje WHERE (OID = ?) ";
        PreparedStatement stmt = null;

        // Buscar si viaje tiene pasajero, para ello hay que meterse en Pasajero y ver si existe
        // al menos un OID VIAJE, pas�ndole el OID VIAJE al m�todo que devolver� boolean 
        //  FALTA IMPLEMENTAR A�N
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ViajeOID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
        }
	    

	}

	
	public void insertViaje(Viaje v ) {
		// TODO Auto-generated method stub
		/*
		 * Cuando inserte VIaje hay que comprobar si el usuario ya tiene veh�culo dado de alta, en caso contrario,
		 * solicitar el alta del veh�culo. ( SE ACCEDE A TABLA VEHICULO )
		 */
	}

	
	public List<Viaje> selectAllViajes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Viaje selectViaje(String s) {
		// TODO Auto-generated method stub
		/*
		 *  Al seleccionar el viaje, mostar�a el veh�culo de dicho viaje y 
		 *  se busca la existencia de pasajeros, y si los hubiera
		 *  mostrar�a los datos del usuario pasajero asignado a dicho viaje; 
		 *  SE ACCEDER�A A TABLAS PASAJERO, VIAJE, USUARIO y VEHICULO 
		 */
		return null;
	}

/*	
	public void updateViaje(Viaje v, String userOID) {
		// TODO Auto-generated method stub
		
	}*/

}
