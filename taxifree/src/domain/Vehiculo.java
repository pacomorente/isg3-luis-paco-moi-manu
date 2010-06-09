package domain;



/**
 * @author    morentefj
 */
public class Vehiculo {

	/**
	 * @uml.property  name="idVehiculo"
	 */
	private String idVehiculo;
	private String idConductor;
	public String getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}

	/**
	 * @uml.property  name="conductor"
	 * @uml.associationEnd  
	 */
	private Conductor conductor ;

	/**
	 * @return
	 * @uml.property  name="idVehiculo"
	 */
	public String getIdVehiculo() {
		return idVehiculo;
	}

	/**
	 * @param idVehiculo
	 * @uml.property  name="idVehiculo"
	 */
	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	/**
	 * Getter of the property <tt>conductor</tt>
	 * @return    Returns the conductor.
	 * @uml.property  name="conductor"
	 */
	public Conductor getConductor() {
		return conductor;
	}

	/**
	 * Setter of the property <tt>conductor</tt>
	 * @param conductor    The conductor to set.
	 * @uml.property  name="conductor"
	 */
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	/**
	 * @uml.property  name="marca"
	 */
	private String marca;

	/**
	 * Getter of the property <tt>marca</tt>
	 * @return    Returns the marca.
	 * @uml.property  name="marca"
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Setter of the property <tt>marca</tt>
	 * @param marca    The marca to set.
	 * @uml.property  name="marca"
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @uml.property  name="modelo"
	 */
	private String modelo;

	/**
	 * Getter of the property <tt>modelo</tt>
	 * @return    Returns the modelo.
	 * @uml.property  name="modelo"
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Setter of the property <tt>modelo</tt>
	 * @param modelo    The modelo to set.
	 * @uml.property  name="modelo"
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @uml.property  name="color"
	 */
	private String color;

	/**
	 * Getter of the property <tt>color</tt>
	 * @return    Returns the color.
	 * @uml.property  name="color"
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter of the property <tt>color</tt>
	 * @param color    The color to set.
	 * @uml.property  name="color"
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @uml.property  name="plazas"
	 */
	private int plazas;

	/**
	 * Getter of the property <tt>plazas</tt>
	 * @return    Returns the plazas.
	 * @uml.property  name="plazas"
	 */
	public int getPlazas() {
		return plazas;
	}

	/**
	 * Setter of the property <tt>plazas</tt>
	 * @param plazas    The plazas to set.
	 * @uml.property  name="plazas"
	 */
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}



}
