package elRescate;

public class Config {
	
	//tamaño de la bomba
	public static final int ANCHO_BOMBA = 6;
	public static final int ALTO_BOMBA = 6;
	
	//velocidad inicial de la bomba
	public static final double VELOCIDAD_BOMBA = 5;
	
	//daño de la bomba
	public static final int DANIO_BOMBA = 5;
	
	//Tamanio del bonus - predeterminado
	public static final int ANCHO_BONUS = 15;
	public static final int ALTO_BONUS = 15;
	
	//valor de energia que otorga
	public static final int VALOR_BONUS = 10;
	
	//Velocidad por defecto
	public static final double VELOCIDAD_DEFECTO = 5;
	
	//tamaño de la municion
	public static final int ANCHO_MUNICION = 5;
	public static final int ALTO_MUNICION = 5;
	
	//velocidad de la municion
	public static final double VELOCIDAD_MUNICION = 4;
	
	//danio de la municion
	public static final int DANIO_MUNICION = 1;
	
	//constantes para definir el tamanio del escenario
	public static final int MAX_X = 600;
	public static final int MAX_Y = 600;
	public static final int MIN_X= 0;
	public static final int MIN_Y = 0;
	


	public static final int ANCHO_RADAR = 1;
	public static final int ALTO_RADAR = 1;	
	
	public static final int ANCHO_REFUGIO = 50;
	public static final int ALTO_REFUGIO = 50;
	public static final int PENALIDAD = 3;
	
	/*Constantes de movimiento del jugador*/
	public final static int MOVER_IZQ = 1;
	public final static int MOVER_ARRIBA = 2;
	public final static int MOVER_DER = 3;
	public final static int MOVER_ABAJO = 4;
	public final static int DISPARAR_MUNICION = 5;
	public final static int LANZAR_BOMBA = 6;
	
	public static final int ESCUDO_INICIAL = 50;
	public final static int ANCHO_SATELITE = 15;
	public final static int ALTO_SATELITE = 15;
	public static final int MUNICIONES_DEFAULT = 100;
	
	//Constantes para definir un máximo y ancho que van a tener todos los elementos
	public static final int MAX_ANCHO = MAX_X;
	public static final int MIN_ANCHO = 1;
	public static final int MAX_ALTO = MAX_Y;
	public static final int MIN_ALTO = 1;
	
	//ROBOT
	public static final int ENERGIA_DEFAULT = 1000;
	public static final int ESCUDO_DEFUALT_ROBOT = 100;
	public static final int BOMBAS_DEFAULT = 10;

	public static final int ANCHO_ROBOT = 30;
	public static final int ALTO_ROBOT= 30;

	public static final double GASTO_ENERGIA_MOVIMIENTO = 0.01;
	public static final double VELOCIDAD_ROBOT = 5;
	
	//Constantes de tamaño del rescate
	public static final int ANCHO_ZONA_RESCATE = 60;
	public static final int ALTO_ZONA_RESCATE = 60;
	
	public static final int X_ZONA_RESCATE = (MAX_X - ANCHO_ZONA_RESCATE)/2;
	public static final int Y_ZONA_RESCATE = (MAX_Y - ALTO_ZONA_RESCATE)/2;
	
	public static int offset = 40;
	public static final Posicion ESQ_SUP_IZQ = new Posicion(X_ZONA_RESCATE - offset, Y_ZONA_RESCATE - offset);
	public static final Posicion ESQ_SUP_DER = new Posicion(X_ZONA_RESCATE + ANCHO_ZONA_RESCATE + offset, Y_ZONA_RESCATE - offset);
	public static final Posicion ESQ_INF_DER = new Posicion(X_ZONA_RESCATE + ANCHO_ZONA_RESCATE + offset, Y_ZONA_RESCATE + ALTO_ZONA_RESCATE + offset);
	public static final Posicion ESQ_INF_IZQ = new Posicion(X_ZONA_RESCATE - offset, Y_ZONA_RESCATE + ALTO_ZONA_RESCATE + offset);
}