package modelado;

import java.util.Collection;


public class Conductor extends Usuario  {

	/** 
	 * @uml.property name="vehiculo"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Vehiculo"
	 */
	private Collection <Vehiculo> vehiculo;

	/** 
	 * Getter of the property <tt>vehiculo</tt>
	 * @return  Returns the vehiculo.
	 * @uml.property  name="vehiculo"
	 */
	public Collection<Vehiculo> getVehiculo() {
		return vehiculo;
	}

	/** 
	 * Setter of the property <tt>vehiculo</tt>
	 * @param vehiculo  The vehiculo to set.
	 * @uml.property  name="vehiculo"
	 */
	public void setVehiculo(Collection<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}

	/** 
	 * @uml.property name="viaje"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="conductor:modelado.Viaje"
	 */
	private Collection<Viaje> viaje;

	/** 
	 * Getter of the property <tt>viaje</tt>
	 * @return  Returns the viaje.
	 * @uml.property  name="viaje"
	 */
	public Collection<Viaje> getViaje() {
		return viaje;
	}

	/** 
	 * Setter of the property <tt>viaje</tt>
	 * @param viaje  The viaje to set.
	 * @uml.property  name="viaje"
	 */
	public void setViaje(Collection<Viaje> viaje) {
		this.viaje = viaje;
	}

}
