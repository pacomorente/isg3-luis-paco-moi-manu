package data;

import java.sql.Connection;

import domain.Vehiculo;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IVehiculoDAO {
    public void delete(Connection conn, String VehiculoOID);
    public void insert(Connection conn, Vehiculo veh);

    public Vehiculo select(Connection conn, String VehiculoOID);
    public Vehiculo selectVehiculoConductor(Connection conn,
			String oidVehiculoConductor);
	
/*	public Vehiculo selectVehiculobyViaje(Connection conn,
			String oidViaje);
	public List<Vehiculo> selectAllVehiculos();		
			*/

}
