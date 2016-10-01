package elRescate;

public class Municion extends Movible {
	private int danio;
	
	//WATISDIS? |
	//			V
	//private Robot robot
	
	//tamaño de la municion
	private static int ANCHO_MUNICION = 3;
	private static int ALTO_MUNICION = 3;
	
	//velocidad de la municion
	private static double VELOCIDAD_MUNICION = 10;
	
	//danio de la municion
	private static int DANIO_MUNICION = 10;
	
	public Municion(Posicion posicion){
		super(new Tamanio(ANCHO_MUNICION,ALTO_MUNICION), posicion);
		this.setDanio(DANIO_MUNICION);
		this.setVelocidad(VELOCIDAD_MUNICION);
	}
	
	public void setDanio(int danio){
		this.danio = danio;
	}
	
}
