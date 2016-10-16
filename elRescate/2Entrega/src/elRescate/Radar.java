package elRescate;
import java.awt.Polygon;
import java.util.ArrayList;


public class Radar extends Elemento {
	private int anguloApertura;
	private double alcance;
	
	private static int incrementoGradosPoligono = 5;
	
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
		this.listeners = new ArrayList<RadarListener>();
	}
	
	
	/**
	 * Setea angulo de apertura del radar
	 * @param angulo
	 */
	public void setAnguloApertura(int angulo){
		this.anguloApertura = angulo;
		this.setAlcance(angulo);
	}
	
	/**
	 * Devuelve angulo de apertura del radar
	 * @return
	 */
	public int getAnguloApertura(){
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
		this.direccion = direccion % 360;
	}
	
	/**
	 * @return Direccion a la que apunta el radar
	 */
	public double getDireccion(){
		return this.direccion;
	}
	
	
	/**
	 * Dado un elemento, orienta el radar en esa
	 * direccion
	 * @param elemento elemento al que se debe apuntar
	 * @return ángulo en el cual posicionarse
	 */
	public void apuntar(Elemento elemento){
		
		/*
		 * Generamos dos puntos que actuarán de vectores 
		 * para despues buscar el ángulo entre ellos
		 */
		Posicion p1 = new Posicion(0,this.getPos().getY());
		Posicion p2 = elemento.getPos();
		
		/*
		 * Con este choclo obtenemos el coseno del
		 * ángulo entre ambos vectores
		 */
		double aux = 
				(p1.getX()*p2.getX() + p1.getY()*p2.getY())/
				(Math.sqrt(Math.pow(p1.getX(),2)+Math.pow(p1.getY(), 2))+
						Math.sqrt(Math.pow(p2.getX(),2))+Math.pow(p2.getY(), 2));
		
		//Devolvemos el arco seno del �ngulo
		this.setDireccion(Math.acos(aux));		
	}
	
	/**
	 * Comportamiento del radar en su turno de juego
	 */
	@Override
	public void jugar() {
		//TODO kcemos aca con el radar
		//Por ahora hacemos que sólo se vaya rotando de a 90 grados
		
		this.setDireccion(this.getDireccion() + 90);
	}
	
	public void escanear(){
		System.out.println("Radar Escaneanding...");
		
		//Armar poligono
		Polygon zonaBarrida = this.armarPoligono(this.getPos().getX(), this.getPos().getY());
		
		//le pido al escenario que me diga si hay elementos dentro del poligono
		ArrayList<Elemento> elementosDetectados = Escenario.getEscenario().enArea(zonaBarrida);
		
		//elemino de la lista al radar en sí
		elementosDetectados.remove(this);
		
		
		for(RadarListener listener : this.listeners){
			listener.elementosDetectado(elementosDetectados);
		}
	}

	/**
	 * Armado del poligono usado para la detección del radar
	 * @param x coordenada x del radar
	 * @param y coordenada y del radar
	 * @return Poligono de alcance del radar
	 */
	private Polygon armarPoligono(int x, int y) {
		
		/* 
		 * pido el angulo y lo divido para poder barrer
		 * con una mitad del angulo para un lado y mitad
		 * para el otro
		 */
		double angulo = this.getAnguloApertura() / 2;
		
		/* 
		 * calculo la cantidad de puntos 
		 * uno mas para que incluya la posicion del radar
		 * */
		int cantidadPuntos = 1 + (int)(this.getAnguloApertura() / incrementoGradosPoligono);
		
		
		//creo los arreglos para pasale al poligono
		int[] xPuntos = new int[cantidadPuntos];
		int[] yPuntos = new int[cantidadPuntos];
		
		//le agrego la posicion del radar
		xPuntos[0] = x;
		yPuntos[0] = y;
		
		//voy poniendo en el arreglo los puntos calculados con los deltas
		for (int i = 1; i< cantidadPuntos; i++){
			xPuntos[i] = (int)Movible.deltaX(this.getAlcance(), angulo);
			yPuntos[i] = (int)Movible.deltaY(this.getAlcance(), angulo);
			angulo += incrementoGradosPoligono;
		}
		
		//devuelvo el poligono ya armado
		return new Polygon(xPuntos, yPuntos, cantidadPuntos);
	}
	
	
}
