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
	
	public JDBCPasajeroDAO(){
		conn = ConnectionManager.getInstance().checkOut();
		udao = new JDBCUsuarioDAO();
		rdao = new JDBCRutaDAO();
	}
	
	public Pasajero selectPasajero(String nick) {
		String pas = udao.selectUsuarioOID(conn, nick);
		return this.selectPasajeroPorOID(pas);
	}

	public List<Pasajero> selectAllPasajeros() {
		IViajeDAO vdao = new JDBCViajeDAO();
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
		IViajeDAO vdao = new JDBCViajeDAO();
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
	
	public void insert(Pasajero p, Ruta r, Viaje v){
		IViajeDAO vdao = new JDBCViajeDAO();
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
            
            udao.actualizarPuntosConductor(conn, udao.selectUsuarioOID(conn, p.getNick()), "BAJA", 1);
            
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
		IViajeDAO iv = new JDBCViajeDAO();
		return iv.selectViaje(conn, idViaje);
	}

}
