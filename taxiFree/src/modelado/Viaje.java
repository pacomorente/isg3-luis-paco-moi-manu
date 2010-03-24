package modelado;

import java.util.Date;


public class Viaje {

	/**
	 * @uml.property  name="origen"
	 */
	private String origen;

	/**
	 * Getter of the property <tt>origen</tt>
	 * @return  Returns the origen.
	 * @uml.property  name="origen"
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Setter of the property <tt>origen</tt>
	 * @param origen  The origen to set.
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
	 * @return  Returns the destino.
	 * @uml.property  name="destino"
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Setter of the property <tt>destino</tt>
	 * @param destino  The destino to set.
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
	 * @return  Returns the fecha.
	 * @uml.property  name="fecha"
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Setter of the property <tt>fecha</tt>
	 * @param fecha  The fecha to set.
	 * @uml.property  name="fecha"
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
