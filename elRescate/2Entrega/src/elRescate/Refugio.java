package elRescate;

public class Refugio extends Elemento {

	private static final int ANCHO_REFUGIO = 10;
	private static final int ALTO_REFUGIO = 10;
	
	/*TODO determinar que coleccion vamos a usar 
	 * para almacenar las personas (Pablo sugiere arrayList)
	 * */

	//TODO Luciano: Bogliacino dijo que vamos a usar un arrayList; 
	//dijo que en ocasiones particulares vamos a usar alguna colección distinta a un arrayList
	
	public Refugio(Posicion posicion){
		super(new Tamanio(ANCHO_REFUGIO, ALTO_REFUGIO), posicion);
		//inicializar coleccion de personas
	}
	
	public Refugio(int x, int y){
		this(new Posicion(x,y));
	}
	
	
	public Persona quitarPersona(){
		/*tramoya con la coleccion para quitar una persona,
		 * por ahora tiene esto para que no chille el compilador
		 * */

		//Luciano: yo creo que podríamos ir llevando un contador de cantidad de personas que tiene el refugio, 
		//e ir decrementado o incrementándolo de acuerdo a la situación
		return new Persona();
	}
	/**
	 * @param persona persona a rescatar
	 */
	public void salvarPersona(Persona persona){
		/*
		 * Agregamos persona a la coleccion
		 * */
	}
	
	
}
