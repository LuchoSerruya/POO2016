package elRescate;

public class Robot extends Movible {
	private int nivelEscudo;
	private int nivelEnergia;
	private Radar radar;
	private Persona persona;
	private int cantidadMuniciones;
	private int cantidadBombas;
	
	private static final int MUNICIONES_DEFAULT = 100;
	private static final int BOMBAS_DEFAULT = 10;
	private final static int ANCHO_ROBOT = 2;
	private final static int ALTO_ROBOT= 2;
	
	/**
	 * Crea un robot con un tamanio fijo en una posicion indicada. Setea sus valores de cantidad de bombas y municiones a un valor por defecto
	 * @param posicion
	 */
	public Robot(Posicion posicion){
		super(new Tamanio(ANCHO_ROBOT, ALTO_ROBOT), posicion);
		
		setCantidadBombas(BOMBAS_DEFAULT);
		setCantidadMuniciones(MUNICIONES_DEFAULT);
		
		this.radar = new Radar(this.getPos());
	}
	
	public void setCantidadMuniciones(int cantidadMuniciones){
		this.cantidadMuniciones = cantidadMuniciones;
		if(this.cantidadMuniciones < 0)
			this.cantidadMuniciones = 0;
	}
	
	/**
	 * Setea cantidad de bombas del robot
	 * @param cantidadBombas
	 */
	public void setCantidadBombas(int cantidadBombas){
		this.cantidadBombas = cantidadBombas;
		if(this.cantidadBombas < 0)
			this.cantidadBombas = 0;
	}
	
	/**
	 * Devuelve cantidad de municiones del robot
	 * @return
	 */
	public int getCantidadMuniciones(){
		return this.cantidadMuniciones;
	}
	
	/**
	 * Devuelve cantidad de bombas del robot
	 * @return
	 */
	public int getCantidadBombas(){
		return this.cantidadBombas;
	}
	
	/**
	 * Setea nivel de escudo del robot
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
		if(this.nivelEscudo < 0)
			this.nivelEscudo = 0;
	}
	
	/**
	 * Setea nivel de energia del robot
	 * @param nivelEnergia
	 */
	public void setNivelEnergia(int nivelEnergia){
		this.nivelEnergia = nivelEnergia;
		if(this.nivelEnergia < 0)
			this.nivelEnergia = 0;
	}
	
	/**
	 * Devuelve nivel de escudo del robot
	 * @return
	 */
	public int getNivelEscudo(){
		return this.nivelEscudo;
	}
	
	/**
	 * Devuelve nivel de energia del robot
	 * @return
	 */
	public int getNivelEnergia(){
		return this.nivelEnergia;
	}
	
	/**
	 * @return Municion disparada
	 */
	public Municion dispararMunicion(){
		//conseguimos la direccion del robot
		Posicion p = this.getPos();
		
		//disparamos la munición
		return new Municion(p,this);
		
	}
	/**
	 * Lanza una bomba
	 * @return
	 */
	public Bomba lanzarBomba(){
		return new Bomba(this.getPos(), this.getDireccion());
	}
	
	/**
	 * Rescata una persona de un refugio o zona de rescates
	 * @param persona
	 */
	public void cargarPersona(Persona persona){
		this.persona = persona;
	}
	
	public Persona entregarPersona(){
		Persona p = this.persona;
		this.persona = null;
		return p;
	}
	
	/**
	 * Comportamiento del robot en su turno
	 */
	@Override
	public void jugar() {
		// TODO Definir que hace el robot en jugar
	}
}

