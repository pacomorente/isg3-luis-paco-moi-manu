package test;

import java.util.List;

import domain.*;


public class TestCasoDeUsoPasajero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IAccionPasajero accPasajero = new AccionPasajeroImpl();
		List<Ruta> listaRutas = (List<Ruta>) accPasajero.consultaRuta();
		System.out.println("=== Lista de rutas ===\n");
		for(Ruta r : listaRutas){
			System.out.println(r.getOrigen()+"--->"+r.getDestino());
		}
		
		Ruta r = new Ruta(null, "SEVILLA", "GRANADA", null,null);
		List<Viaje> listaViajes = (List<Viaje>)accPasajero.buscarViaje(r);
		System.out.println("\n=== Lista de viajes Sevilla-Granada ===\n");
		for(Viaje v : listaViajes){
			System.out.println(v.getOrigen()+"--->"+v.getDestino()+" -- "+v.getConductor());
		}
	}

}
