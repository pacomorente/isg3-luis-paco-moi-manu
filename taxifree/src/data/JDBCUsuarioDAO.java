package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import utils.UIDGenerator;

import domain.Conductor;
import domain.Usuario;

/**
 * @uml.dependency  supplier="data.IUsuarioDAO"
 */
public class JDBCUsuarioDAO implements IUsuarioDAO{
	
		public JDBCUsuarioDAO(){
			
		}
       
		public Usuario select(Connection conn, String usuarioOID) {
     
			PreparedStatement stmt = null;
	        ResultSet result = null;
	        Usuario user = null;
	        String sql = "SELECT * FROM usuario WHERE (OIDUsuario = ?) ";
	        
	        try{
	        	stmt = conn.prepareStatement(sql);
	        	stmt.setString(1, usuarioOID);
	        	result = stmt.executeQuery();
	        	
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
		
		public int verPuntosUsuario (Connection conn, String oidc){
			PreparedStatement stmt = null;
	        ResultSet result = null;
	        int puntos=0;
	        
	        String sql = "SELECT estrella FROM usuario WHERE (OIDUsuario = ?) ";
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, oidc);
	            result = stmt.executeQuery();

	            result.next();
	            puntos = result.getInt("estrella");
	            
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
	        return puntos;
			
			
		}
		
		public String selectUsuarioOID(Connection conn, String nick) {
	        PreparedStatement stmt = null;
	        ResultSet result = null;
	        String oid = null;
	        String sql = "SELECT * FROM usuario WHERE (nick = ?) ";

	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, nick);
	            result = stmt.executeQuery();

	            result.next();
	            oid = result.getString("OIDUsuario");
	            
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
		
		public Conductor selectUsuariobyNick(Connection conn, String nick) {
	        PreparedStatement stmt = null;
	        ResultSet result = null;
	        String oid = null;
	        String sql = "SELECT * FROM usuario WHERE (nick = ?) ";
	        Conductor user = new Conductor();
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, nick);
	            result = stmt.executeQuery();

	            result.next();
	            oid = result.getString("OIDUsuario");
	           // user= select(conn, oid);
	                       
                user.setNick(result.getString("nick"));
                user.setPass(result.getString("pass"));
                user.setDni(result.getString("dni"));
                user.setCorreo(result.getString("correo"));
                user.setNombre(result.getString("nombre"));
                user.setEstrella(Integer.parseInt(result.getString("estrella")));
                user.setApellidos(result.getString("apellidos"));
                user.setIdConductor(oid);
               
	            
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
	        return  user;
	    }		
		
		public void actualizarPuntosConductor(Connection con,String oidc, String tipo, int estrellas){
			String sql = "UPDATE usuario SET estrella=? where OIDUsuario=? ";
			PreparedStatement stmt = null;
			try{
				stmt = con.prepareStatement(sql);
			
			
				if (tipo.equals("ALTA")) {
	            stmt.setInt(1, estrellas+1);
	            stmt.setString(2, oidc);
				}else{ //baja
					if (estrellas>0){
						stmt.setInt(1, estrellas-1);
					}else{
							stmt.setInt(1, estrellas);
					}
		            stmt.setString(2, oidc);
				}
				stmt.executeUpdate();
				System.out.println(stmt);
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
		
		public void insert(Connection con, Usuario u){
			String sql = "INSERT INTO usuario(OIDUsuario, nombre, apellidos, dni, correo, estrella, nick, pass)values('?','?','?','?','?','?','?','?')";
			PreparedStatement stmt = null;
			String usuarioOID = UIDGenerator.getInstance().getKey();
			
			try{
				
				stmt = con.prepareStatement(sql);
	            stmt.setString(1, usuarioOID);
	            stmt.setString(2, u.getNombre());
	            stmt.setString(3, u.getApellidos());
	            stmt.setString(4, u.getDni());
	            stmt.setString(5, u.getCorreo());
	            stmt.setString(6, String.valueOf(u.getEstrella()));
	            stmt.setString(7, u.getNick());
	            stmt.setString(8, u.getPass());
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


}

