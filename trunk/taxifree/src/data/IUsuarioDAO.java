package data;

import java.sql.Connection;
import java.util.List;

import domain.Conductor;
import domain.Usuario;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IUsuarioDAO {
    public abstract Usuario select(Connection conn, String usuarioOID);
	public List<Usuario> selectAllUsuarios();
	public String selectUsuarioOID(Connection conn, String nick);
	public Conductor selectUsuariobyNick(Connection conn, String nick);
	public void insert(Connection con, Usuario u);
	public void actualizarPuntosConductor(Connection con,String oidc, String tipo, int estrellas);
}
