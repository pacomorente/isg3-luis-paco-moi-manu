package domain;

import java.util.List;

/**
 * @uml.dependency   supplier="domain.Viaje"
 * @uml.dependency   supplier="domain.Conductor"
 * @uml.dependency   supplier="domain.Vehiculo"
 */
public interface IAccionConductor {
	public List<Viaje> verViajesAsignados(Viaje viaje);
	public void insertarViaje(Viaje viaje);
	public Viaje consultaViaje(Viaje tra);
	public Viaje modificaViaje(Viaje viaje);
	public boolean eliminaViaje(Viaje viaje);
	
	public void insertarVehiculo(Vehiculo vehiculo);
	public Vehiculo modificaVehiculo(Vehiculo vehiculo);
	public boolean eliminaVehiculo(Vehiculo vehiculo);
}
