package elRescate;

public class Bomba extends Movible {
	private int danio;
	
	//tamaño de la municion
	private static int ANCHO_BOMBA = 3;
	private static int ALTO_BOMBA = 3;
	
	//velocidad inicial de la bomba
	private static double VELOCIDAD_BOMBA = 10;
	
	//daño de la bomba
	private static int DANIO_BOMBA = 10;
	
	
	public Bomba(Posicion posicion){
		super(new Tamanio(ANCHO_BOMBA, ALTO_BOMBA), posicion);
		this.setVelocidad(VELOCIDAD_BOMBA);
		this.setDanio(DANIO_BOMBA);
	}
	
	public void setDanio(int danio){
		this.danio = danio;
	}
	
	@Override
	public void avanzar() {
		// TODO averigua como manejamos el tema de la velocidad y su disminucion
		super.avanzar();
	}
	
	
}
