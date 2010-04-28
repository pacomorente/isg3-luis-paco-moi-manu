package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
        // al menos un OID VIAJE, pasándole el OID VIAJE al método que devolverá boolean 
        //  FALTA IMPLEMENTAR AÚN
        
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
		 * Cuando inserte VIaje hay que comprobar si el usuario ya tiene vehículo dado de alta, en caso contrario,
		 * solicitar el alta del vehículo. ( SE ACCEDE A TABLA VEHICULO )
		 */
	}

	
	public List<Viaje> selectAllViajes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Viaje selectViaje(String s) {
		// TODO Auto-generated method stub
		/*
		 *  Al seleccionar el viaje, mostaría el vehículo de dicho viaje y 
		 *  se busca la existencia de pasajeros, y si los hubiera
		 *  mostraría los datos del usuario pasajero asignado a dicho viaje; 
		 *  SE ACCEDERÍA A TABLAS PASAJERO, VIAJE, USUARIO y VEHICULO 
		 */
		return null;
	}
	
	public Viaje select(String oidViaje) {
		// Yo Moi te aconsejo que lo pongas para separa el OID de los datos.
		return null;
	}
	
	public List<Viaje> selectViajes(Connection con, String oidPasajero) {
		PreparedStatement stmt = null;
        ResultSet result = null;
        List<Viaje> listaViajes = new LinkedList<Viaje>();
        
        try {
        	String sql = "SELECT * FROM pasajero WHERE (OIDPasajero = ?) ";
            stmt = con.prepareStatement(sql);
            stmt.executeQuery();
            result = stmt.executeQuery();
            stmt.setString(1, oidPasajero);
            
            while (result.next()){
            	String oidViaje = result.getString("OIDViaje");
            	Viaje v = select(oidViaje);
            	listaViajes.add(v);
            }
        }catch (SQLException e) {
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
        
        return listaViajes;
	}

/*	
	public void updateViaje(Viaje v, String userOID) {
		// TODO Auto-generated method stub
		
	}*/

}
