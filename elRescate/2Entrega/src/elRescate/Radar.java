package elRescate;

public class Radar extends Elemento {
	private double anguloApertura;
	private double alcance;
	
	private static final int ANCHO_RADAR = 3;
	private static final int ALTO_RADAR = 3;
	//listeners??
	
	//escanear??
	
	/*
	 * Con este constructor limitamos a que nos pasen
	 * la posicion y el tamaño del elemento que posee
	 * el radar (robot o satelite)
	 * */
	
	/**
	 * Crea un radar en una posición determinada (depende del satélite/robot)
	 * @param posicion
	 */
	public Radar(Posicion posicion){
		super(new Tamanio(ANCHO_RADAR, ALTO_RADAR), posicion);
		this.setAnguloApertura(0);
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
		//acá vemos qué hacemos, por ahora lo dejamos así
		this.alcance = angulo;
	}
	
	//TODO averiguar lo del listener
	
}
