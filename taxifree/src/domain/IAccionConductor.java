package domain;

import java.util.List;

/**
 * @uml.dependency   supplier="domain.Conductor"
 * @uml.dependency   supplier="domain.Vehiculo"
 * @uml.dependency   supplier="domain.GraphImpl"
 */
public interface IAccionConductor {
	public List<Viaje> verViajesAsignados(String nickConcductor);

	public Conductor datosConductor(String nickConductor);
	public Vehiculo obtenerVehiculoC(String nick);
	public Viaje  cambiaEstadoViaje( String idViaje);
	public boolean eliminaViaje( String idViaje);
	
	public void insertarViajeConductor(String nick, Viaje viaje);
	public int verPuntosActualesConductor (String nick);
	public Viaje consultaViaje(String idViaje);
	public void updateViajeConductor(Viaje idViaje);
	public boolean existePasajerosViaje(String idViaje);
	public boolean existeViaje(Viaje viaje);
	public boolean existeViajeAlta(Viaje v, String nick);
	
}
