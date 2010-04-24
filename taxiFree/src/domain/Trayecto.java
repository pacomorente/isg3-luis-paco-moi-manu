package domain;

import java.util.Date;


public class Trayecto {
	
	private String origenTrayecto;
	private String destinoTrayecto;
	private Date fechaSalida;
	
	public String getOrigenTrayecto() {
		return origenTrayecto;
	}

	public void setOrigenTrayecto(String origenTrayecto) {
		this.origenTrayecto = origenTrayecto;
	}

	public String getDestinoTrayecto() {
		return destinoTrayecto;
	}

	public void setDestinoTrayecto(String destinoTrayecto) {
		this.destinoTrayecto = destinoTrayecto;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
