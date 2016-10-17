package elRescate;

import java.util.Stack;
/**
 * Refugia a donde se llevan las personas recartadas. Tener en cuenta que antes 
 * de hacer un {@link Refugio#quitarPersona()} se debe verificar la cantidad de 
 * refugiados con {@link Refugio#getCantidadRefugiados()} y realizarlo si 
 * la cantidad es > 0.
 * 
 *
 */
public class Refugio extends Elemento {

	private static final int ANCHO_REFUGIO = 10;
	private static final int ALTO_REFUGIO = 10;
	
	Stack<Persona> listaPersonas;
	
	private int cantidadRefugiados;
	
	
	/**
	 * Crea un refugio con un tamanio fijo en una posición indicada
	 * @param posicion
	 */
	public Refugio(Posicion posicion){
		super(new Tamanio(ANCHO_REFUGIO, ALTO_REFUGIO), posicion);
		
		//lista de personas
		listaPersonas = new Stack<Persona>();
		
		this.cantidadRefugiados = 0;
	}
	
	/**
	 * Devuelve la cantidad de refugiados
	 * @return Cantidad de refugiados
	 */
	public int getCantidadRefugiados(){
		return this.cantidadRefugiados;
	}
	/**
	 * Se extrae una persona del refugio
	 * @return
	 */
	public Persona quitarPersona(){
		Persona salvado = listaPersonas.peek();
		listaPersonas.pop();
		cantidadRefugiados--;
		return salvado;
	}
	
	/**
	 * Recibe una persona rescatada
	 * @param persona persona a rescatar
	 */
	public void salvarPersona(Persona persona){
		listaPersonas.push(persona);
		cantidadRefugiados++;
	}
	
	/**
	 * Comportamiento del Refugia al ser chocado. Si un robot enemigo lo atraviesa, 
	 * el Refugio pierde una persona. Si un robot amigo lo hace y tenía una persona
	 * ésta se agrega al Refugio
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		//TODO implementar el rescate o perdida de personas (equipos)
		if(elem instanceof Robot){
			Robot robot = (Robot)elem;
			
			//Si el Robot esta llevando una persona y si soy el refugio de ese Robot
			//Recibimos su persona
			if((robot.llevandoPersona()) && (this == robot.getEquipo().getRefugio())){
				this.salvarPersona(robot.entregarPersona());
			} else {
				//Si no se cumple la condicion de arriba, nos roban una persona del refugio
				robot.cargarPersona(this.quitarPersona());
				//Aplicar penalidad
			}
		}
	}
	
}
