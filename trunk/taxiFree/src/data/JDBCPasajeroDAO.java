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
 * @author   morentefj
 */
public class JDBCPasajeroDAO implements IPasajeroDAO {

	/**
	 * @uml.property  name="udao"
	 * @uml.associationEnd  
	 */
	
	private Connection conn;
	private IUsuarioDAO udao;
	private IViajeDAO vdao;
	private IRutaDAO rdao;
	
	public JDBCPasajeroDAO(){
		conn = ConnectionManager.getInstance().checkOut();
		udao = new JDBCUsuarioDAO();
		vdao = new JDBCViajeDAO();
		rdao = new JDBCRutaDAO();
	}
	
	public String selectPasajeroOID(String nick) {
		return udao.selectUsuarioOID(conn, nick);
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

	public Pasajero selectPasajero(String pasajeroOID) {
		
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

}
