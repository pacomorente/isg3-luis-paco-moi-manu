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
	        conn = ConnectionManager.getInstance().checkOut();
	        udao = new JDBCUsuarioDAO();
	        vdao = new JDBCVehiculoDAO();
	        viadao = new JDBCViajeDAO();
	    }

	    protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	    }
	
	public String selectOIDConductor(String nick) {
			return udao.selectUsuarioOID(conn, nick);
	}

	public List<String> obtenerViajesOIDConductor(String oidc){
		 	PreparedStatement stmt = null;
	        ResultSet result = null;
	        String sql = "SELECT * FROM conductor WHERE (OIDConductor = ?) ";
	        List<String> searchResults = new ArrayList<String>();
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, oidc);
	            result = stmt.executeQuery();

	            //result.next();
	            while (result.next()) {
					   String oidViajeC =(result.getString("OIDViaje"));
					   searchResults.add(oidViajeC);
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
	
	public Conductor selectConductorbyViaje(String oidviaje){
		PreparedStatement stmt = null;
        ResultSet result = null;
        String sql = "SELECT * FROM conductor WHERE (OIDViaje = ?) ";
        String oidCond = null;
        Conductor cond= new Conductor();
        List<Viaje>listaViajesC=new LinkedList<Viaje>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oidviaje);
            result = stmt.executeQuery();

            result.next();
            
            oidCond=(result.getString("OIDConductor"));
            List<String> listaViajes = obtenerViajesOIDConductor(oidCond);
    		for (String auxvOID: listaViajes){
    			
   			 Viaje viajeCond = selectViajeConductor(auxvOID);
   			 listaViajesC.add(viajeCond);

    			}
   		
            Vehiculo v = vdao.selectVehiculoConductor(conn, oidCond);
            
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
	
	public Viaje selectViaje(String idViaje){
		return (Viaje) viadao.selectViaje(conn,idViaje);
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
	                        String oidConductor = result.getString("OIDConductor");
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
		String oidc = selectOIDConductor(nick);
		String oidVehiculoConductor = obtenerVehiculoOID(oidc);
	    vehiculo=selectVehiculoConductor(oidVehiculoConductor);
		cond.setVehiculo(vehiculo);
		return cond;
	}

	public String obtenerVehiculoOID(String oidc){
	 	PreparedStatement stmt = null;
        ResultSet result = null;
        String sql = "SELECT * FROM conductor WHERE (OIDConductor = ?) ";
        String oidVehC = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oidc);
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

	public void insertarViajeC(String nick, Viaje viaje) {
		String oidc;
		String OIDViaje= UIDGenerator.getInstance().getKey();
		viadao.insertViaje(conn, OIDViaje, viaje);
		oidc= selectOIDConductor(nick);
		
		vehiculoRegistrado = obtenerVehiculoOID(oidc);
		/* Si no nos diera el vehículo Registrado ( lo busca en la 
		 * tabla conductor ( OIDCond, OIDViaje, OIDVehiculo )
		 * y al menos existe ya un viaje del conductor dado de alta
		 * con su vehículo ya asignado.
		 */

		insertarC(oidc,OIDViaje,vehiculoRegistrado);
		

	
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


}
