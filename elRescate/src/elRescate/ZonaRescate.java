package elRescate;

public class ZonaRescate extends Elemento {
	
	private static int ANCHO_ZONA_RESCATE = 20;
	private static int ALTO_ZONA_RESCATE = 20;
	
	//TODO esto tendria que ser en el centro del escenario
	private static int X_ZONA_RESCATE = 1;
	private static int Y_ZONA_RESCATE = 1;
	
	public ZonaRescate(){
		//la zona de rescate se crea en un solo punto
		super(new Tamanio(ANCHO_ZONA_RESCATE, ALTO_ZONA_RESCATE), 
				new Posicion(X_ZONA_RESCATE, Y_ZONA_RESCATE));
		
	}
	
	public Persona rescatarPerson(){
		return new Persona();
	}
	
}
