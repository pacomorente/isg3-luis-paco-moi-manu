package data;

import java.sql.Connection;
import java.util.List;

import domain.Usuario;

public interface IUsuarioDAO {
    public Usuario select(Connection conn, String UsuarioOID);

	List<Usuario> selectAllUsuarios();
}
