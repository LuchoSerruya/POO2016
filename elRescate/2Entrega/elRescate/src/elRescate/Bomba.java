package elRescate;

/**
 * Bomba a ser lanzada
 *
 */
public class Bomba extends Movible {
	
	private int danio;
	
	private Elemento duenio;
	
	//tamaño de la bomba
	private static final int ANCHO_BOMBA = 6;
	private static final int ALTO_BOMBA = 6;
	
	//velocidad inicial de la bomba
	private static final double VELOCIDAD_BOMBA = 2;
	
	//daño de la bomba
	private static final int DANIO_BOMBA = 5;
	
	//si la bomba ha explotado
	private boolean explotada;
	
	/**
	 * Crea una bomba, y la lanza direccion igual a la que apuntaba quién la lanzó
	 * @param posicion Posicion de su lanzante
	 */
	public Bomba(Posicion posicion, Elemento duenio, double direccion){
		super(new Tamanio(ANCHO_BOMBA, ALTO_BOMBA), posicion);
		this.setVelocidad(VELOCIDAD_BOMBA);
		this.setDanio(DANIO_BOMBA);
		this.setDireccion(direccion);
		
		this.duenio = duenio;
	}
	
	/**
	 * @param danio Daño que produce la bomba
	 */
	public void setDanio(int danio){
		this.danio = danio;
	}
	
	/**
	 * 
	 * @return Daño que produce la bomba
	 */
	public int getDanio(){
		return this.danio;
	}
	
	/**
	 * 
	 * @return duenio de la bomba
	 */
	public Elemento getDuenio() {
		return this.duenio;
	}
	
	
	/**
	 * Forma particular de avanzar de la bomba. A medida que avanza, va perdiendo velocidad
	 */
	@Override
	public void avanzar(double velocidad) {
		//si la bomba todavía posee velocidad
		if(this.getVelocidad()>0.5){
			super.avanzar(velocidad);
			this.setVelocidad(this.getVelocidad() - 0.01);
		}
		else{
			//si se quedó sin velocidad, tiene que explotar
			this.explotar();
		}
	}

	/**
	 * Explosión de la bomba, esta agranda su tamaño
	 * y afecta a los elementos con los que colisione
	 */
	public void explotar() {
		//conseguimos su tamaño actual
		if(!this.explotada){
		Tamanio tamanioBomba = this.getTam();
		
		//lo modificamos
		tamanioBomba.setAlto(tamanioBomba.getAlto() * 10);
		tamanioBomba.setAncho(tamanioBomba.getAncho() * 10);
		
		//se lo otorgamos
		this.setTam(tamanioBomba);
		this.explotada = true;
		this.setExiste(false);
		}
	}
	
	/**
	 * Qué realiza la bomba en un turno
	 */
	public void jugar(){
		this.avanzar(this.getVelocidad());
	}
	
	/**
	 * Inidica si la bomba explotó o no
	 * @return true si la bomba esta explotando
	 */
	public boolean haExplotado(){
		return this.explotada;
	}
	
	
	@Override
	public void chocarBonus(Bonus bonus) {
		super.chocarBonus(bonus);
		
		bonus.darBonus(this.getDuenio());
	}
	/**
	 * Comportamiento de la bomba al chocar con un elemento
	 * @param elem Elemento con el que chocó
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		elem.chocarBomba(this);
		Robot robot = (Robot)this.getDuenio();
		//si se choca con quien la lanzo, no explota
		if ((elem != this.getDuenio()) && (elem != robot.getRadar())){
			this.explotar();
		}
		
		/*
		 * 
		 * TODO BORRAR LO COMENTADO 
		 * 
		 */
		
		/* La bomba al chocar con cualquier cosa, se destruirá.
		 * Aquellos que choquen con la bomba, en caso de tener escudo
		 * deben encargarse de generarse el daño a sí mismos.
		 * Así unificamos el comportamiento de la bomba
		 
		if(elem instanceof Bonus){
			((Bonus)elem).darBonus(duenio);
		}
		
		this.explotar();*/
	}
}
