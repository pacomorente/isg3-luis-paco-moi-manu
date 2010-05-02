package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Grafo.Graph;
import Grafo.GraphImpl;
import Grafo.Node;
import Grafo.NodeData;
import data.JDBCViajeDAO;

/**
 * @author               PACO
 * @uml.dependency   supplier="domain.GraphImpl"
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




	/**
	 * @uml.property  name="viajes"
	 */
	private List<Viaje> viajes;

    public ViajeStore() {
        viajes = (new JDBCViajeDAO()).selectAllViajes();
    }

    /**
	 * @return
	 * @uml.property  name="viajes"
	 */
    public List<Viaje> getViajes() {
		return viajes;
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

    public Graph getViajesG(String viajeID) {
    	Graph graf = new GraphImpl();
    	Node nodo = (Node) new NodeData();
    	List<String> trayecto = new ArrayList<String>();
        for (Iterator<Viaje> iter = viajes.iterator(); iter.hasNext();) {
            Viaje v = (Viaje) iter.next();
            if (v.getOrigen()!=null) {
            	trayecto.add(v.getOrigen());
            }
            if (v.getPuntosInt01()!=null) {
            	trayecto.add(v.getPuntosInt01());
            }
            if (v.getPuntosInt02()!=null) {
            	trayecto.add(v.getPuntosInt02());
            }
            if (v.getPuntosInt03()!=null) {
            	trayecto.add(v.getPuntosInt03());
            }
            if (v.getDestino()!=null) {
            	trayecto.add(v.getDestino());
            }
        }
        
        graf.add(trayecto);
        return graf;

        
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
