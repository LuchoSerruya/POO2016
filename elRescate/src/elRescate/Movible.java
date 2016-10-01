package elRescate;

public class Movible extends Elemento {	
	private double direccion;
	
	//TODO revisar si esto es un int o un double
	private double velocidad;
	
	private static double VELOCIDAD_DEFECTO = 10;
	
	
	/**
	 * 
	 * @param tamanio objeto tamanio para crear el elemento
	 * @param posicion objeto que contiene la posicion en donde crear el movible
	 */
	public Movible(Tamanio tamanio, Posicion posicion){
		super(tamanio, posicion);
		this.direccion = 0;
		this.velocidad = 0;
	}
	
	/**.
	 * @param ancho ancho del Movible
	 * @param alto	alto del movible
	 * @param x		coordenada x 
	 * @param y		coordenada y
	 */
	public Movible(int ancho, int alto, int x, int y){
		this(new Tamanio(ancho, alto), new Posicion(x,y));
	}
	
	/**
	 * Por ahora esta como x++ y++
	 * TODO reveer Movible.avanzar!
	 * TODO fijarse la relacion entre esto y la velocidad con la direccion
	 */
	public void avanzar(){
		//consigo la posicion actual
		Posicion posicionMovible = this.getPos();
		
		//modifico la posicion
		posicionMovible.setX(posicionMovible.getX() + 1);
		posicionMovible.setY(posicionMovible.getY() + 1);
		
		//le doy la posicion que manipule
		this.setPos(posicionMovible); 		
	}
	
	public double getVelocidad(){
		return this.velocidad;
	}
	
	public double getDireccion(){
		return this.direccion;
	}
	
	public void setVelocidad(double velocidad){
		this.velocidad = 0;
		
		if(velocidad > 0){
			this.velocidad = velocidad;
		}
	}
	
	public void setDireccion(double direccion){
		this.direccion = 0;
		
		if(direccion > 0){
			this.direccion = direccion;
		}
	}
	
}
