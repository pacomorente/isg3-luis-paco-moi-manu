package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.UIDGenerator;
import domain.Conductor;
import domain.Usuario;
import domain.Vehiculo;
import domain.Viaje;

/**
 * @author    morentefj
 */
public class JDBCConductorDAO implements IConductorDAO {

	   private Connection conn;

	    /**
		 * @uml.property  name="udao"
		 * @uml.associationEnd  
		 */
	    IUsuarioDAO udao;
	    /**
		 * @uml.property  name="vdao"
		 * @uml.associationEnd  
		 */
	    IVehiculoDAO vdao;
	    /**
		 * @uml.property  name="viadao"
		 * @uml.associationEnd  
		 */
	    IViajeDAO viadao;

		private String vehiculoRegistrado;

	    public JDBCConductorDAO() {
	    	//System.out.print("Abriendo conexión BD desde Conductor");
	        conn = ConnectionManager.getInstance().checkOut();
	        udao = new JDBCUsuarioDAO();
	        vdao = new JDBCVehiculoDAO();
	        viadao = new JDBCViajeDAO();
	    }

	    protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	        //System.out.print("Finalizando conexión BD desde Conductor");
	    }
	
	public String selectOIDConductor(String nick) {
			return udao.selectUsuarioOID(conn, nick);
	}
	
	public boolean eliminaViajeC(String idViaje){
		return viadao.eliminaViaje(conn, idViaje);
	}
	public void updateViaje(Viaje viaje){
		viadao.updateViaje(conn, viaje);
	}

	public List<Viaje> obtenerViajesOIDConductor(String oidc){
		 	PreparedStatement stmt = null;
	        ResultSet result = null;
	        String sql = "SELECT * FROM conductor WHERE (OIDConductor = ?) ";
	        List<Viaje> searchResults = new ArrayList<Viaje>();
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, oidc);
	            result = stmt.executeQuery();
	            List<String> listaoids=new ArrayList<String>();
	            //result.next();
	            while (result.next()) {
	            	
	           
					   String oidViajeC =(result.getString("OIDViaje"));
					   listaoids.add(oidViajeC);
					}
				for (String auxOIDCond: listaoids){
					
					 Viaje viajeCond = selectViajeConductor(auxOIDCond);
					 searchResults.add(viajeCond);
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
	        return searchResults;
	    
	}
	
	public Viaje selectViajeConductor(String oidviaje){
		return (Viaje) viadao.selectViajeConductor(conn,oidviaje);

	}
	
	public boolean existeViaje(Viaje viaje){
		return viadao.existeViaje(conn,viaje);
		
	}
	
	public int obtenerPuntos (String nick){
		String oidc= udao.selectUsuarioOID(conn, nick);
		int puntos = udao.verPuntosUsuario(conn,oidc);
		return puntos;
	}
	
	
	public Conductor selectConductorbyViaje(String oidviaje){
		PreparedStatement stmt = null;
        ResultSet result = null;
        String sql = "SELECT * FROM conductor WHERE (OIDViaje = ?) ";
        String oidCond = null;
        String nickCond= null;
        Conductor cond= new Conductor();
        List<Viaje>listaViajesC=new LinkedList<Viaje>();
        try {
        	
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oidviaje);
            result = stmt.executeQuery();

            result.next();
            
            oidCond=(result.getString("OIDConductor"));
            Usuario user= udao.select(conn, oidCond);
            nickCond= user.getNick();
            
            listaViajesC = obtenerViajesOIDConductor(oidCond);
/*    		for (String auxvOID: listaViajes){
    			
   			 Viaje viajeCond = selectViajeConductor(auxvOID);
   			 listaViajesC.add(viajeCond);

    			}*/
    		//String oidc = selectOIDConductor(nick);
    		String oidVehiculoConductor = obtenerVehiculoOID(nickCond);
    		Vehiculo v=vdao.selectVehiculoConductor(conn,oidVehiculoConductor);
            
    	    //Vehiculo v = vdao.selectVehiculoConductor(conn, oidCond);
            
            Usuario u = udao.select(conn, oidCond);
            cond.setApellidos(u.getApellidos());
            cond.setNombre(u.getNombre());
            cond.setCorreo(u.getCorreo());
            cond.setDni(u.getDni());
            cond.setEstrella(u.getEstrella());
            cond.setNick(u.getNick());
            cond.setPass(u.getPass());
            cond.setVehiculo(v);
            cond.setViaje(listaViajesC);

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
        return cond;
	}
	
	public Conductor selectConductorDeViaje(String viajeID){
		String oidViaje = viadao.selectViajeOID(conn, viajeID);
		return selectConductorbyViaje(oidViaje);
	}
	
	public Viaje selectViaje(String idViaje){
		return (Viaje) viadao.selectViaje(conn,idViaje);
	}
	
	public boolean existePasajerosViaje(String idViaje){
		return viadao.existePasajerosViaje(conn, idViaje);
	}
	
	public List<Conductor> sellectAllConductores() {
	        //Connection conn = ConnectionManager.getInstance().checkOut();
	        PreparedStatement stmt = null;
	        ResultSet result = null;
	        List<Conductor> listaConductores = new LinkedList <Conductor>();
	        String sql = "SELECT * FROM conductor ";
	        try {
	                stmt = conn.prepareStatement(sql);
	                result = stmt.executeQuery();
	                while (result.next()) {
	                        Conductor cond = new Conductor();
	                        @SuppressWarnings("unused")
							String oidConductor = result.getString("OIDConductor");
	                        @SuppressWarnings("unused")
							String oidviaje = result.getString("OIDViaje");
	                        String oidvehiculo = result.getString("OIDVehiculo");
	                        String oidusuario = result.getString("OIDUsuario");
	                        cond.setIdConductor(result.getString("OIDConductor"));

	                        //Coge Datos de Usuario -Conductor
	                       
	                        Usuario usu=(udao.select(conn, oidusuario));
	                        cond.setNombre(usu.getNombre());	
	                        cond.setApellidos(usu.getApellidos());
	                        cond.setCorreo(usu.getCorreo());	
	                        cond.setDni(usu.getDni());	
	                        cond.setNick(usu.getNick());	
	                        cond.setApellidos(usu.getPass());	
	                        cond.setEstrella(usu.getEstrella());
	                        
	                        //Coge Datos de Vehiculo -Conductor
	                        Vehiculo veh = (vdao.select(conn, oidvehiculo));
	                        cond.setVehiculo(veh);
	                        
	                        
	                        listaConductores.add(cond);
	                }
	        } catch (SQLException e) {
	                System.out.println("Message: " + e.getMessage());
	                System.out.println("SQLState: " + e.getSQLState());
	                System.out.println("ErrorCode: " + e.getErrorCode());
	        } finally {
	        	finalize();
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
	        return  listaConductores;
	}

	public Conductor selectConductor(String nick) {
		Conductor cond = new Conductor();
		Vehiculo vehiculo = new Vehiculo();
		cond =  udao.selectUsuariobyNick(conn, nick);
		//String oidc = selectOIDConductor(nick);
		//String oidVehiculoConductor = obtenerVehiculoOID(oidc);
		String oidVehiculoConductor = obtenerVehiculoOID(nick);
	    vehiculo=selectVehiculoConductor(oidVehiculoConductor);
		cond.setVehiculo(vehiculo);
		return cond;
	}

	
	public List<Viaje> obtenerViajesConductor(String nickConductor){
		String oidc;
		List<Viaje> listaViajeConductor= new ArrayList<Viaje>();
		oidc=selectOIDConductor(nickConductor);
		listaViajeConductor=obtenerViajesOIDConductor(oidc);
		return listaViajeConductor;
	}
	public Vehiculo obtenerVehiculo(String nickConductor){
			
		Vehiculo veh = null;
		//String oidc=selectOIDConductor(nickConductor);
		//String oidVehiculoConductor= obtenerVehiculoOID(oidc);
		String oidVehiculoConductor= obtenerVehiculoOID(nickConductor);
		veh = selectVehiculoConductor(oidVehiculoConductor);
		return veh;
		
	}
	public String obtenerVehiculoOID(String nickconductor){
	 	PreparedStatement stmt = null;
        ResultSet result = null;
        //String sql = "SELECT * FROM conductor WHERE (OIDConductor = ?) ";
        String sql = "SELECT * FROM vehiculo WHERE (conductorID = ?) ";
        String oidVehC = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickconductor);
            result = stmt.executeQuery();

            result.next();
            oidVehC=(result.getString("OIDVehiculo"));


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
        return oidVehC;
    
}

	public Vehiculo selectVehiculoConductor(String oidVehiculoConductor){
		return (Vehiculo) vdao.selectVehiculoConductor(conn,oidVehiculoConductor);
		
	}
	
	public Viaje  cambiaEstadoViaje(String idViaje){
		return viadao.cambiaEstadoViaje(conn,idViaje);
	}

	public void insertarViajeC(String nick, Viaje viaje) {
		String oidc;
		String OIDViaje= UIDGenerator.getInstance().getKey();
				
		
		viadao.insertViaje(conn, OIDViaje, viaje);
		oidc= selectOIDConductor(nick);
		Conductor cond=udao.selectUsuariobyNick(conn, nick);
		actualizarPuntosConductor(oidc,"ALTA",cond.getEstrella());
		vehiculoRegistrado = obtenerVehiculoOID(nick);
		/* Si no nos diera el vehículo Registrado ( lo busca en la 
		 * tabla conductor ( OIDCond, OIDViaje, OIDVehiculo )
		 * y al menos existe ya un viaje del conductor dado de alta
		 * con su vehículo ya asignado.
		 */

		insertarC(oidc,OIDViaje,vehiculoRegistrado);

	}
	public void actualizarPuntosConductor(String oidc,String tipo, int estrellas){
		udao.actualizarPuntosConductor(conn,oidc,tipo,estrellas);
		
	}

	public void insertarC(String oidc, String oidv, String oidveh) {
        String sql = "INSERT INTO conductor (OIDConductor,OIDViaje,OIDVehiculo) VALUES (?, ?, ?) ";
        PreparedStatement stmt = null;
        	
        try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, oidc);
                stmt.setString(2, oidv);
                stmt.setString(3, oidveh);

                stmt.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Message: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
                try {
                        if (stmt != null)
                                stmt.close();
                } catch (SQLException e){
                }
        
        	}
		
	}
	
	public void delete(String nick,String oidViaje){
		
		String sql = "DELETE FROM conductor WHERE (OIDConductor = ?) and (OIDViaje=?) ";
        PreparedStatement stmt = null;
        String oidc= selectOIDConductor(nick);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oidc);
            stmt.setString(2, oidViaje);
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


}
