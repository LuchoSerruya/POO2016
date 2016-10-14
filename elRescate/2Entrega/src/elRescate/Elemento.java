package elRescate;

/**
 * Elementos que componen el juego
 *
 */
public abstract class Elemento {
	//Tamaño del elemento
	private Tamanio tam;
	//Posicion del mismo en el escenario
	private Posicion pos;
	
	private boolean existe;
	
	/**
	 * @return Tamaño del elemento
	 */
	public Tamanio getTam() {
		return tam;
	}

	/**
	 * @return Posición del elemento
	 */
	public Posicion getPos() {
		return pos;
	}	
	
	/**
	 * @param posicion Posición del elemento
	 */
	public void setPos(Posicion posicion){
		this.pos = posicion;
	}
	
	/**
	 * Le otorga un nuevo tamaño al elemento
	 * @param tamanio Nuevo tamaño del elemento
	 */
	public void setTam(Tamanio tamanio){
		this.tam = tamanio;
	}
	
	/**
	 * Turno del elemento en el juego
	 */
	public void jugar(){
		
	}
	
	/**
	 * Destruir el elemento
	 */
	public void destruir(){
		//Eliminamos el elemento destruido de la lista del escenario
		Escenario.getEscenario().quitarElemento(this);
		//Depende de la implementación para mostrarlos
	}
	
	/**
	 * Qué ejecutar cuando el elemento choca con otro
	 * @param elem Elemento con quién choca
	 */
	public void chocarElemento(Elemento elem){
		
	}
	
	/**
	 * @return true si el elemento está vivo, false si no
	 */
	public boolean estaVivo(){
		return this.existe;
	}
	public void setExiste(boolean existe){
		this.existe = existe;
	}
	
	/**
	 * Constructor de dos parametros, recibe el tamaño y la posicón como dos objetos
	 * @param tamanio Tamaño del elemento
	 * @param posicion Posición del elemento
	 */
	public Elemento(Tamanio tamanio, Posicion posicion){
		this.tam = tamanio;
		this.pos = posicion;
		Escenario.getEscenario().agregarElemento(this);
		this.setExiste(true);
	}
	
	
	
}
