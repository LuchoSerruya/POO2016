package elRescate;

import java.util.ArrayList;
//Para ser observador hay que implementar una interface
/**
 * Interfaz a implementar para escuchar un Radar
 * 
 *
 */
public interface RadarListener {
	void elementosDetectado(ArrayList<Elemento> elementos);
}
