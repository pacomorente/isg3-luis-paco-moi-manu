package modelado;

import java.util.Date;
import java.util.Collection;


/**
 * @uml.dependency   supplier="modelado.ICalculaViaje" stereotypes="Standard::Call"
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
	 * @uml.associationEnd  inverse="viaje:modelado.IViajeStrategy"
	 */
	private IViajeStrategy iViajeStrategy;

	/**
	 * Getter of the property <tt>iViajeStrategy</tt>
	 * @return  Returns the iViajeStrategy.
	 * @uml.property  name="iViajeStrategy"
	 */
	public IViajeStrategy getIViajeStrategy() {
		return iViajeStrategy;
	}

	/**
	 * Setter of the property <tt>iViajeStrategy</tt>
	 * @param iViajeStrategy  The iViajeStrategy to set.
	 * @uml.property  name="iViajeStrategy"
	 */
	public void setIViajeStrategy(IViajeStrategy iViajeStrategy) {
		this.iViajeStrategy = iViajeStrategy;
	}

	/** 
	 * @uml.property name="iViajeStrategy1"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="viaje1:modelado.IViajeStrategy"
	 */
	private Collection<IViajeStrategy> iViajeStrategy1;

	/** 
	 * Getter of the property <tt>iViajeStrategy1</tt>
	 * @return  Returns the iViajeStrategy1.
	 * @uml.property  name="iViajeStrategy1"
	 */
	public Collection<IViajeStrategy> getIViajeStrategy1() {
		return iViajeStrategy1;
	}

	/** 
	 * Setter of the property <tt>iViajeStrategy1</tt>
	 * @param iViajeStrategy1  The iViajeStrategy1 to set.
	 * @uml.property  name="iViajeStrategy1"
	 */
	public void setIViajeStrategy1(Collection<IViajeStrategy> iViajeStrategy1) {
		this.iViajeStrategy1 = iViajeStrategy1;
	}

}
