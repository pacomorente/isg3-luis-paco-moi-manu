package domain;

import java.util.List;
import java.util.Collection;


/**
 * @author   morentefj
 */
public class Conductor extends Usuario  {
	
	public Conductor(String string, String string2, String string3,
			String string4, String string5, int i, String string6,
			String string7) {
		super();
		// TODO Auto-generated constructor stub
	}



	public Conductor() {
		// TODO Auto-generated constructor stub
	}



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
	private Vehiculo vehiculo ;

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



	/** 
	 * @uml.property name="tiene"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="es:domain.Comentarios"
	 */
	@SuppressWarnings("unchecked")
	private Collection comentarios;





	/**
	 * Getter of the property <tt>tiene</tt>
	 * @return  Returns the comentarios.
	 * @uml.property  name="tiene"
	 */
	@SuppressWarnings("unchecked")
	public Collection getTiene() {
		return comentarios;
	}



	/**
	 * Setter of the property <tt>tiene</tt>
	 * @param tiene  The comentarios to set.
	 * @uml.property  name="tiene"
	 */
	@SuppressWarnings("unchecked")
	public void setTiene(Collection tiene) {
		comentarios = tiene;
	}



}
