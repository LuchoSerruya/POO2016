package elRescate;

public class Municion extends Movible {
	private int danio;
				
	private Robot robot;
	
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
	public Municion(Posicion posicion, Robot duenio){
		super(new Tamanio(ANCHO_MUNICION,ALTO_MUNICION), posicion);
		this.setDanio(DANIO_MUNICION);
		this.setVelocidad(VELOCIDAD_MUNICION);
		this.robot = duenio;
		//le damos la dirección del que la lanzó
		this.setDireccion(duenio.getDireccion());
		//TODO ver de solucionar lo del dueño de la munición
	}
	
	public void setDanio(int danio){
		this.danio = danio;
	}
	
	public int getDanio(){
		return this.danio;
	}
	
	/**
	 * Comportamiento de la Munición al jugar
	 */
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		this.avanzar();
	}
	
	/**
	 * Comportamiento de la Munición al chocar otro elemento.
	 * Se destruye
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		// TODO Auto-generated method stub
		this.destruir();
	}
}
