package data;
import java.sql.Connection;
import java.util.List;

import domain.Usuario;

public class JDBCUsuarioDAO implements IUsuarioDAO{
       


		@Override
		public Usuario select(Connection conn, String UsuarioOID) {
			return null;
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Usuario> selectAllUsuarios() {
			// TODO Auto-generated method stub
			return null;
		}
}

