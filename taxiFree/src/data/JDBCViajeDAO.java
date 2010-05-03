package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import domain.Viaje;

public class JDBCViajeDAO implements IViajeDAO {

	
    private Connection conn;

    /*IUsuarioDAO usudao;

    IVehiculoDAO vehdao;
    
    IPasajeroDAO pasdao;*/



    public JDBCViajeDAO() {
        conn = ConnectionManager.getInstance().checkOut();
/*        usudao = new JDBCUsuarioDAO();
        vehdao = new JDBCVehiculoDAO();
        pasdao = new JDBCPasajeroDAO();*/
        
    }

    protected void finalize() {
        ConnectionManager.getInstance().checkIn(conn);
    }
	
	public void deleteViaje(String ViajeOID) {
		
		String sql = "DELETE FROM viaje WHERE (OID = ?) ";
        PreparedStatement stmt = null;

        // Buscar si viaje tiene pasajero, para ello hay que meterse en Pasajero y ver si existe
        // al menos un OID VIAJE, pasandole el OID VIAJE al metodo que devolvera boolean 
        //  FALTA IMPLEMENTAR AUN
        
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
		 * Cuando inserte VIaje hay que comprobar si el usuario ya tiene vehiculo dado de alta, en caso contrario,
		 * solicitar el alta del vehiculo. ( SE ACCEDE A TABLA VEHICULO )
		 */
	}

	
	@SuppressWarnings("unchecked")
	public List<Viaje> selectAllViajes() {
		
		ConnectionManager cn = ConnectionManager.getInstance();
		
		Connection con = cn.checkOut();
		
		PreparedStatement stmt = null;
		List searchResults = new LinkedList();
		ResultSet result = null;
		List<String> puntosInt =new ArrayList();
		String sql = "SELECT * FROM viaje";
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
			   Viaje temp = new Viaje();
			   temp.setViajeID(result.getString("idViaje"));
			   temp.setOrigen(result.getString("origen"));
			   temp.setDestino(result.getString("destino"));
			   temp.setPuntosInt01(result.getString("puntoint01"));
			   temp.setPuntosInt02(result.getString("puntoint02"));
			   temp.setPuntosInt03(result.getString("puntoint03"));
	           puntosInt.add(temp.getPuntosInt01());
	           puntosInt.add(temp.getPuntosInt02());
	           puntosInt.add(temp.getPuntosInt03());
	           temp.setPuntosIntermedios(puntosInt);
			   
			   temp.setPuntosIntermedios(puntosInt);
			   temp.setFecha(result.getDate("fecha"));
			   temp.setAnulado(result.getBoolean("anulado"));
			   searchResults.add(temp);
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//System.out.println("Cerrando conexion...");
			ConnectionManager.getInstance().checkIn(con);
		}
		
		return searchResults;
		

	}
//Moi: recuerda lo de los puntos intermedios que te comente.

	public Viaje selectViaje(String s) {
		// TODO Auto-generated method stub
		/*
		 *  Al seleccionar el viaje, mostaria el vehiculo de dicho viaje y 
		 *  se busca la existencia de pasajeros, y si los hubiera
		 *  mostraria los datos del usuario pasajero asignado a dicho viaje; 
		 *  SE ACCEDERIA A TABLAS PASAJERO, VIAJE, USUARIO y VEHICULO 
		 */
		return null;
	}

	public Viaje selectViajeConductor(Connection con,String oidViajeConductor){
		PreparedStatement stmt = null;
        ResultSet result = null;
        Viaje viajeCond = new Viaje();
		List<String> puntosInt = new ArrayList<String>();
        try {
        	String sql = "SELECT * FROM viaje WHERE (OIDViaje = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oidViajeConductor);

            result = stmt.executeQuery();

            result.next();
            
            viajeCond.setViajeID(result.getString("idViaje"));
            viajeCond.setOrigen(result.getString("origen"));
            viajeCond.setDestino(result.getString("destino"));
  		    viajeCond.setPuntosInt01(result.getString("puntoint01"));
            viajeCond.setPuntosInt02(result.getString("puntoint02"));
            viajeCond.setPuntosInt03(result.getString("puntoint03"));
            puntosInt.add(viajeCond.getPuntosInt01());
            puntosInt.add(viajeCond.getPuntosInt02());
            puntosInt.add(viajeCond.getPuntosInt03());
            viajeCond.setPuntosIntermedios(puntosInt);
            viajeCond.setFecha(result.getDate("fecha"));
			viajeCond.setAnulado(result.getBoolean("anulado"));
			
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
        
        return viajeCond;
	}
        


	
	public Viaje select(String viajeOID) {
		// Yo Moi te aconsejo que lo pongas para separa el OID de los datos.
		return null;
	}
	
	public String selectViajeOID(String idViaje){
		//Yo Moi te aconsejo que separes los OID de los id
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
