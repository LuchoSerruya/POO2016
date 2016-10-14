package elRescate;
import java.lang.Math;

public abstract class Movible extends Elemento {
	
	private double direccion;
	
	//velocidad a la que se mueve
	private double velocidad;
	
	//Velocidad por defecto
	private static final double VELOCIDAD_DEFECTO = 10;
	
	
	/**
	 * Constructor que recibe los dos objetos
	 * @param tamanio Objeto Tamaño para crear el elemento
	 * @param posicion objeto que contiene la posicion en donde crear el movible
	 */
	public Movible(Tamanio tamanio, Posicion posicion){
		super(tamanio, posicion);
		this.direccion = 0;
		this.velocidad = 0;
		
		this.setVelocidad(VELOCIDAD_DEFECTO);
	}
	
	
	/**
	 * Realiza el movimiento del Movible
	 */
	public void avanzar(double velocidad){
		//consigo la posicion actual
		Posicion posicionMovible = this.getPos();
		
		//le damos velocidad dada por parametro
		this.setVelocidad(velocidad);
		
		//modifico la posicion utilizando los deltas
		posicionMovible.setX((int)(posicionMovible.getX() +  deltaX(this.getVelocidad(),this.getDireccion())));
		posicionMovible.setY((int)(posicionMovible.getY() + deltaY(this.getVelocidad(),this.getDireccion())));

		//le doy la posicion que manipule
		this.setPos(posicionMovible); 		
	}
	
	//coseguimos el delta X para la velocidad
	static double deltaX(double radio,double angulo) {
		return radio * Math.cos(angulo);
	}

	//Conseguimos el delta Y para la velocidad
	static double deltaY(double radio, double angulo) {
		return radio * Math.sin(angulo);
	}
	
	/**
	 * Devulve la velocidad
	 * @return Velocidad del movible
	 */
	public double getVelocidad(){
		return this.velocidad;
	}
	
	/**
	 * Devuelve la dirección del movible
	 * @return Dirección del Movible
	 */
	public double getDireccion(){
		return this.direccion;
	}
	
	/**
	 * Setea la velocidad
	 * @param velocidad Velocidad a darle al Movible
	 */
	public void setVelocidad(double velocidad){
		this.velocidad = 0;

		if(velocidad > 0){
			this.velocidad = velocidad;
		}
	}
	
	/**
	 * Setea la dirección del Movible
	 * @param direccion Dirección a darle al movible
	 */
	public void setDireccion(double direccion){
		/* De esta mananera si se le da una dirección 
		 * que supere los 360 grados, esta se mantiene 
		 * en el rango de 0 a 360 */
		this.direccion = direccion % 361;
	}
	
	/**
	 * Dado un elemento, da la dirección en la que hay que 
	 * posicionarse para apuntar al elemento pasado por
	 * parámetro
	 * @param elemento elemento al que se debe apuntar
	 * @return ángulo en el cual posicionarse
	 */
	public double apuntar(Elemento elemento){
		
		/*
		 * Generamos dos puntos que actuarán de vectores 
		 * para despues buscar el ángulo entre ellos
		 */
		Posicion p1 = new Posicion(0,this.getPos().getY());
		Posicion p2 = elemento.getPos();
		
		/*
		 * Con este choclo obtenemos el coseno del
		 * ángulo entre ambos vectores
		 */
		double aux = 
				(p1.getX()*p2.getX() + p1.getY()*p2.getY())/
				(Math.sqrt(Math.pow(p1.getX(),2)+Math.pow(p1.getY(), 2))+
						Math.sqrt(Math.pow(p2.getX(),2))+Math.pow(p2.getY(), 2));
		
		//Devolvemos el arco seno del ángulo
		return Math.acos(aux);

		
	}
}
