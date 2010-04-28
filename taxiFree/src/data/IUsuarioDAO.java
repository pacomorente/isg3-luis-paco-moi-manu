package data;

import java.sql.Connection;
import java.util.List;

import domain.Usuario;

/**
 * @uml.dependency  supplier="data.ConnectionManager"
 */
public interface IUsuarioDAO {
    public Usuario select(Connection conn, String UsuarioOID);
	public List<Usuario> selectAllUsuarios();
	public String selectUsuarioOID(Connection conn, String nick);
}
