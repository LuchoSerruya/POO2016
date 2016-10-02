package elRescate;

public abstract class Elemento {
	private Tamanio tam;
	private Posicion pos;
	
	
	
	/* hace falta setPos?? pablo: creo que hace falta!
	 * cómo sería el tema para moverse???
	 */
	
	public Tamanio getTam() {
		return tam;
	}

	public Posicion getPos() {
		return pos;
	}	
	
	public void setPos(Posicion posicion){
		this.pos = posicion;
	}
	public void jugar(){
		
	}
	
	public void destruir(){
		
	}
	
	public void chocarElemento(Elemento elem){
		
	}
	
	public boolean estaVivo(){
		return true;
	}
	
	public Elemento(int ancho, int alto, int x, int y){
		tam = new Tamanio(ancho, alto);
		pos = new Posicion(x, y);
	}
	
	public Elemento(Tamanio tamanio, Posicion posicion){
		this(tamanio.getAncho(), tamanio.getAlto(), posicion.getX(), posicion.getY());
	}
	
	public Elemento(Tamanio tamanio, int x, int y){
		this(tamanio.getAncho(), tamanio.getAlto(), x, y);		
	}
	
	public Elemento(int ancho, int alto, Posicion posicion){
		this(ancho, alto, posicion.getX(), posicion.getY());
	}

	
}
