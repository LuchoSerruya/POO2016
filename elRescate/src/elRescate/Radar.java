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
	public Radar(Posicion posicion){
		super(new Tamanio(ANCHO_RADAR, ALTO_RADAR), posicion);
		this.setAnguloApertura(0);
	}
	
	
	
	public void setAnguloApertura(double angulo){
		this.anguloApertura = angulo;
		this.setAlcance(angulo);
	}
	
	public double getAnguloApertura(){
		return this.anguloApertura;
	}
	
	public double getAlcance(){
		return this.alcance;
	}
	
	//TODO Consular como es la formula de alcance
	private void setAlcance(double angulo){
		//acá vemos qué hacemos, por ahora lo dejamos así
		this.alcance = angulo;
	}
	
	//TODO averiguar lo del listener
	
}
