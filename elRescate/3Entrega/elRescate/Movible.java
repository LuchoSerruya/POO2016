package elRescate;
import java.lang.Math;

public abstract class Movible extends Elemento {
	
	private double direccion;
	
	//velocidad a la que se mueve
	private double velocidad;
	
	//Velocidad por defecto
	private static final double VELOCIDAD_DEFECTO = 5;
	
	
	/**
	 * Constructor que recibe los dos objetos
	 * @param tamanio Objeto Tamaño para crear el elemento
	 * @param posicion objeto que contiene la posicion en donde crear el movible
	 */
	public Movible(Tamanio tamanio, Posicion posicion){
		super(tamanio, posicion);
		this.setDireccion(0);
		
		this.setVelocidad(VELOCIDAD_DEFECTO);
	}
	
	
	/**
	 * Realiza el movimiento del Movible
	 */
	public void avanzar(){
		//consigo la posicion actual
		Posicion posicionMovible = this.getPos();
		//modifico la posicion utilizando los deltas
		posicionMovible.setX((int)(posicionMovible.getX() +  deltaX(this.getVelocidad(),this.getDireccion())));
		posicionMovible.setY((int)(posicionMovible.getY() - deltaY(this.getVelocidad(),this.getDireccion())));

		//le doy la posicion que manipule
		this.setPos(posicionMovible); 		
	}
	
	/**
	 * coseguimos el delta X para la velocidad
	 * @param radio
	 * @param angulo
	 * @return delta X del triangulo
	 */
	public static double deltaX(double radio,double angulo) {
		angulo = Math.toRadians(angulo);
		return radio * Math.cos(angulo);
	}

	/**
	 * coseguimos el delta Y para la velocidad
	 * @param radio
	 * @param angulo
	 * @return delta Y del triangulo
	 */
	public static double deltaY(double radio, double angulo) {
		angulo = Math.toRadians(angulo);
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
		this.direccion = direccion % 360;
	}
	
	
}
