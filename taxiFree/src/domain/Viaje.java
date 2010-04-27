package domain;

import java.util.Date;
import java.util.List;


/**
 * @uml.dependency  supplier="modelado.IViajeStrategy" stereotypes="Standard::Call"
 * @uml.dependency  supplier="modelado.ICalculaViaje"
 */
public class Viaje {

	
	/**
	 * @uml.property  name="viajeID"
	 */
	private String viajeID;
	/**
	 * @uml.property  name="origen"
	 */
	private String origen;

	/**
	 * @return
	 * @uml.property  name="viajeID"
	 */
	public String getViajeID() {
		return viajeID;
	}

	/**
	 * @param  viajeID
	 * @uml.property  name="viajeID"
	 */
	public void setViajeID(String viajeID) {
		this.viajeID = viajeID;
	}

	/**
	 * Getter of the property <tt>origen</tt>
	 * @return    Returns the origen.
	 * @uml.property  name="origen"
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Setter of the property <tt>origen</tt>
	 * @param origen    The origen to set.
	 * @uml.property  name="origen"
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @uml.property  name="destino"
	 */
	private String destino;

	/**
	 * Getter of the property <tt>destino</tt>
	 * @return    Returns the destino.
	 * @uml.property  name="destino"
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Setter of the property <tt>destino</tt>
	 * @param destino    The destino to set.
	 * @uml.property  name="destino"
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @uml.property  name="fecha"
	 */
	private Date fecha;

	/**
	 * Getter of the property <tt>fecha</tt>
	 * @return    Returns the fecha.
	 * @uml.property  name="fecha"
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Setter of the property <tt>fecha</tt>
	 * @param fecha    The fecha to set.
	 * @uml.property  name="fecha"
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @uml.property  name="pasajeros"
	 */
	public List<Pasajero> pasajeros;
	/**
	 * @uml.property  name="conductor"
	 * @uml.associationEnd  
	 */
	public Conductor conductor;

	/**
	 * @return
	 * @uml.property  name="pasajeros"
	 */
	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	/**
	 * @param  pasajeros
	 * @uml.property  name="pasajeros"
	 */
	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	/**
	 * @return
	 * @uml.property  name="conductor"
	 */
	public Conductor getConductor() {
		return conductor;
	}

	/**
	 * @param  conductor
	 * @uml.property  name="conductor"
	 */
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	/**
	 * @uml.property  name="puntosIntermedios"
	 */
	public List<String> puntosIntermedios;

	/**
	 * @return
	 * @uml.property  name="puntosIntermedios"
	 */
	public List<String> getPuntosIntermedios() {
		return puntosIntermedios;
	}

	/**
	 * @param  puntosIntermedios
	 * @uml.property  name="puntosIntermedios"
	 */
	public void setPuntosIntermedios(List<String> puntosIntermedios) {
		this.puntosIntermedios = puntosIntermedios;
	}
	
	
}
