package elRescate;

public class ZonaRescate extends Elemento {
	
	/**
	 * Zona central del escenario (aquí se encontrarán las personas a rescatar)
	 */
	
	//Constantes de tamaño del rescate
	private static final int ANCHO_ZONA_RESCATE = 10;
	private static final int ALTO_ZONA_RESCATE = 10;
	
	//TODO esto tendria que ser en el centro del escenario
	//TODO Luciano: si 0 < x < 100 y 0 < y < 100, creo yo que el centro debería ser el P = (50, 50)
	private static final int X_ZONA_RESCATE = 1;
	private static final int Y_ZONA_RESCATE = 1;
	
	/**
	 * Constructor de la zona de rescate; va a ser fija, no recibe parámetros
	 */
	public ZonaRescate(){
		//la zona de rescate se crea en un solo punto
		super(new Tamanio(ANCHO_ZONA_RESCATE, ALTO_ZONA_RESCATE), 
				new Posicion(X_ZONA_RESCATE, Y_ZONA_RESCATE));
		
	}
	
	/**
	 * Se rescata una persona de la zona de rescate
	 * @return devuelve una persona rescatada
	 */
	public Persona rescatarPersona(){
		//TODO Luciano: acá lo mismo que el los refugios (contador de personas)
		return new Persona();
	}
	
}
