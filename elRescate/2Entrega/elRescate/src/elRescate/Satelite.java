package elRescate;

import java.util.ArrayList;

public abstract class Satelite extends Elemento implements TieneEscudo, RadarListener {


	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	protected static final int ESCUDO_INICIAL = 50;
	private final static int ANCHO_SATELITE = 15;
	private final static int ALTO_SATELITE = 15;
	private static final int MUNICIONES_DEFAULT = 100;


	/**
	 * Crea un satélite con un tamanio fijo en la posición indicada. Tiene un nivel de escudo inicial predeterminado
	 * @param posicion
	 */
	public Satelite(Posicion posicion){
		super(new Tamanio(ANCHO_SATELITE, ALTO_SATELITE), posicion);
		this.radar = new Radar(this.getPos(),0);
		this.radar.addRadarListener(this);
		
		this.setNivelEscudo(ESCUDO_INICIAL);
		this.setCantidadMuniciones(MUNICIONES_DEFAULT);
		
	}
	
	
	/**
	 * Setea nivel de escudo
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
		if (this.nivelEscudo <= 0){
			this.setExiste(false);
		}
	}
	
	/**
	 * Devuelve el nivel de escudo del satélite
	 * @return
	 */
	public int getNivelEscudo(){
		return this.nivelEscudo;
	}
	
	/**
	 * 
	 * @return cantidad de municiones del satelite
	 */
	public int getCantidadMuniciones(){
		return this.cantidadMuniciones;
	}

	/**
	 * 
	 * @param cantMuniciones cantidad de municiones a setear en el satelite
	 */
	public void setCantidadMuniciones(int cantMuniciones){
		this.cantidadMuniciones = cantMuniciones;
		if(this.cantidadMuniciones < 0)
			this.cantidadMuniciones = 0;
	}
	
	/**
	 * 
	 * @return referencia al radar del satelite
	 */
	public Radar getRadar(){
		return this.radar;
	}
	
	/**
	 * @return referencia al equipo al que pertence
	 */
	public abstract Equipo getEquipo();
	
	
	/**
	 * Dispara una munición en la dirección en la 
	 * que apunta el radar. Ésta es agregada al 
	 * escenario
	 */
	public void dispararMunicion(){
		//disparamos la munición
		if(this.getCantidadMuniciones() > 0){
			Escenario.getEscenario().agregarElemento(new Municion(this.getPos(),this,this.getRadar().getDireccion()));
			//Disminuimos cantidad de municiones
			this.setCantidadMuniciones(this.getCantidadMuniciones() - 1);
		}
		
	}
	
	
	@Override
	public void chocarMunicion(Municion municion) {
		super.chocarMunicion(municion);
		
		if(!(this.getEquipo().getElementos().contains(municion.getDuenio())))
			this.setNivelEscudo(this.getNivelEscudo() - municion.getDanio());
		
	}
	
	@Override
	public void chocarBomba(Bomba bomba) {
		super.chocarBomba(bomba);
		if(!(this.getEquipo().getElementos().contains(bomba.getDuenio())))
			this.setNivelEscudo(this.getNivelEscudo() - bomba.getDanio());
	}
	
	@Override
	public void chocarElemento(Elemento elem) {
		
		/*
		 * 
		 * TODO BORRAR LO COMENTADO 
		 * 
		 */
		
		/*
		if(elem instanceof Municion){
			Municion muni = (Municion) elem;
			//si no es de mi equipo, me genero el daño
			if(!(this.getEquipo().getElementos().contains(muni.getDuenio())))
				this.setNivelEscudo(this.getNivelEscudo() - muni.getDanio());
		}
		else if(elem instanceof Bomba){
			Bomba bomb = (Bomba) elem;
			//si no es de mi equipo, me genero el daño
			if(!(this.getEquipo().getElementos().contains(bomb.getDuenio())))
				this.setNivelEscudo(this.getNivelEscudo() - bomb.getDanio());
		}*/	
		
	}
	


	
	@Override
	public void jugar() {
		//Si no se encuentra algo que todos los satelites van a hacer
		//hacer este metodo abstracto
		this.getRadar().escanear();
	}
	
	/**
	 * Procesa los elementos detectados por el radar
	 * @param elementos elementos que detectó el radar
	 */
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		//eliminar satelite de la lista
		elementos.remove(this);
		
		/*
		 * Procesar elementos detectados
		 */
	}
	
	
}
