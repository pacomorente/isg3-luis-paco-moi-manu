package data;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Viaje;

public class JDBCViajeDAO implements IViajeDAO {

	@Override
	public void deleteViaje(Connection conn, String ViajeOID) {
        String sql = "DELETE FROM Viaje WHERE (OID = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ViajeOID);
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

	@Override
	public void insertViaje(Viaje v, String userOID) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Viaje> selectAllViajes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viaje selectViaje(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViaje(Viaje v, String userOID) {
		// TODO Auto-generated method stub
		
	}

}
