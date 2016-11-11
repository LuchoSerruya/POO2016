package elRescate;
/**
 * Zona central de escenario donde se encuentran las personas a rescatar
 */
public class ZonaRescate extends Elemento {
	
	/**
	 * Constructor de la zona de rescate; va a ser fija, no recibe parámetros
	 */
	public ZonaRescate(){
		//la zona de rescate se crea en un solo punto
		super(new Tamanio(Config.ANCHO_ZONA_RESCATE, Config.ALTO_ZONA_RESCATE), 
				new Posicion(Config.X_ZONA_RESCATE, Config.Y_ZONA_RESCATE));
		
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
		elem.chocarZonaRescate(this);

		
	}
}
