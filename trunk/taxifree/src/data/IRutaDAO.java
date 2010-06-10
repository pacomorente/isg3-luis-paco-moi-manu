package data;

import java.sql.Connection;
import java.util.List;

import domain.Ruta;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IRutaDAO {
	public List<Ruta> selectAllRutas();
	public String selectRutaOID(String idRuta);
	public Ruta select(String rutaOID);
	public void insert(Connection con, Ruta r);
	public void deleteRuta(Ruta r);
	public void updateRuta(Ruta ra, Ruta rn);
	public List<Ruta> selectRutas(Connection conn, String oidPasajero);
	public List<Ruta> selectRutaPasajero(String nick);
	public Ruta selectRuta(String idRuta);
}
