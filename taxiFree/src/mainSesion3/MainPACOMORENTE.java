package mainSesion3;

import java.util.List;

import domain.AccionConductorImpl;
import domain.IAccionConductor;
import domain.Usuario;
import domain.Vehiculo;
import domain.Viaje;
import domain.ViajeStore;

public class MainPACOMORENTE {

	/**
	 * @param args
	 */
		
	public static void main(String[] args) {
		
		Usuario c = new Usuario();
		//("00006","Monica","Ortiz","90000006X","C6@US.ES",1,"USER6","USER6");
		c.setNick("USER6");
		
		//Viaje viaje = new Viaje();
		List<Viaje> viajesCond ;
		Vehiculo vehiculoCond;

		IAccionConductor accionCond = new AccionConductorImpl();
		
		ViajeStore v = new ViajeStore();
		List<Viaje> l = v.getViajes();
		System.out.println("===========================================");
		System.out.println("---VIAJES DADOS DE ALTA EN TAXIFREE---");
		System.out.println("===========================================");
		for(Viaje via:l){
			String viajeAnulado="VIAJE ESTA ACTUALMENTE ACTIVO";
			if(via.getAnulado())
				viajeAnulado="VIAJE ACTUALMENTE ANULADO";					
				
			System.out.println(via.getViajeID()+ " - " + via.getOrigen() 
					+ " - " + via.getDestino() 
					+ " - " + via.getFecha()
					+ " - " + viajeAnulado );
		}
		System.out.println("===========================================");	
		System.out.println("---VIAJES ASIGNADOS DEL CONDUCTOR(nick) : "+ c.getNick());	
		System.out.println("===========================================");
		viajesCond= accionCond.verViajesAsignados(c.getNick());
		vehiculoCond = accionCond.obtenerVehiculoC(c.getNick());
		System.out.println("NUMERO DE VIAJES DEL CONDUCTOR--> " + viajesCond.size());
		String viajeAnulado="VIAJE ESTA ACTUALMENTE ACTIVO";

		for(Viaje auxv : viajesCond){
			if(auxv.getAnulado()) // =0 --> ACTIVO
				viajeAnulado="VIAJE ESTA ACTUALMENTE ANULADO";
			System.out.println(auxv.getOrigen()+"--->"+auxv.getDestino()
					/*+" -- "+auxv.getConductor().getNombre() 
					+ "DNI: " + auxv.getConductor().getDni()
					+ auxv.getConductor().getDni()*/
					+ " - " + viajeAnulado );

		}
		System.out.println("===========================================");
		System.out.println("INFORMACION DEL VEHICULO");
		System.out.println("===========================================");
		System.out.println("MARCA: " + vehiculoCond.getMarca() +
				" -- Color: " + vehiculoCond.getColor() +
				" -- Num.Plazas: " + vehiculoCond.getPlazas());
		
	}
	
/*		
 * CON ESTE MAIN SACO LA LISTA DE VIAJES DADOS DE ALTA POR CONDUCTOR
 * public static void main(String[] args) {
			
			ViajeStore v = new ViajeStore();
			List<Viaje> l = v.getViajes();
			for(Viaje via:l){
				String viajeAnulado="VIAJE ACTUALMENTE ANULADO";
				if(via.getAnulado())
					viajeAnulado="VIAJE ESTA ACTUALMENTE ACTIVO";					
					
				System.out.println(via.getViajeID()+ " - " + via.getOrigen() 
						+ " - " + via.getDestino() 
						+ " - " + via.getFecha()
						+ " - " + viajeAnulado );
						
			}
			
			
			
		}*/
	
	


}

