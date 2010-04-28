package mainSesion3;

import java.util.List;

import domain.Viaje;
import domain.ViajeStore;

public class MainPACOMORENTE {

	/**
	 * @param args
	 */
		
		public static void main(String[] args) {
			
			ViajeStore v = new ViajeStore();
			List<Viaje> l = v.getViajes();
			for(Viaje via:l){
				String viajeAnulado="VIAJE ACTUALMENTE ANULADO";
				if(via.getAnulado())
					viajeAnulado="VIAJE ESTÁ ACTUALMENTE ACTIVO";					
					
				System.out.println(via.getViajeID()+ " - " + via.getOrigen() 
						+ " - " + via.getDestino() 
						+ " - " + via.getFecha()
						+ " - " + viajeAnulado );
						
			}
			
			
			
		}


}

