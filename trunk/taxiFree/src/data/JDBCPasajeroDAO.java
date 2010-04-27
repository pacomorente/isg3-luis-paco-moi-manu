package data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Pasajero;
import domain.Usuario;

/**
 * @author   morentefj
 */
public class JDBCPasajeroDAO implements IPasajeroDAO {

	private Connection con;
	/**
	 * @uml.property  name="udao"
	 * @uml.associationEnd  
	 */
	private IUsuarioDAO udao;
	
	public JDBCPasajeroDAO(){
		con = ConnectionManager.getInstance().checkOut();
		udao = new JDBCUsuarioDAO();
	}
	
	
	public Pasajero selectPasajero(Connection conn, String pasajeroOID) {
		PreparedStatement stmt = null;
        ResultSet result = null;
        Pasajero p = null;
        String sql = "SELECT * FROM pasajero p WHERE (OID = ?) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pasajeroOID);
            result = stmt.executeQuery();

            result.next();
            
            p = new Pasajero();
			//String oidPasajero = result.getString("OIDPasajero");
            String oidUsuario = result.getString("OIDUsuario");
			//String oidViaje = result.getString("OIDViaje");
            
            Usuario u = udao.select(con, oidUsuario);
            p.setNombre(u.getNombre());	
            p.setApellidos(u.getApellidos());
            p.setCorreo(u.getCorreo());	
            p.setDni(u.getDni());	
            p.setNick(u.getNick());	
            p.setApellidos(u.getPass());	
            p.setEstrella(u.getEstrella());
            
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
        return p;
	}

	public List<Pasajero> selectAllPasajeros() {
		
		PreparedStatement stmt = null;
		List<Pasajero> searchResults = new LinkedList<Pasajero>();
		ResultSet result = null;
		
		String sql = "SELECT * FROM pasajero ";
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				Pasajero p = new Pasajero();
				//String oidPasajero = result.getString("OIDPasajero");
	            String oidUsuario = result.getString("OIDUsuario");
				//String oidViaje = result.getString("OIDViaje");
	            
	            Usuario u = udao.select(con, oidUsuario);
	            p.setNombre(u.getNombre());	
	            p.setApellidos(u.getApellidos());
	            p.setCorreo(u.getCorreo());	
	            p.setDni(u.getDni());	
	            p.setNick(u.getNick());	
	            p.setApellidos(u.getPass());	
	            p.setEstrella(u.getEstrella());
	            
	            searchResults.add(p);
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
		}finally{
			ConnectionManager.getInstance().checkIn(con);
            try {
                if (result != null)
                    result.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
		}
		return searchResults;
	}

}
