package elRescate;
import java.util.ArrayList;

public class Radar extends Elemento {
	private double anguloApertura;
	private double alcance;
	
	//dirección del radar
	private double direccion;
	
	//ArrayList de los listeners
	private ArrayList<RadarListener> listeners;
	
	private static final int ANCHO_RADAR = 3;
	private static final int ALTO_RADAR = 3;	
	
	/**
	 * Agregamos a un escuchador del Radar
	 * @param listener objeto que escucha al radar
	 */
	public void addRadarListener(RadarListener listener){
		this.listeners.add(listener);
	}
	
	/**
	 * Quitamos al objeto escuchador
	 * @param listener Escuchador a remover
	 */
	public void removeRadarListener(RadarListener listener){
		this.listeners.remove(listener);
	}
	
	/**
	 * Crea un radar en una posición determinada (dependiente del satélite/robot)
	 * @param posicion
	 */
	public Radar(Posicion posicion, double direccion){
		/*
		 * Con este constructor limitamos a que nos pasen
		 * la posicion y el tamaño del elemento que posee
		 * el radar (robot o satelite)
		 */
		
		super(new Tamanio(ANCHO_RADAR, ALTO_RADAR), posicion);
		this.setAnguloApertura(0);
		this.direccion = direccion;
	}
	
	
	/**
	 * Setea angulo de apertura del radar
	 * @param angulo
	 */
	public void setAnguloApertura(double angulo){
		this.anguloApertura = angulo;
		this.setAlcance(angulo);
	}
	
	/**
	 * Devuelve angulo de apertura del radar
	 * @return
	 */
	public double getAnguloApertura(){
		return this.anguloApertura;
	}
	
	/**
	 * Devuelve alcance del radar
	 * @return
	 */
	public double getAlcance(){
		return this.alcance;
	}
	
	//TODO Consular como es la formula de alcance
	/**
	 * Setea alcance del radar
	 * @param angulo
	 */
	private void setAlcance(double angulo){
		//TODO PONER UNA FORMULA DE ALCANCE COHERENTE!!!!
		//acá vemos qué hacemos, por ahora lo dejamos así
		this.alcance = 4;
	}
	
	/**
	 * Setea la dirección en la que apunta el radar
	 * @param direccion Nueva dirección
	 */
	public void setDireccion(double direccion){
		this.direccion = direccion;
	}
	
	/**
	 * @return Direccion a la que apunta el radar
	 */
	public double getDireccion(){
		return this.direccion;
	}
	
	/**
	 * Comportamiento del radar en su turno de juego
	 */
	@Override
	public void jugar() {
		//TODO kcemos aca con el radar
		//Por ahora hacemos que sólo se vaya rotando de a 90 grados
	}
	
	
}
