package elRescate;

public class Municion extends Movible {
	private int danio;
				
	private Elemento duenio;
	//esto mas que un Elemento tendria que ser un Robot/Satelite
	
	//tamaño de la municion
	private static final int ANCHO_MUNICION = 3;
	private static final int ALTO_MUNICION = 3;
	
	//velocidad de la municion
	private static final double VELOCIDAD_MUNICION = 10;
	
	//danio de la municion
	private static final int DANIO_MUNICION = 10;
	
	/**
	 * Crea la munición en la posicip
	 * @param posicion
	 */
	public Municion(Posicion posicion, Elemento duenio, double direccion){
		super(new Tamanio(ANCHO_MUNICION,ALTO_MUNICION), posicion);
		this.setDanio(DANIO_MUNICION);
		this.setVelocidad(VELOCIDAD_MUNICION);
		this.duenio = duenio;
		//le damos la dirección del que la lanzó
		//TODO LA DIRECCION MABEL
		this.setDireccion(direccion);
	}

	
	/**
	 * Setea el daño causado por la munición
	 * @param danio
	 */
	public void setDanio(int danio){
		this.danio = danio;
	}
	
	/**
	 * Retorna el daño que causa la munición
	 * @return daño causado por la municion
	 */
	public int getDanio(){
		return this.danio;
	}
	
	/**
	 * Comportamiento de la Munición al jugar. Sólo avanza
	 */
	@Override
	public void jugar() {
		this.avanzar(this.getVelocidad());
	}
	
	
	/**
	 * Comportamiento de la Munición al chocar otro elemento.
	 * Se destruye
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		//TODO preguntar cómo se van a implementar los equipos
		//Si me choco con el que me lanzó, no hago nada		
		this.setExiste(false);
	}
	

	
	
	/**
	 * @return dueño de la Munción
	 */
	public Elemento getDuenio() {
		return this.duenio;
	}
}
