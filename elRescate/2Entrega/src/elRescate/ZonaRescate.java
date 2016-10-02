package elRescate;

public class ZonaRescate extends Elemento {
	
	private static final int ANCHO_ZONA_RESCATE = 20;
	private static final int ALTO_ZONA_RESCATE = 20;
	
	//TODO esto tendria que ser en el centro del escenario
	//TODO Luciano: si 0 < x < 100 y 0 < y < 100, creo yo que el centro debería ser el P = (50, 50)
	private static final int X_ZONA_RESCATE = 1;
	private static final int Y_ZONA_RESCATE = 1;
	
	public ZonaRescate(){
		//la zona de rescate se crea en un solo punto
		super(new Tamanio(ANCHO_ZONA_RESCATE, ALTO_ZONA_RESCATE), 
				new Posicion(X_ZONA_RESCATE, Y_ZONA_RESCATE));
		
	}
	
	public Persona rescatarPerson(){
		//TODO Luciano: acá lo mismo que el los refugios (contador de personas)
		return new Persona();
	}
	
}
