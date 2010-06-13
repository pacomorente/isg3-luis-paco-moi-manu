package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import domain.Conductor;
import domain.Pasajero;
import domain.Viaje;

public class JDBCViajeDAO implements IViajeDAO {

	

	public void deleteViaje(Connection con,String ViajeOID) {
		
		String sql = "DELETE FROM viaje WHERE (OIDViaje = ?) ";
        PreparedStatement stmt = null;

        // Buscar si viaje tiene pasajero, para ello hay que meterse en Pasajero y ver si existe
        // al menos un OID VIAJE, pasandole el OID VIAJE al metodo que devolvera boolean 
        
        try {
            stmt = con.prepareStatement(sql);
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
	
	public boolean  eliminaViaje(Connection con, String idViaje){
		String oidviaje= selectViajeOID(con,idViaje);
		boolean noExisteP = bExistePasajeroViaje(con, oidviaje);
		if (noExisteP){
			IConductorDAO cdao = new JDBCConductorDAO();
			Conductor cond= cdao.selectConductorbyViaje(oidviaje);
			cdao.delete(cond.getNick(), oidviaje);
			deleteViaje(con,oidviaje);
			String oidc = cdao.selectOIDConductor(cond.getNick());
			cdao.actualizarPuntosConductor(oidc,"BAJA",cond.getEstrella());
			return true;
		}else
			return false;
		
	}
	
	public boolean existePasajerosViaje(Connection con, String idViaje){
		String oidviaje= selectViajeOID(con,idViaje);
		return bExistePasajeroViaje(con,oidviaje);
		
	}
	
	public boolean bExistePasajeroViaje(Connection con, String oidviaje){
		//String oidviaje= selectViajeOID(con,idViaje);
		IPasajeroDAO pasdao = new JDBCPasajeroDAO();
		List<Pasajero> listaPasajeros=pasdao.selectPasajerosbyViaje(oidviaje);
		if (listaPasajeros==null || listaPasajeros.size()==0){
			return true;
		}else
			return false;	
		
	}
	
	public boolean existeViaje(Connection conn,Viaje v){
		Viaje auxViaje=selectViaje(conn, v.getViajeID());
		if (auxViaje.getOrigen().equals(v.getOrigen())
				&& auxViaje.getDestino().equals(v.getDestino())
				&& auxViaje.getFecha().equals(v.getFecha())
				&& auxViaje.getPuntosInt01().equals(v.getPuntosInt01())
				&& auxViaje.getPuntosInt02().equals(v.getPuntosInt02())
				&& auxViaje.getPuntosInt03().equals(v.getPuntosInt03()))
			return true;
		else
			return false;
	}
	
	public void updateViaje(Connection conn, Viaje v){
        String oidViaje=selectViajeOID(conn, v.getViajeID());
		PreparedStatement stmt = null;
        String sql = "UPDATE viaje SET origen=?,destino=?,puntoint01=?,puntoint02=?,puntoint03=?,fecha=STR_TO_DATE(?,'%d/%m/%Y') WHERE OIDViaje=? ";

        try {
            stmt = conn.prepareStatement(sql);


            stmt.setString(1, v.getOrigen());
            stmt.setString(2, v.getDestino());
            stmt.setString(3, v.getPuntosInt01());
            stmt.setString(4, v.getPuntosInt02());
            stmt.setString(5, v.getPuntosInt03());
            stmt.setString(6, v.getFecha());
            //stmt.setString(7, STR_TO_DATE(v.getFecha(),'%d/%m/%Y'));
            stmt.setString(7, oidViaje);
            stmt.executeUpdate();
           
            
           
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
		
	}

	
	public void insertViaje(Connection con, String viajeOID,Viaje v ) {
		// TODO Auto-generated method stub
		/*
		 * Cuando inserte VIaje hay que comprobar si el usuario 
		 * ya tiene vehiculo dado de alta, 
		 * en caso contrario,
		 * solicitar el alta del vehiculo. ( SE ACCEDE A TABLA VEHICULO )
		 */

	        PreparedStatement stmt = null;
	        String sql = "INSERT INTO viaje( OIDViaje,origen,destino,puntoint01,puntoint02,puntoint03,fecha,idViaje,anulado) VALUES (?, ?, ?, ?, ?, ?, STR_TO_DATE(?,'%d/%m/%Y'),?, ?) ";

	        try {
	            stmt = con.prepareStatement(sql);

	            stmt.setString(1, viajeOID);
	            stmt.setString(2, v.getOrigen());
	            stmt.setString(3, v.getDestino());
	            stmt.setString(4, v.getPuntosInt01());
	            stmt.setString(5, v.getPuntosInt02());
	            stmt.setString(6, v.getPuntosInt03());
	            stmt.setString(7, v.getFecha());
	            //stmt.setString(7, STR_TO_DATE(v.getFecha(),'%d/%m/%Y'));
	            stmt.setString(8, v.getViajeID());
	            stmt.setBoolean(9, false);
	            

	            stmt.executeUpdate();
	           
	        } catch (SQLException e) {
	            System.out.println("Message: " + e.getMessage());
	            System.out.println("SQLState: " + e.getSQLState());
	            System.out.println("ErrorCode: " + e.getErrorCode());
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	            } catch (SQLException e) {
	            }
	        }

	}
	
	public Viaje  cambiaEstadoViaje(Connection con, String idViaje){
        PreparedStatement stmt = null;
        String sql = "UPDATE viaje SET anulado = ? where idViaje= ? ";
        Boolean nuevoEstado=false;
        Viaje v = null;
        Boolean estado=selectEstadoViaje(con, idViaje);
        if (estado==false){
        	nuevoEstado=true;
               		
        }
        	
        try {
            stmt = con.prepareStatement(sql);

            stmt.setBoolean(1, nuevoEstado);
            stmt.setString(2, idViaje);
            stmt.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
        return v;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> selectAllViajes() {
		System.out.println("Abriendo conexion...en Viaje");
		ConnectionManager cn = ConnectionManager.getInstance();
		
		Connection con = cn.checkOut();
		IPasajeroDAO pasDAO = new JDBCPasajeroDAO();
		PreparedStatement stmt = null;
		List searchResults = new LinkedList();
		ResultSet result = null;
		List<String> puntosInt =new ArrayList();
		String sql = "SELECT *, DATE_FORMAT(fecha,'%d/%m/%Y') AS fechaEUR FROM viaje";
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
			   //temp.setFecha(result.getDate("fecha"));
			   temp.setFecha(result.getString("fechaEUR"));
			   temp.setAnulado(result.getBoolean("anulado"));
			   
			   temp.setPasajeros(pasDAO.selectPasajerosbyViaje(result.getString("OIDViaje")));
			   searchResults.add(temp);
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			System.out.println("Cerrando conexion...en Viaje");
			ConnectionManager.getInstance().checkIn(con);
			
		}
		
		return searchResults;
		

	}
//Moi: recuerda lo de los puntos intermedios que te comente.

	public Viaje selectViaje(Connection con,String viajeid) {
		// TODO Auto-generated method stub
		/*
		 *  Al seleccionar el viaje, mostaria el vehiculo de dicho viaje y 
		 *  se busca la existencia de pasajeros, y si los hubiera
		 *  mostraria los datos del usuario pasajero asignado a dicho viaje; 
		 *  SE ACCEDERIA A TABLAS PASAJERO, VIAJE, USUARIO y VEHICULO 
		 */
		
		IPasajeroDAO pasdao = new JDBCPasajeroDAO();
		IConductorDAO cdao = new JDBCConductorDAO();
		Viaje viaje = new Viaje();
		String oidviaje= selectViajeOID(con,viajeid);
		viaje=selectViajeConductor(con, oidviaje);
		
		viaje.setPasajeros(pasdao.selectPasajerosbyViaje(oidviaje));
		//Obtenemos conductor, datos de usuario y también los datos de su vehículo
		viaje.setConductor(cdao.selectConductorbyViaje(oidviaje));
		
		return viaje;
	}
	

	public Viaje selectViajeConductor(Connection con,String oidViajeConductor){
		PreparedStatement stmt = null;
        ResultSet result = null;
        Viaje viajeCond = new Viaje();
		List<String> puntosInt = new ArrayList<String>();
        try {
        	String sql = "SELECT * ,DATE_FORMAT(fecha,'%d/%m/%Y') AS fechaEUR FROM viaje WHERE (OIDViaje = ?) ";
            stmt = con.prepareStatement(sql);
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
            //viajeCond.setFecha(result.getDate("fecha"));
            viajeCond.setFecha(result.getString("fechaEUR"));
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
        
	
	public String selectViajeOID(Connection con,String idViaje){
        PreparedStatement stmt = null;
        ResultSet result = null;
        String oid = null;
        String sql = "SELECT * FROM viaje WHERE (idViaje = ?) ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, idViaje);
            result = stmt.executeQuery();

            result.next();
            oid = result.getString("OIDViaje");
            
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
        return oid;
    }
	
	public Boolean selectEstadoViaje(Connection con,String idViaje){
        PreparedStatement stmt = null;
        ResultSet result = null;
        Boolean estado = null;
        String sql = "SELECT * FROM viaje WHERE (idViaje = ?) ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, idViaje);
            result = stmt.executeQuery();

            result.next();
            estado = result.getBoolean("anulado");
            
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
        return estado;
    }
	
	
	public List<Viaje> selectViajes(Connection con, String oidPasajero) {
		PreparedStatement stmt = null;
        ResultSet result = null;
        List<Viaje> listaViajes = new LinkedList<Viaje>();
        
        try {
        	String sql = "SELECT * FROM pasajero WHERE (OIDPasajero = ?) ";
            stmt = con.prepareStatement(sql);
            //stmt.executeQuery();
            stmt.setString(1, oidPasajero);
            result = stmt.executeQuery();
            
            
            while (result.next()){
            	String oidViaje = result.getString("OIDViaje");
            	Viaje v = selectViajeConductor(con,oidViaje);
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

}
