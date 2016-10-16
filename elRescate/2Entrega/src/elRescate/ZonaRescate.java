package elRescate;
/**
 * Zona central de escenario donde se encuentran las personas a rescatar
 */
public class ZonaRescate extends Elemento {
	
	//Constantes de tamaño del rescate
	private static final int ANCHO_ZONA_RESCATE = 10;
	private static final int ALTO_ZONA_RESCATE = 10;
	
	//TODO esto tendria que ser en el centro del escenario
	//TODO Luciano: si 0 < x < 100 y 0 < y < 100, creo yo que el centro debería ser el P = (50, 50)
	private static final int X_ZONA_RESCATE = (Posicion.MAX_X)/2;
	private static final int Y_ZONA_RESCATE = (Posicion.MAX_Y)/2;
	
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
		return new Persona();
	}
	
	/**
	 * Comportamiento de la Zona de Rescate, si un robot la atraviesa
	 * Este le da una persona a ese robot
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		if(elem instanceof Robot){
			Robot robot = (Robot)elem;
			robot.cargarPersona(this.rescatarPersona());
		}
		
	}
}
