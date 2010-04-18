package data;

import java.util.List;

import domain.Conductor;

public interface IConductorDAO {
	public List<Conductor> sellectAllConductores();
	public Conductor selectConductor(String nick);
}
