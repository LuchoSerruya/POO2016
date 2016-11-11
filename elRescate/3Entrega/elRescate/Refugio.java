package elRescate;

import java.util.EmptyStackException;
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
	
	private Stack<Persona> listaPersonas;

	private int cantidadRefugiados;
	
	
	
	/**
	 * Crea un refugio con un tamanio fijo en una posición indicada
	 * @param posicion
	 */
	public Refugio(Posicion posicion){
		super(new Tamanio(Config.ANCHO_REFUGIO, Config.ALTO_REFUGIO), posicion);
		
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
		try{
			Persona salvado = listaPersonas.peek();
			listaPersonas.pop();
			cantidadRefugiados--;
			return salvado;
		}catch(EmptyStackException e){
			return null;
		}
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
		elem.chocarRefugio(this);
		
		
	}
	
	@Override
	public String toString() {
		return String.format("Cantidad rescatados:\n %d",this.getCantidadRefugiados());
	}
	
}
