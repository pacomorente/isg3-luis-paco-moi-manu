package data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Pasajero;
import domain.Ruta;
import domain.Usuario;
import domain.Viaje;

/**
 * @author    morentefj
 */
public class JDBCPasajeroDAO implements IPasajeroDAO {

	/**
	 * @uml.property  name="udao"
	 * @uml.associationEnd  
	 */
	
	private Connection conn;
	/**
	 * @uml.property  name="udao"
	 * @uml.associationEnd  
	 */
	private IUsuarioDAO udao;
	/**
	 * @uml.property  name="rdao"
	 * @uml.associationEnd  
	 */
	private IRutaDAO rdao;
	
	private IViajeDAO vdao;
	
	public JDBCPasajeroDAO(){
		conn = ConnectionManager.getInstance().checkOut();
		udao = new JDBCUsuarioDAO();
		rdao = new JDBCRutaDAO();
		vdao = new JDBCViajeDAO();
	}
	
	public Pasajero selectPasajero(String nick) {
		String pas = udao.selectUsuarioOID(conn, nick);
		return this.selectPasajeroPorOID(pas);
	}

	public List<Pasajero> selectAllPasajeros() {
		PreparedStatement stmt = null;
		List<Pasajero> listaPasajeros = new LinkedList<Pasajero>();
		List<Viaje> listaViajes = new LinkedList<Viaje>();
		List<Ruta> listaRutas = new LinkedList<Ruta>();
		ResultSet result = null;
		
		try {
			String sql = "SELECT * FROM pasajero ";
			stmt = conn.prepareStatement(sql);
			stmt.executeQuery();
			result = stmt.executeQuery();
			
			while (result.next()) {
				Pasajero p = new Pasajero();
				
				String oidPasajero = result.getString("OIDPasajero");
	            
	            Usuario u = udao.select(conn, oidPasajero);
	            listaViajes = vdao.selectViajes(conn, oidPasajero);
	            listaRutas = rdao.selectRutas(conn, oidPasajero);
	            
	            p.setNombre(u.getNombre());	
	            p.setApellidos(u.getApellidos());
	            p.setCorreo(u.getCorreo());	
	            p.setDni(u.getDni());	
	            p.setNick(u.getNick());	
	            p.setApellidos(u.getPass());	
	            p.setEstrella(u.getEstrella());
	            p.setViaje(listaViajes);
	            p.setRutas(listaRutas);
	            
	            listaPasajeros.add(p);
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
		}finally{
			ConnectionManager.getInstance().checkIn(conn);
            try {
                if (result != null)
                    result.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
		}
		return listaPasajeros;
	}

	public Pasajero selectPasajeroPorOID(String pasajeroOID) {
		Pasajero p = new Pasajero();
		List<Viaje> listaViajes = new LinkedList<Viaje>();
		List<Ruta> listaRutas = new LinkedList<Ruta>();
		Usuario u = udao.select(conn, pasajeroOID);
        listaViajes = vdao.selectViajes(conn, pasajeroOID);
        listaRutas = rdao.selectRutas(conn, pasajeroOID);
        
        p.setNombre(u.getNombre());	
        p.setApellidos(u.getApellidos());
        p.setCorreo(u.getCorreo());	
        p.setDni(u.getDni());	
        p.setNick(u.getNick());	
        p.setApellidos(u.getPass());	
        p.setEstrella(u.getEstrella());
        p.setViaje(listaViajes);
        p.setRutas(listaRutas);
        
        return p;
	}
	
	public List<Pasajero> selectPasajerosbyViaje(String oidviaje){
			
		List<Pasajero> listaPasajeros = new LinkedList<Pasajero>();
		PreparedStatement stmt = null;
        ResultSet result = null;
              
        try {
        	String sql = "SELECT * FROM pasajero WHERE (OIDViaje = ?) ";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, oidviaje);
            result = stmt.executeQuery();
            
            while (result.next()){
            	String oidPasajero = result.getString("OIDPasajero");
            	Pasajero p = selectPasajeroPorOID(oidPasajero);
            	listaPasajeros.add(p);
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
        
		return listaPasajeros;
		
	}
	
	public Pasajero selectPasajeroEnRuta(String rutaOID){
		ResultSet result = null;
		Pasajero pasajero = new Pasajero();
		PreparedStatement stmt = null;
		try {
        	String sql = "SELECT * FROM pasajero_ruta WHERE (OIDRuta = ?) ";
        	stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, rutaOID);
            result = stmt.executeQuery();
            result.next();
            String oidPasajero = result.getString("OIDPasajero");
            Usuario u = udao.select(conn, oidPasajero);
            
            pasajero.setNombre(u.getNombre());	
            pasajero.setApellidos(u.getApellidos());
            pasajero.setCorreo(u.getCorreo());	
            pasajero.setDni(u.getDni());	
            pasajero.setNick(u.getNick());	
            pasajero.setApellidos(u.getPass());	
            pasajero.setEstrella(u.getEstrella());
            
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
        return pasajero;
	}
	
	public String selectPasajeroOIDEnRuta(String rutaOID){
		ResultSet result = null;
		String oidPasajero = "";
		PreparedStatement stmt = null;
		try {
        	String sql = "SELECT * FROM pasajero_ruta WHERE (OIDRuta = ?) ";
        	stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, rutaOID);
            result = stmt.executeQuery();
            result.next();
            oidPasajero = result.getString("OIDPasajero");
            
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
        return oidPasajero;
	}
	
	public void insert(Pasajero p, Ruta r, Viaje v){
		String sql2 = "INSERT INTO pasajero_ruta(OIDPasajero,OIDRuta)values(?,?)";
		String sql1 = "INSERT INTO pasajero(OIDPasajero,OIDViaje)values(?,?)";
        PreparedStatement stmt = null;

        try {
        	
        	rdao.insert(conn, r);
        	
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, udao.selectUsuarioOID(conn, p.getNick()));
            stmt.setString(2, vdao.selectViajeOID(conn,v.getViajeID()));
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, udao.selectUsuarioOID(conn, p.getNick()));
            stmt.setString(2, rdao.selectRutaOID(r.getIdRuta()));
            stmt.executeUpdate();
            
            udao.actualizarPuntosConductor(conn, udao.selectUsuarioOID(conn, p.getNick()), "BAJA", p.getEstrella());
            
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
	
	public Viaje selectViajeDePasajero(String idViaje){
		return vdao.selectViaje(conn, idViaje);
	}
	
	public void eliminaPasajero(Viaje v, Pasajero p){
		String sql = "DELETE FROM pasajero WHERE (OIDViaje = ?) AND (OIDPasajero = ?) ";
		String pasajeroOID = udao.selectUsuarioOID(conn, p.getNick());
        PreparedStatement stmt = null;
        String viajeOID = vdao.selectViajeOID(conn, v.getViajeID());
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, viajeOID);
            stmt.setString(2, pasajeroOID);
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
	
	public void eliminaPasajeroEnRuta(String rutaOID, Pasajero p){
		String pasajeroOID = udao.selectUsuarioOID(conn, p.getNick());
		String sql = "DELETE FROM pasajero_ruta WHERE (OIDRuta = ?) AND (OIDPasajero = ?)";
		
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, pasajeroOID);
            stmt.setString(1, rutaOID);
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
	
	public void actualizaViajeDePasajero(String vidAnt, String vidNuevo, String idRuta){
		String rutaOID = rdao.selectRutaOID(idRuta);
		String pasajeroOID = selectPasajeroOIDEnRuta(rutaOID);
		String vAntOID = vdao.selectViajeOID(conn, vidAnt);
		String vNuevoOID = vdao.selectViajeOID(conn, vidNuevo);
		PreparedStatement stmt = null;
		String sql = "UPDATE pasajero SET OIDViaje=? WHERE OIDViaje=? AND OIDPasajero=?";
		
		try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, vNuevoOID);
            stmt.setString(2, vAntOID);
            stmt.setString(3, pasajeroOID);
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

}
