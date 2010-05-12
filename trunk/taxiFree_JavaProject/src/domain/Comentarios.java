package domain;

import java.util.Collection;


public class Comentarios {

	/** 
	 * @uml.property name="usuario"
	 * @uml.associationEnd inverse="comentarios:domain.Usuario"
	 */
	private Usuario usuario;

	/** 
	 * Getter of the property <tt>usuario</tt>
	 * @return  Returns the usuario.
	 * @uml.property  name="usuario"
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/** 
	 * Setter of the property <tt>usuario</tt>
	 * @param usuario  The usuario to set.
	 * @uml.property  name="usuario"
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/** 
	 * @uml.property name="es"
	 * @uml.associationEnd inverse="tiene:domain.Conductor"
	 */
	private Conductor conductor;

	/**
	 * Getter of the property <tt>es</tt>
	 * @return  Returns the conductor.
	 * @uml.property  name="es"
	 */
	public Conductor getEs() {
		return conductor;
	}

	/**
	 * Setter of the property <tt>es</tt>
	 * @param es  The conductor to set.
	 * @uml.property  name="es"
	 */
	public void setEs(Conductor es) {
		conductor = es;
	}

}
