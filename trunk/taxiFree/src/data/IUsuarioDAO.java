package data;

import java.sql.Connection;
import java.util.List;

import domain.Usuario;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IUsuarioDAO {
    public abstract Usuario select(Connection conn, String usuarioOID);
	public List<Usuario> selectAllUsuarios();
	public String selectUsuarioOID(Connection conn, String nick);
	public void insert(Connection con, Usuario u, String usuarioOID);
}
