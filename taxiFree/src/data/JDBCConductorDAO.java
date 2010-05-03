package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		/*vehiculo = leeVehiculoConductor(nick);
		cond.getVehiculo(vehiculo);*/
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
		return (Vehiculo) vdao.selectViajeConductor(conn,oidVehiculoConductor);
		
	}



}
