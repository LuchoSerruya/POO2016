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
	 * Constructor de dos parametros, recibe el tamaño y la posicón como dos objetos
	 * @param tamanio Tamaño del elemento
	 * @param posicion Posición del elemento
	 */
	public Elemento(Tamanio tamanio, Posicion posicion){
		this.tam = tamanio;
		this.pos = posicion;
		this.existe = true;
		
		Escenario.getEscenario().agregarElemento(this);
	}
	
	
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

		this.existe = false;
	}
	
	/**
	 * Qué ejecutar cuando el elemento choca con otro
	 * @param elem Elemento con quién choca
	 */
	public abstract void chocarElemento(Elemento elem);
	
	/**
	 * Comportamiento al chocar un robot
	 * @param robot
	 */
	public void chocarRobot(Robot robot){}
	
	/**
	 * Comportamiento al chocar una Municion
	 * @param municion
	 */
	public void chocarMunicion(Municion municion){}
	
	/**
	 * Comportamiento al chocar una bomba 
	 * @param bomba
	 */
	public void chocarBomba(Bomba bomba){}
	
	/**
	 * Comportamiento al chocar un satelite
	 * @param satelite
	 */
	public void chocarSatelite(Satelite satelite){}
	
	/**
	 * Comportamiento al chocar un refugio
	 * @param refugio
	 */
	public void chocarRefugio(Refugio refugio){}
	
	/**
	 * Comportamiento al chocar una zona de Rescate
	 * @param zonaRescate
	 */
	public void chocarZonaRescate(ZonaRescate zonaRescate){}
	
	/**
	 * Comportamiento al chocar un bonus
	 * @param bonus
	 */
	public void chocarBonus(Bonus bonus){}
	
	/**
	 * @return true si el elemento está vivo, false si no
	 */
	public boolean estaVivo(){
		return this.existe;
	}
	
	
	/**
	 * Indica la posicion (X, Y) del elemento
	 */
	@Override
	public String toString() {
		return String.format("X: %d | Y: %d", this.getPos().getX(), this.getPos().getY());
	}
	
	/**
	 * Indica si el elemento esta fuera del escenario
	 * @return True si esta fuera de los limites del escenario, false si esta dentro del escenario
	 */
	public boolean fueraDeEscenario(){
		return ((this.getPos().getX() <= Config.MIN_X + 10) || (this.getPos().getX() >= Config.MAX_X - 10) ||
				(this.getPos().getY() <= Config.MIN_Y + 10) || (this.getPos().getY() >= Config.MAX_Y - 10));
	}
	
	
}
