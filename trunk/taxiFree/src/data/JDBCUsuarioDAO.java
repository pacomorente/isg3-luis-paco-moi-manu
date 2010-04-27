package data;
import java.sql.Connection;
import java.util.List;

import domain.Usuario;

/**
 * @uml.dependency   supplier="data.IUsuarioDAO"
 */
public class JDBCUsuarioDAO implements IUsuarioDAO{
       



		public Usuario select(Connection conn, String UsuarioOID) {
			return null;
			// TODO Auto-generated method stub
			
		}


		public List<Usuario> selectAllUsuarios() {
			// TODO Auto-generated method stub
			return null;
		}
}

