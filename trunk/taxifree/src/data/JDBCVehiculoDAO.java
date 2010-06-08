package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import utils.UIDGenerator;

import domain.Vehiculo;

public class JDBCVehiculoDAO implements IVehiculoDAO{
       
        public void delete(Connection conn, String VehiculoOID) {
                String sql = "DELETE FROM vehiculo WHERE (VehiculoOID = ?) ";
                PreparedStatement stmt = null;
                try{
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, VehiculoOID);
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
       
        public void insert(Connection conn, Vehiculo veh) {
                String sql = "INSERT INTO vehiculo (VehiculoOID, Marca, Modelo, Color, Plazas) VALUES (?, ?, ?, ?, ?) ";
                PreparedStatement stmt = null;
                String vehOID= UIDGenerator.getInstance().getKey();
                try {
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, vehOID);
                        stmt.setString(2, veh.getMarca());
                        stmt.setString(3, veh.getModelo());
                        stmt.setString(4, veh.getColor());
                        stmt.setInt(5, veh.getPlazas());
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

        public List<Vehiculo> selectAllVehiculos(){
               
                Connection conn = ConnectionManager.getInstance().checkOut();
                PreparedStatement stmt = null;          
                ResultSet result = null;        
                List<Vehiculo> listaVehiculos = new LinkedList<Vehiculo>();
                String sql = "SELECT * FROM vehiculo";          
                try {          
                        stmt = conn.prepareStatement(sql);      
                        result = stmt.executeQuery();          
                        while (result.next()) {                
                                Vehiculo aux= new Vehiculo();                  
                                aux.setMarca(result.getString("Marca"));        
                                aux.setModelo(result.getString("Modelo"));
                                aux.setColor(result.getString("Color"));
                                aux.setPlazas(result.getInt("Plazas"));  
                                listaVehiculos.add(aux);                
                        }
                } catch(SQLException e) {      
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
                return listaVehiculos;
        }
        

		public Vehiculo select(Connection conn, String VehiculoOID) {
			return selectVehiculoConductor(conn, VehiculoOID);

			
		}
		public Vehiculo selectVehiculoConductor(Connection conn,
				String oidVehiculoConductor) {
			
				PreparedStatement stmt = null;
		        ResultSet result = null;
		        Vehiculo vehCond = new Vehiculo();
				
		        try {
		        	String sql = "SELECT * FROM vehiculo WHERE (OIDVehiculo = ?) ";
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, oidVehiculoConductor);

		            result = stmt.executeQuery();
		            //System.out.println(stmt);
		            result.next();
		            
		            vehCond.setColor(result.getString("color"));
		            vehCond.setMarca(result.getString("marca"));
		            vehCond.setModelo(result.getString("modelo"));
		            vehCond.setPlazas(result.getInt("plazas"));
					
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
		        
		        return vehCond;
			}
		        

		
}

