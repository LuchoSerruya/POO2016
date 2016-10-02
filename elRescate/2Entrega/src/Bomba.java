package elRescate;

public class Bomba extends Movible {
	private int danio;
	
	//tamaño de la municion
	private static final int ANCHO_BOMBA = 3;
	private static final int ALTO_BOMBA = 3;
	
	//velocidad inicial de la bomba
	private static final double VELOCIDAD_BOMBA = 10.0;
	
	//daño de la bomba
	private static final int DANIO_BOMBA = 10;
	
	
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
