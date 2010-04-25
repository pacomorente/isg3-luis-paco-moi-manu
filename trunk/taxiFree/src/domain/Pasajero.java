package domain;

import java.util.Collection;


/**
 * @uml.dependency   supplier="domain.Ruta"
 */
public class Pasajero extends Usuario  {

	/**
	 * @uml.property   name="viaje"
	 * @uml.associationEnd   multiplicity="(1 -1)" inverse="pasajero:modelado.Viaje"
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
	
	public Collection<Ruta> rutas;

	public Collection<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(Collection<Ruta> rutas) {
		this.rutas = rutas;
	}
	
	
	
}
