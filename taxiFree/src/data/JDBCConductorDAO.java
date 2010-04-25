package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Conductor;
import domain.Usuario;
import domain.Vehiculo;

public class JDBCConductorDAO implements IConductorDAO {

	   private Connection conn;

	    IUsuarioDAO udao;
	    IVehiculoDAO vdao;

	    public JDBCConductorDAO() {
	        conn = ConnectionManager.getInstance().checkOut();
	        udao = new JDBCUsuarioDAO();
	        vdao = new JDBCVehiculoDAO();
	    }

	    protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	    }
	
	public Conductor selectConductor(String nick) {
			return null;

	}


	public List<Conductor> sellectAllConductores() {
	        Connection conn = ConnectionManager.getInstance().checkOut();
	        PreparedStatement stmt = null;
	        ResultSet result = null;
	        List<Conductor> listaConductores = new LinkedList <Conductor>();
	        String sql = "SELECT * FROM Conductor ";
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

}
