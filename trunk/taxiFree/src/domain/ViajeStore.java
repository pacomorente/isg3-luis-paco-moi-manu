package domain;

import java.util.Iterator;
import java.util.List;

import data.JDBCViajeDAO;

/**
 * @author  PACO
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
    private List viajes;

    public static synchronized ViajeStore getInstance() {
        if (vs == null)
            vs = new ViajeStore();
        return vs;
    }

    private ViajeStore() {
        viajes = (new JDBCViajeDAO()).selectAllViajes();
    }

    /**
	 * @return
	 * @uml.property  name="viajes"
	 */
    public List getViajes() {
        return viajes;
    }

    public Viaje getViajes(String viajeID) {
        Viaje result = null;
        for (Iterator iter = viajes.iterator(); iter.hasNext();) {
            Viaje v = (Viaje) iter.next();
            if (v.getViajeID().compareTo(viajeID) == 0) {
                result = v;
            }
        }
        return result;
    }
}
