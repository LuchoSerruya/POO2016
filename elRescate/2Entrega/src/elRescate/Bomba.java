package elRescate;
/**
 * Bomba a ser lanzada
 *
 */
public class Bomba extends Movible {
	
	private int danio;
	
	//tamaño de la bomba
	private static final int ANCHO_BOMBA = 3;
	private static final int ALTO_BOMBA = 3;
	
	//velocidad inicial de la bomba
	private static final double VELOCIDAD_BOMBA = 10.0;
	
	//daño de la bomba
	private static final int DANIO_BOMBA = 10;
	
	/**
	 * Crea una bomba, y la lanza direccion igual a la que apuntaba quién la lanzó
	 * @param posicion Posicion de su lanzante
	 */
	public Bomba(Posicion posicion){
		super(new Tamanio(ANCHO_BOMBA, ALTO_BOMBA), posicion);
		this.setVelocidad(VELOCIDAD_BOMBA);
		this.setDanio(DANIO_BOMBA);
	}
	
	/**
	 * Cambiar el daño que produce la bomba
	 * @param danio Daño que produce la bomba
	 */
	public void setDanio(int danio){
		this.danio = danio;
	}
	
	public int getDanio(){
		return this.danio;
	}
	
	/**
	 * Forma particular de avanzar de la bomba
	 */
	@Override
	public void avanzar() {
		//si la bomba todavía posee velocidad
		if(!(this.getVelocidad()==0)){
			//conseguimos la posicion de la bomba
			Posicion posicionBomba = this.getPos();
			
			//modifico la posicion utilizando los deltas
			posicionBomba.setX((int)(posicionBomba.getX() +  this.deltaY()));
			posicionBomba.setY((int)(posicionBomba.getY() + this.deltaX()));
	
			//le doy la posicion que manipule
			this.setPos(posicionBomba);
			this.setVelocidad(this.getVelocidad() - 1);
			
		}
		else{
			//si se quedó sin, tiene que explotar
			this.explotar();
		}
	}

	/**
	 * Explosión de la bomba, esta agranda su tamaño
	 * y afecta a los elementos con los que colisione
	 */
	private void explotar() {
		//conseguimos su tamaño actual
		Tamanio tamanioBomba = this.getTam();
		
		//lo modificamos
		tamanioBomba.setAlto(tamanioBomba.getAlto() * 3);
		tamanioBomba.setAncho(tamanioBomba.getAncho() * 3);
		
//		//se lo otorgamos
		this.setTam(tamanioBomba);
	}
	
	public void jugar(){
		
	}
	
	@Override
	public void chocarElemento(Elemento elem) {
		// TODO Auto-generated method stub
		
	}
}
