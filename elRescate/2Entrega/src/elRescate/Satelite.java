package elRescate;

import java.util.ArrayList;

public class Satelite extends Elemento implements TieneEscudo, RadarListener {


	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	private ArrayList<Elemento> equipo;
	
	private static final int ESCUDO_INICIAL = 50;
	private final static int ANCHO_SATELITE = 3;
	private final static int ALTO_SATELITE = 3;
	
	/**
	 * Crea un satélite con un tamanio fijo en la posición indicada. Tiene un nivel de escudo inicial predeterminado
	 * @param posicion
	 */
	public Satelite(Posicion posicion){
		super(new Tamanio(ANCHO_SATELITE, ALTO_SATELITE), posicion);
		radar = new Radar(this.getPos(),this.radar.getDireccion());
		setNivelEscudo(ESCUDO_INICIAL); 
		
	}
	
	/**
	 * Setea nivel de escudo
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
		if (this.nivelEscudo <= 0){
			this.nivelEscudo = 0;
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
	
	public void setEquipo(ArrayList<Elemento> equipo){
		this.equipo = equipo;
	}
	
	public ArrayList<Elemento> getEquipo(){
		return this.equipo;
	}
	
	public void disparar(){
		//conseguimos la direccion del sat
		Posicion p = this.getPos();
		
		//TODO LA DIRECCION MABEL Y NELLY
		//disparamos la munición
		Escenario.getEscenario().agregarElemento((new Municion(p,this,this.radar.getDireccion())));
	}
	
	@Override
	public void jugar() {
		// TODO que hace el satelite mientras juega
		
	}
	
	@Override
	public void chocarElemento(Elemento elem) {
		if(elem instanceof Municion){
			Municion muni = (Municion) elem;
			if(!(esEquipo(muni, this.equipo)))
				this.setNivelEscudo(this.getNivelEscudo() - muni.getDanio());
		}
		else if(elem instanceof Bomba){
			Bomba bomb = (Bomba) elem;
			if(!(esEquipo(bomb, this.equipo)))
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
	public static boolean esEquipo(Municion m, ArrayList<Elemento> equipo){
		/*Devuelve verdadero si el que disparo la municion es del mismo equipo
		que el Robot que choco*/
		return equipo.contains(m.getDuenio());
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
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		/*
		 * Idem de lo que hicimos con el Robot
		 */
	}
	
	
}
