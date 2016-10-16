package elRescate;

import java.util.ArrayList;

public abstract class Satelite extends Elemento implements TieneEscudo, RadarListener {


	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	protected static final int ESCUDO_INICIAL = 50;
	private final static int ANCHO_SATELITE = 3;
	private final static int ALTO_SATELITE = 3;
	private static final int MUNICIONES_DEFAULT = 100;


	/**
	 * Crea un satélite con un tamanio fijo en la posición indicada. Tiene un nivel de escudo inicial predeterminado
	 * @param posicion
	 */
	public Satelite(Posicion posicion){
		super(new Tamanio(ANCHO_SATELITE, ALTO_SATELITE), posicion);
		this.radar = new Radar(this.getPos(),this.radar.getDireccion());
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
	
	public int getCantidadMuniciones(){
		return this.cantidadMuniciones;
	}

	public void setCantidadMuniciones(int cantMuniciones){
		this.cantidadMuniciones = cantMuniciones;
		if(this.cantidadMuniciones < 0)
			this.cantidadMuniciones = 0;
	}
	
	public Radar getRadar(){
		return this.radar;
	}
	
	/**
	 * @return referencia al equipo al que pertence
	 */
	public abstract Equipo getEquipo();
	
	
	public void dispararMunicion(){
		//disparamos la munición
		if(this.getCantidadMuniciones() > 0){
			Escenario.getEscenario().agregarElemento(new Municion(this.getPos(),this,this.radar.getDireccion()));
			//Disminuimos cantidad de municiones
			this.setCantidadMuniciones(this.getCantidadMuniciones() - 1);
		}
	}
	
	
	
	@Override
	public void chocarElemento(Elemento elem) {
		if(elem instanceof Municion){
			Municion muni = (Municion) elem;
			if(!(esEquipo(muni, this.getEquipo().getElementos())))
				this.setNivelEscudo(this.getNivelEscudo() - muni.getDanio());
		}
		else if(elem instanceof Bomba){
			Bomba bomb = (Bomba) elem;
			if(!(esEquipo(bomb, this.getEquipo().getElementos())))
				this.setNivelEscudo(this.getNivelEscudo() - bomb.getDanio());
		}		
		
	}
	
	/**
	 * Verifica si el que disparo la municion es del mismo equipo
	 * que el Satelite
	 * @param m municion lanzada
	 * @param equipo de la municion
	 * @return true si la municion es de un elemento companiero, false si no es
	 */
	public static boolean esEquipo(Municion m, ArrayList<Elemento> elementosEquipo){
		/*Devuelve verdadero si el que disparo la municion es del mismo equipo
		que el Robot que choco*/
		return elementosEquipo.contains(m.getDuenio());
	}
	
	/**
	 * Verifica si el que disparo la bomba es del mismo equipo
	 * que el Satelite
	 * @param b bomba lanzada
	 * @param equipo de la bomba
	 * @return true si la bomba es de un elemento companiero, false si no es
	 */
	public static boolean esEquipo(Bomba b, ArrayList<Elemento> equipo){
		
		return equipo.contains(b.getDuenio());
	}

	
	@Override
	public void jugar() {
		//Si no se encuentra algo que todos los satelites van a hacer
		//hacer este metodo abstracto
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
