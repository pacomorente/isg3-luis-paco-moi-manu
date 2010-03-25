package modelado;

import java.util.Date;
import java.util.Collection;


/**
 * @uml.dependency   supplier="modelado.ICalculaViaje"
 * @uml.dependency   supplier="modelado.IViajeStrategy" stereotypes="Standard::Call"
 */
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

	/**
	 * @uml.property  name="iViajeStrategy"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="viaje1:modelado.IViajeStrategy"
	 */
	private Collection<IViajeStrategy> viajeStrategy;

	/**
	 * Getter of the property <tt>iViajeStrategy</tt>
	 * @return  Returns the viajeStrategy.
	 * @uml.property  name="iViajeStrategy"
	 */
	public Collection<IViajeStrategy> getIViajeStrategy() {
		return viajeStrategy;
	}

	/**
	 * Setter of the property <tt>iViajeStrategy</tt>
	 * @param iViajeStrategy  The viajeStrategy to set.
	 * @uml.property  name="iViajeStrategy"
	 */
	public void setIViajeStrategy(Collection<IViajeStrategy> viajeStrategy) {
		this.viajeStrategy = viajeStrategy;
	}

	/**
	 * @uml.property  name="iViajeStrategy"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="viaje:modelado.IViajeStrategy"
	 */
	
	
}
