package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import utils.UIDGenerator;
import domain.Ruta;

public class JDBCRutaDAO implements IRutaDAO {

	
	private Connection conn;
	
	public JDBCRutaDAO(){
		conn = ConnectionManager.getInstance().checkOut();
	}
	
	public void deleteRuta(String idRuta) {
		// TODO Auto-generated method stub

	}


	public void insert(Connection con, Ruta r) {
		String sql = "INSERT INTO RUTA(OIDRuta, origen, desplazamiento, fecha, idRuta, destino)values('?','?','?',?,'?','?')";
        PreparedStatement stmt = null;
        String rutaOID = UIDGenerator.getInstance().getKey();
        
        try{
        	
        	stmt = con.prepareStatement(sql);
            stmt.setString(1, rutaOID);
            stmt.setString(2, r.getOrigen());
            stmt.setString(3, r.getDesplazamiento().toString());
            stmt.setString(4, "STR_TO_DATE("+r.getFecha()+",'%d/%m/%Y')");
            stmt.setString(5, r.getIdRuta());
            stmt.setString(6, r.getDestino());
            stmt.executeUpdate();
        	
        }catch (SQLException e) {
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

	public List<Ruta> selectAllRutas() {
		PreparedStatement stmt = null;
        ResultSet result = null;
        List<Ruta> listaRutas = new LinkedList<Ruta>();
        
        try {
        	String sql = "SELECT * FROM ruta ";
            stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
            result = stmt.executeQuery();
            
            while (result.next()){
            	Ruta r = new Ruta();
            	r.setIdRuta(result.getString("idRuta"));
            	r.setOrigen(result.getString("origen"));
            	r.setDestino(result.getString("destino"));
            	r.setDesplazamiento(Integer.parseInt(result.getString("desplazamiento")));
            	r.setFecha(Date.valueOf(result.getString("fecha")));
            	listaRutas.add(r);
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
        
        return listaRutas;
	}
	
	public String selectRutaOID(String idRuta) {
		PreparedStatement stmt = null;
        ResultSet result = null;
        String oidr = null;
        String sql = "SELECT * FROM ruta WHERE (idRuta = ?) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idRuta);
            result = stmt.executeQuery();

            result.next();
            oidr = result.getString("OIDRuta");
            
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
        return oidr;
    }
	
	public Ruta select(String rutaOID){
		PreparedStatement stmt = null;
        ResultSet result = null;
        Ruta r = null;
        String sql = "SELECT * FROM ruta WHERE (OIDRuta = ?) ";
        
        try{
        	stmt = conn.prepareStatement(sql);
        	result = stmt.executeQuery(sql);
        	stmt.setString(1, rutaOID);
        	result.next();
        	
        	r = new Ruta();
        	r.setIdRuta(result.getString("idRuta"));
        	r.setOrigen(result.getString("origen"));
        	r.setDestino(result.getString("destino"));
        	r.setDesplazamiento(Integer.parseInt(result.getString("desplazamiento")));
        	r.setFecha(Date.valueOf(result.getString("fecha")));
        	
        }catch(SQLException e){
        	System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        }finally {
            try{
            	if (result != null) {
            		result.close();
                }
            	if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
        return r;
	}
	
	public List<Ruta> selectRutas(Connection con, String oidPasajero) {
		PreparedStatement stmt = null;
        ResultSet result = null;
        List<Ruta> listaRutas = new LinkedList<Ruta>();
        
        try {
        	String sql = "SELECT * FROM pasajero_ruta WHERE (OIDPasajero = ?) ";
            stmt = con.prepareStatement(sql);
            stmt.executeQuery();
            result = stmt.executeQuery();
            stmt.setString(1, oidPasajero);
            
            while (result.next()){
            	String oidRuta = result.getString("OIDRuta");
            	Ruta r = select(oidRuta);
            	listaRutas.add(r);
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
        
        return listaRutas;
	}

	public void updateRuta(Ruta r, String userOID) {
		// TODO Auto-generated method stub

	}
}
