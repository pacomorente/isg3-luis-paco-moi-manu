package domain;

import java.util.List;

public interface IAccionConductor {
	public List<Viaje> verViajesAsignados(Viaje viaje);
	public void insertarTrayecto(Trayecto tra);
	public Trayecto consultaTrayecto(Trayecto tra);
	public Trayecto modificaTrayecto(Trayecto tra);
	public boolean eliminaTrayecto(Trayecto tra);
	
}
