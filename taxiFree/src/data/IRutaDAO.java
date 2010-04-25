package data;

import java.util.List;

import domain.Ruta;

/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public interface IRutaDAO {
	public List<Ruta> selectAllRutas();
	public Ruta selectRuta(String s);
	public void insertRuta(Ruta r, String userOID);
	public void deleteRuta(String idRuta);
	public void updateRuta(Ruta r, String userOID);
}
