package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Usuario;

/**
 * @uml.dependency   supplier="data.IUsuarioDAO"
 */
public class JDBCUsuarioDAO implements IUsuarioDAO{
       



		public Usuario select(Connection conn, String usuarioOID) {
			PreparedStatement stmt = null;
	        ResultSet result = null;
	        Usuario user = null;
	        String sql = "SELECT * FROM usuario WHERE (OID = ?) ";
	        
	        try{
	        	stmt = conn.prepareStatement(sql);
	        	result = stmt.executeQuery(sql);
	        	stmt.setString(1, usuarioOID);
	        	result.next();
	        	
	        	user = new Usuario();
                user.setNick(result.getString("nick"));
                user.setPass(result.getString("pass"));
                user.setDni(result.getString("dni"));
                user.setCorreo(result.getString("correo"));
                user.setNombre(result.getString("nombre"));
                user.setEstrella(Integer.parseInt(result.getString("estrella")));
                user.setApellidos(result.getString("apellidos"));
                
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
	        return user;
		}


		public List<Usuario> selectAllUsuarios() {
			Connection conn = ConnectionManager.getInstance().checkOut();
            PreparedStatement stmt = null;
            ResultSet result = null;
            List<Usuario> listaUsuarios = new LinkedList<Usuario>();
            
            try {
            	String sql = "SELECT * FROM usuario ";
                stmt = conn.prepareStatement(sql);
                stmt.executeQuery();
                result = stmt.executeQuery();
                
                while (result.next()) {
                    Usuario user = new Usuario();
                    user.setNick(result.getString("nick"));
                    user.setPass(result.getString("pass"));
                    user.setDni(result.getString("dni"));
                    user.setCorreo(result.getString("correo"));
                    user.setNombre(result.getString("nombre"));
                    user.setEstrella(Integer.parseInt(result.getString("estrella")));
                    user.setApellidos(result.getString("apellidos"));
                    listaUsuarios.add(user);
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
            return listaUsuarios;
		}
		
		public String selectUsuarioOID(Connection conn, String nick) {
	        PreparedStatement stmt = null;
	        ResultSet result = null;
	        String oidp = null;
	        String sql = "SELECT * FROM Usuario WHERE (nick = ?) ";

	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, nick);
	            result = stmt.executeQuery();

	            result.next();
	            oidp = result.getString("OIDUsuario");
	            
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
	        return oidp;
	    }
}

