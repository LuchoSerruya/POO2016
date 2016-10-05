package elRescate;

public class Satelite extends Elemento {


	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	private static final int ESCUDO_INICIAL = 50;
	private final static int ANCHO_SATELITE = 3;
	private final static int ALTO_SATELITE = 3;
	
	/**
	 * Crea un satélite con un tamanio fijo en la posición indicada. Tiene un nivel de escudo inicial predeterminado
	 * @param posicion
	 */
	public Satelite(Posicion posicion){
		super(new Tamanio(ANCHO_SATELITE, ALTO_SATELITE), posicion);
		radar = new Radar(this.getPos());
		setNivelEscudo(ESCUDO_INICIAL); 
	}
	
	/**
	 * Setea nivel de escudo
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
		if (this.nivelEscudo < 0)
			this.nivelEscudo = 0;
	}
	
	/**
	 * Devuelve el nivel de escudo del satélite
	 * @return
	 */
	public int getNivelEscudo(){
		return this.nivelEscudo;
	}
	
	public int getCantidadMuniciones(){
		return this.cantidadMuniciones;
	}

	public void setCantidadMuniciones(int cantMuniciones){
		this.cantidadMuniciones = cantMuniciones;
		if(this.cantidadMuniciones < 0)
			this.cantidadMuniciones = 0;
	}

	
}
