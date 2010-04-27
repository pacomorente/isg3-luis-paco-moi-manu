package domain;

import java.util.Date;


/**
 * @author   morentefj
 */
public class Ruta {
	
	private String idRuta;
	
	/**
	 * @uml.property  name="origen"
	 */
	public String origen;
	
	public String getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(String idRuta) {
		this.idRuta = idRuta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @uml.property  name="destino"
	 */
	public String destino;
	/**
	 * @uml.property  name="desplazamiento"
	 */
	public Integer desplazamiento;
	public Date fecha;
	
	/**
	 * @return
	 * @uml.property  name="origen"
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param  origen
	 * @uml.property  name="origen"
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * @return
	 * @uml.property  name="destino"
	 */
	public String getDestino() {
		return destino;
	}
	/**
	 * @param  destino
	 * @uml.property  name="destino"
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * @return
	 * @uml.property  name="desplazamiento"
	 */
	public Integer getDesplazamiento() {
		return desplazamiento;
	}
	/**
	 * @param  desplazamiento
	 * @uml.property  name="desplazamiento"
	 */
	public void setDesplazamiento(Integer desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
}
