package elRescate;

public class Tamanio {
	
	public static final int MAX_ANCHO = 10;
	public static final int MIN_ANCHO = 1;
	public static final int MAX_ALTO = 10;
	public static final int MIN_ALTO = 1;
	
	private int ancho = MIN_ANCHO;
	private int alto = MIN_ALTO;
	
	public int getAncho(){
		return ancho;
	}
	
	public int getAlto(){
		return alto;
	}
	
	public void setAncho(int ancho){
		if(ancho >= MIN_ANCHO && ancho <= MAX_ANCHO)
			this.ancho = ancho;
	}

	public void setAlto(int alto){
		if(alto >= MIN_ALTO && alto<= MAX_ALTO)
			this.alto = alto;
	}
	
	public Tamanio(int ancho, int alto){
		this.setAlto(alto);
		this.setAncho(ancho);
	}
	
	public Tamanio(){
		this(MIN_ANCHO, MIN_ALTO);
	}
}
