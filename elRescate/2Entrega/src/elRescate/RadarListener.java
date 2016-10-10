package elRescate;

import java.util.ArrayList;
//Para ser observador hay que implementar una interface
public interface RadarListener {
	void elementosDetectado(ArrayList<Elemento> elementos);
}
