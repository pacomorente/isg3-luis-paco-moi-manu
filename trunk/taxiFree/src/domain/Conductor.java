package domain;

import java.util.List;


public class Conductor extends Usuario  {
	
	private String idConductor;
	
	public String getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}

	private List<Trayecto> trayectos;

	/** 
	 * @uml.property name="vehiculo"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Vehiculo"
	 */
	private Vehiculo vehiculo;
	

	
	public List<Trayecto> getTrayectos() {
		return trayectos;
	}

	public void setTrayectos(List<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}

	/** 
	 * @uml.property name="viaje"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Viaje"
	 */
	private List<Viaje> viaje;



	/** 
	 * Getter of the property <tt>vehiculo</tt>
	 * @return  Returns the vehiculo.
	 * @uml.property  name="vehiculo"
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/** 
	 * Setter of the property <tt>vehiculo</tt>
	 * @param vehiculo  The vehiculo to set.
	 * @uml.property  name="vehiculo"
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}



	/** 
	 * Getter of the property <tt>viaje</tt>
	 * @return  Returns the viaje.
	 * @uml.property  name="viaje"
	 */
	public List<Viaje> getViaje() {
		return viaje;
	}

	/** 
	 * Setter of the property <tt>viaje</tt>
	 * @param viaje  The viaje to set.
	 * @uml.property  name="viaje"
	 */
	public void setViaje(List<Viaje> viaje) {
		this.viaje = viaje;
	}



}
