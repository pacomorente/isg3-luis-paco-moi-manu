package domain;

import java.util.Date;


public class Ruta {
	
	public String origen;
	public String destino;
	public Integer desplazamiento;
	public Date fecha;
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Integer getDesplazamiento() {
		return desplazamiento;
	}
	public void setDesplazamiento(Integer desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
}
