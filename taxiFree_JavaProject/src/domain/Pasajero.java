package domain;

import java.util.Collection;


/**
 * @uml.dependency  supplier="domain.Ruta"
 */
public class Pasajero extends Usuario  {
	
	
	
	public Pasajero(String nombre, String apellidos, String dni, String correo,
			String nick, String pass, int estrella) {
		super(nombre,apellidos,dni,correo,nick, pass, estrella);
	}

	public Pasajero(){
		super();
	}
	
	/**
	 * @uml.property  name="viaje"
	 */
	private Collection<Viaje> viaje;

	/**
	 * Getter of the property <tt>viaje</tt>
	 * @return    Returns the viaje.
	 * @uml.property  name="viaje"
	 */
	public Collection<Viaje> getViaje() {
		return viaje;
	}

	/**
	 * Setter of the property <tt>viaje</tt>
	 * @param viaje    The viaje to set.
	 * @uml.property  name="viaje"
	 */
	public void setViaje(Collection<Viaje> viaje) {
		this.viaje = viaje;
	}
	
	/**
	 * @uml.property  name="rutas"
	 */
	public Collection<Ruta> rutas;

	/**
	 * @return
	 * @uml.property  name="rutas"
	 */
	public Collection<Ruta> getRutas() {
		return rutas;
	}

	/**
	 * @param  rutas
	 * @uml.property  name="rutas"
	 */
	public void setRutas(Collection<Ruta> rutas) {
		this.rutas = rutas;
	}
	
	
	
}
