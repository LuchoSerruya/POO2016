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
	 * @return Posicioón del elemento
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
	public abstract void jugar();
	
	/**
	 * Destruir el elemento
	 */
	public void destruir(){
		this.existe = false;
	}
	
	/**
	 * Qué ejecutar cuando el elemento choca con otro
	 * @param elem Elemento con quién choca
	 */
	public abstract void chocarElemento(Elemento elem);
	
	/**
	 * @return true si el elemento está vivo, false si no
	 */
	public boolean estaVivo(){
		return this.existe;
	}
	
	/**
	 * Constructor de cuatro parametros, tamaño y posicion dato por dato
	 * @param ancho Ancho del elemento a crear
	 * @param alto Alto del elemento a crear
	 * @param x Coordenada x del elemento a crear
	 * @param y Coordenada y del elemento a crear
	 */
	public Elemento(int ancho, int alto, int x, int y){
		tam = new Tamanio(ancho, alto);
		pos = new Posicion(x, y);
		this.existe = true;
	}
	
	/**
	 * Constructor de dos parametros, recibe el tamaño y la posicón como dos objetos
	 * @param tamanio Tamaño del elemento
	 * @param posicion Posición del elemento
	 */
	public Elemento(Tamanio tamanio, Posicion posicion){
		this(tamanio.getAncho(), tamanio.getAlto(), posicion.getX(), posicion.getY());
	}
	
	/**
	 * Recibe el Tamaño como objeto y la posición como coordenadas sueltas
	 * @param tamanio Tamaño del elemento
	 * @param x Coordenada x del elemento
	 * @param y Coordenada y del elemento
	 */
	public Elemento(Tamanio tamanio, int x, int y){
		this(tamanio.getAncho(), tamanio.getAlto(), x, y);		
	}
	
	/**
	 * Construcro que recibe el Tamaño como datos de alto y ancho. La Posición como objeto
	 * @param ancho Ancho del elemento
	 * @param alto Alto de elemento
	 * @param posicion Posición del elemento
	 */
	public Elemento(int ancho, int alto, Posicion posicion){
		this(ancho, alto, posicion.getX(), posicion.getY());
	}

	
}
