package domain;

import java.util.List;


/**
 * @author   morentefj
 */
public class Conductor extends Usuario  {
	
	/**
	 * @uml.property  name="idConductor"
	 */
	private String idConductor;
	
	/**
	 * @return
	 * @uml.property  name="idConductor"
	 */
	public String getIdConductor() {
		return idConductor;
	}

	/**
	 * @param  idConductor
	 * @uml.property  name="idConductor"
	 */
	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}



	/** 
	 * @uml.property name="vehiculo"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Vehiculo"
	 */

	

	/**
	 * @uml.property  name="viaje"
	 */
	private List<Viaje> viaje;







	/**
	 * Getter of the property <tt>viaje</tt>
	 * @return    Returns the viaje.
	 * @uml.property  name="viaje"
	 */
	public List<Viaje> getViaje() {
		return viaje;
	}

	/**
	 * Setter of the property <tt>viaje</tt>
	 * @param viaje    The viaje to set.
	 * @uml.property  name="viaje"
	 */
	public void setViaje(List<Viaje> viaje) {
		this.viaje = viaje;
	}



	/**
	 * @uml.property  name="vehiculo"
	 * @uml.associationEnd  
	 */
	private Vehiculo vehiculo = new Vehiculo();

	/**
	 * Getter of the property <tt>vehiculo</tt>
	 * @return    Returns the vehiculo.
	 * @uml.property  name="vehiculo"
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Setter of the property <tt>vehiculo</tt>
	 * @param vehiculo    The vehiculo to set.
	 * @uml.property  name="vehiculo"
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}



}
