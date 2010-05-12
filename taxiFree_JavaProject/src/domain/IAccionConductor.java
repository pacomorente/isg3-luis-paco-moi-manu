package domain;

import java.util.List;

/**
 * @uml.dependency   supplier="domain.Conductor"
 * @uml.dependency   supplier="domain.Vehiculo"
 * @uml.dependency   supplier="domain.GraphImpl"
 */
public interface IAccionConductor {
	public List<Viaje> verViajesAsignados(String nickConcductor);


	public Vehiculo obtenerVehiculoC(String nick);
}
