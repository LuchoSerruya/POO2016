package elRescate;

public class Satelite extends Elemento {

	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	private final static int ESCUDO_INICIAL = 50; 
	
	public Satelite(Tamanio tamanio, Posicion posicion){
		super(tamanio, posicion);
		radar = new Radar(this.getPos());
		setNivelEscudo(ESCUDO_INICIAL); 
	}
	
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
	}
	
	public int getNivelEscudo(){
		return this.nivelEscudo;
	}
	
	public int getCantidadMuniciones(){
		return this.cantidadMuniciones;
	}

	public void setCantidadMuniciones(int cantMuniciones){
		this.cantidadMuniciones = cantMuniciones;
	}

	//TODO implementarMUNICION!!!!!
	
}
