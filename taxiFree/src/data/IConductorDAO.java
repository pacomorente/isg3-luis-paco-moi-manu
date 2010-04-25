package data;

import java.util.List;

import domain.Conductor;

/**
 * @uml.dependency   supplier="data.ConnectionManager"
 */
public interface IConductorDAO {
	public List<Conductor> sellectAllConductores();
	public Conductor selectConductor(String nick);
}
