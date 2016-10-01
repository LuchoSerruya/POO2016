package elRescate;

public class Refugio extends Elemento {

	private static int ANCHO_REFUGIO = 10;
	private static int ALTO_REFUGIO = 10;
	
	/*TODO determinar que coleccion vamos a usar 
	 * para almacenar las personas (Pablo sugiere arrayList)
	 * ionosemira
	 * */
	
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
