package modelado;


public interface IViajeStrategy {

	/**
	 * @return  Returns the viaje.
	 * @uml.property  name="viaje"
	 * @uml.associationEnd  inverse="iViajeStrategy:modelado.Viaje"
	 */
	public Viaje getViaje();

	/**
	 * Setter of the property <tt>viaje</tt>
	 * @param viaje  The viaje to set.
	 * @uml.property  name="viaje"
	 */
	public void setViaje(Viaje viaje);

}
