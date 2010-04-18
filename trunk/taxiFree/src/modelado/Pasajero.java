package modelado;

import java.util.Collection;


public class Pasajero extends Usuario  {

	/**
	 * @uml.property  name="desplazamiento"
	 */
	private int desplazamiento;

	/**
	 * Getter of the property <tt>desplazamiento</tt>
	 * @return  Returns the desplazamiento.
	 * @uml.property  name="desplazamiento"
	 */
	public int getDesplazamiento() {
		return desplazamiento;
	}

	/**
	 * Setter of the property <tt>desplazamiento</tt>
	 * @param desplazamiento  The desplazamiento to set.
	 * @uml.property  name="desplazamiento"
	 */
	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	/**
	 * @uml.property  name="puntoPartida"
	 */
	private String puntoPartida;

	/**
	 * Getter of the property <tt>puntoPartida</tt>
	 * @return  Returns the puntoPartida.
	 * @uml.property  name="puntoPartida"
	 */
	public String getPuntoPartida() {
		return puntoPartida;
	}

	/**
	 * Setter of the property <tt>puntoPartida</tt>
	 * @param puntoPartida  The puntoPartida to set.
	 * @uml.property  name="puntoPartida"
	 */
	public void setPuntoPartida(String puntoPartida) {
		this.puntoPartida = puntoPartida;
	}

	/** 
	 * @uml.property name="viaje"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="pasajero:modelado.Viaje"
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
	
	public String puntoLlegada;

	public String getPuntoLlegada() {
		return puntoLlegada;
	}

	public void setPuntoLlegada(String puntoLlegada) {
		this.puntoLlegada = puntoLlegada;
	}
	
	
	
}
