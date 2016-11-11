package elRescate;

import java.util.ArrayList;

public abstract class Robot extends Movible implements TieneEscudo, RadarListener{
	private int nivelEscudo;
	private int nivelEnergia;
	private int cantidadMuniciones;
	private int cantidadBombas;

	private Radar radar;
	private Persona persona;

//	protected static final int ENERGIA_DEFAULT = 1000;
//	protected static final int ESCUDO_DEFUALT = 100;
//	private static final int MUNICIONES_DEFAULT = 100;
//	private static final int BOMBAS_DEFAULT = 10;
//
//	private static final int ANCHO_ROBOT = 20;
//	private static final int ALTO_ROBOT= 20;
//
//	private static final double GASTO_ENERGIA_MOVIMIENTO = 0.01;
//	protected static final double VELOCIDAD_ROBOT = 5;

	/**
	 * Crea un robot con un tamanio fijo en una posicion indicada.
	 * Setea sus valores de cantidad de bombas y municiones a un valor por defecto
	 * @param posicion
	 */
	public Robot(Posicion posicion){
		super(new Tamanio(Config.ANCHO_ROBOT, Config.ALTO_ROBOT), posicion);

		setCantidadBombas(Config.BOMBAS_DEFAULT);
		setCantidadMuniciones(Config.MUNICIONES_DEFAULT);

		this.setNivelEscudo(Config.ESCUDO_DEFUALT_ROBOT);
		this.setNivelEnergia(Config.ENERGIA_DEFAULT);

		this.radar = new Radar(this,this.getDireccion());
		this.radar.addRadarListener(this);
	}

	public void setCantidadMuniciones(int cantidadMuniciones){
		this.cantidadMuniciones = cantidadMuniciones;
		if(this.cantidadMuniciones <= 0)
			this.cantidadMuniciones = 0;
	}

	/**
	 * Setea cantidad de bombas del robot
	 * @param cantidadBombas
	 */
	public void setCantidadBombas(int cantidadBombas){
		this.cantidadBombas = cantidadBombas;
		if(this.cantidadBombas <= 0)
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
	 *
	 * @return referencia al equipo al que pertence
	 */
	public abstract Equipo getEquipo();



	/**
	 * Setea nivel de escudo del robot
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
		if (this.nivelEscudo <= 0){
			this.destruir();;
		}
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
	 * @return Nivel de Energía del Robot
	 */
	public int getNivelEnergia(){
		return this.nivelEnergia;
	}

	public Radar getRadar(){
		return this.radar;
	}

	@Override
	public void avanzar() {
		//Si aun tengo energia, me muevo
		if(this.getNivelEnergia() > 0){	
			this.setVelocidad(Config.VELOCIDAD_ROBOT);
			super.avanzar();
	
			//Preguntamos si tiene una persona cargada para controlar el gasto de energia
			if(this.llevandoPersona())
				this.setNivelEnergia((int)(this.getNivelEnergia() - Config.GASTO_ENERGIA_MOVIMIENTO));
			else
				this.setNivelEnergia((int)(this.getNivelEnergia() - (Config.GASTO_ENERGIA_MOVIMIENTO * 2)));
		}
	}

	/**
	 * Lanza una bomba en la dirección en la
	 * que apunta el radar. Ésta es agregada al
	 * escenario
	 */
	public void lanzarBomba(){
		if(this.getCantidadBombas() > 0){
			Escenario.getEscenario().agregarElemento(new Bomba(
					new Posicion(this.getPos().getX(), this.getPos().getY()),
					this,
					this.getDireccion()));
			//Disminuimos cantidad de bombas
			this.setCantidadBombas(this.getCantidadBombas() - 1);
		}
	}

	/**
	 * Dispara una munición en la dirección en la
	 * que apunta el radar. Ésta es agregada al
	 * escenario
	 */
	public void dispararMunicion(){
		//disparamos la munición
		if(this.getCantidadMuniciones() > 0){

			Escenario.getEscenario().agregarElemento(new Municion(
					new Posicion(this.getPos().getX(), this.getPos().getY()),
					this,
					this.getRadar().getDireccion()));

			//Disminuimos cantidad de municiones
			this.setCantidadMuniciones(this.getCantidadMuniciones() - 1);
		}

	}
	
	/*
	 * 
	 * El Robot se encargaria de todo lo relacionado a el mismo
	 * 
	 */
	
	
	@Override
	public void chocarMunicion(Municion municion) {
		super.chocarMunicion(municion);
		
		//Nos hacemos danio (si es enemigo)
		if(!(this.getEquipo().getElementos().contains(municion.getDuenio())))
			this.setNivelEscudo(this.getNivelEscudo() - municion.getDanio());
	}
	
	@Override
	public void chocarBomba(Bomba bomba) {
		super.chocarBomba(bomba);
		
		//Nos hacemos danio (si es enemigo)
		if(!(this.getEquipo().getElementos().contains(bomba.getDuenio())))
			this.setNivelEscudo(this.getNivelEscudo() - bomba.getDanio());
	}
	
	@Override
	public void chocarBonus(Bonus bonus) {
		super.chocarBonus(bonus);
		
		//conseguimos bonus
		bonus.darBonus(this);
		
	}
	
	@Override
	public void chocarZonaRescate(ZonaRescate zonaRescate) {
		super.chocarZonaRescate(zonaRescate);
		
		if(!this.llevandoPersona())
			this.cargarPersona(zonaRescate.rescatarPersona());
	}
	
	@Override
	public void chocarRefugio(Refugio refugio) {
		super.chocarRefugio(refugio);
		
		boolean esNuestro = this.getEquipo().getElementos().contains(refugio);
		//Si es nuestro refugio y estamos llevando persona
		if(esNuestro && (this.llevandoPersona())){
			//dejamos la persona que llevamos
			refugio.salvarPersona(this.entregarPersona());
		}
		else if(!esNuestro && !this.llevandoPersona()){
			
			//si no es nuestro refugio y no estamos llevando persona
			//robamos persona
			this.cargarPersona(refugio.quitarPersona());
			this.setNivelEscudo(this.getNivelEscudo() - Config.PENALIDAD);
		
				
		}
			
		
	}

	@Override
	public void chocarElemento(Elemento elem) {
		
		elem.chocarRobot(this);

	}



	/**
	 * Rescata una persona de un refugio o zona de rescates
	 * @param persona
	 */
	public void cargarPersona(Persona persona){
		if (!(this.llevandoPersona()))
			this.persona = persona;
	}

	/**
	 * Indica si se esta llevando una persona o no
	 * @return True si se tiene una persona cargada, falso si no
	 */
	public boolean llevandoPersona(){
		return this.persona != null;
	}


	public Persona entregarPersona(){
		Persona p = this.persona;
		this.persona = null;
		return p;
	}

	/**
	 * Comportamiento del robot (GENERICO) en su turno
	 */
	@Override
	public void jugar() {
		//Si no se encuentra algo que todos los robots van a hacer
		//hacer este metodo abstracto
		this.getRadar().setDireccion(this.getRadar().getDireccion() + 90);
		this.getRadar().escanear();

		this.avanzar();
	}

	/**
	 * Dado un elemento, orienta el Robot hacia ese
	 * elemento
	 * @param elemento elemento al que se debe apuntar
	 * @return ángulo en el cual posicionarse
	 */
	public void orientar(Elemento elemento){

		//vector de referencia (1,0)
		double xo = 1;
		double yo = 0;

		//vector de coordenadas hacia donde queremos orientar el robot
		double xd = elemento.getPos().getX()-this.getPos().getX();
		double yd = elemento.getPos().getY() - this.getPos().getY();

		//calculamos angulos absolutos de ambos vectores
		double origen = Math.toDegrees(Math.atan2(xo,yo));
		if(origen < 0){
			origen +=360;
		}

		double destino = Math.toDegrees(Math.atan2(xd,yd));
		if(destino < 0){
			destino += 360;
		}

		//la orientación final es la diferencia entre ambos angulos
		double orientacion = destino - origen;
		if(orientacion < 0){
			orientacion += 360;
		}

		this.setDireccion(orientacion);

	}


	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos){
		elementos.remove(this);
	}

	/**
	 * Muestra las stats del robot
	 */
	@Override
	public String toString() {
		
		return String.format(
				"%s\n"
				+ "Municiones: %d\n"
				+ "Bombas: %d\n"
				+ "Nivel Energia: %d\n"
				+ "Nivel Escudo: %d\n"
				+ "Lleva Persona?: %b", 
				super.toString(), 
				this.getCantidadMuniciones(),
				this.getCantidadBombas(),
				this.getNivelEnergia(),
				this.getNivelEscudo(),
				this.llevandoPersona());
	}

}
