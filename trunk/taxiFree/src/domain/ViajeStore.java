package domain;

import java.util.Iterator;
import java.util.List;

import data.JDBCViajeDAO;

/**
 * @author    PACO
 */
public class ViajeStore {

    /**
	 * @uml.property  name="ps"
	 * @uml.associationEnd  
	 */
    private static ViajeStore vs;

    /**
	 * @uml.property  name="products"
	 */


    public static synchronized ViajeStore getInstance() {
		if (vs == null)
			vs = new ViajeStore();
		return vs;
	}




	private List<Viaje> viajes;

    private ViajeStore() {
        viajes = (new JDBCViajeDAO()).selectAllViajes();
    }

 


    public Viaje getViajes(String viajeID) {
        Viaje result = null;
        for (Iterator<Viaje> iter = viajes.iterator(); iter.hasNext();) {
            Viaje v = (Viaje) iter.next();
            if (v.getViajeID().compareTo(viajeID) == 0) {
                result = v;
            }
        }
        return result;
    }




	/**
	 * @uml.property  name="viaje"
	 */
	private List<Viaje> viaje;

	/**
	 * Getter of the property <tt>viaje</tt>
	 * @return    Returns the viaje.
	 * @uml.property  name="viaje"
	 */
	public List<Viaje> getViaje() {
		return viaje;
	}

	/**
	 * Setter of the property <tt>viaje</tt>
	 * @param viaje    The viaje to set.
	 * @uml.property  name="viaje"
	 */
	public void setViaje(List<Viaje> viaje) {
		this.viaje = viaje;
	}



}
