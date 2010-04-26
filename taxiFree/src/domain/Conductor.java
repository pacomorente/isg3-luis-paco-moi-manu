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



	/** 
	 * @uml.property name="vehiculo"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Vehiculo"
	 */

	

	/** 
	 * @uml.property name="viaje"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Viaje"
	 */
	private List<Viaje> viaje;







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



	/**
	 * @uml.property  name="vehiculo"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="conductor1:domain.Vehiculo"
	 * @uml.association  name="posee"
	 */
	private Vehiculo vehiculo = new Vehiculo();

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



}
