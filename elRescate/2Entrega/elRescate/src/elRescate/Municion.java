package elRescate;


public class Municion extends Movible {
	private int danio;
	
	//esto mas que un Elemento tendria que ser un Robot/Satelite
	private Elemento duenio;
	
	
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
		//se mueve o se destruye si se fue del escenario
		if(!(this.fueraDeEscenario()))
			this.avanzar(this.getVelocidad());
		else{
			this.setExiste(false);
		}
	}
	
	
	/**
	 * Comportamiento de la Munición al chocar otro elemento.
	 * Se destruye
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		this.setExiste(false);
		/*
		 * Si la municion se choca contra un bonus,
		 * le pasamos la referencia al duenio de la municion
		 * al bonus
		 */ 
		if(elem instanceof Bonus){
			Bonus bonus = (Bonus) elem;
			bonus.darBonus(this.getDuenio());
		}
	}
	

	
	
	/**
	 * @return dueño de la Munción
	 */
	public Elemento getDuenio() {
		return this.duenio;
	}
	
	
	@Override
	public String toString() {
		
		return String.format("%s Munición", super.toString());
	}
}
