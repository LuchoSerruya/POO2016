package elRescate;

public class Municion extends Movible {
	private int danio;
				
	private Elemento duenio;
	//esto mas que un Elemento tendria que ser un Robot/Satelite
	
	//tamaño de la municion
	private static final int ANCHO_MUNICION = 3;
	private static final int ALTO_MUNICION = 3;
	
	//velocidad de la municion
	private static final double VELOCIDAD_MUNICION = 10;
	
	//danio de la municion
	private static final int DANIO_MUNICION = 10;
	
	/**
	 * Crea la munición en la posicip
	 * @param posicion
	 */
	public Municion(Posicion posicion, Robot duenio, double direccion){
		super(new Tamanio(ANCHO_MUNICION,ALTO_MUNICION), posicion);
		this.setDanio(DANIO_MUNICION);
		this.setVelocidad(VELOCIDAD_MUNICION);
		this.duenio = duenio;
		//le damos la dirección del que la lanzó
		//TODO LA DIRECCION MABEL
		this.setDireccion(direccion);
	}
	
	public Municion(Posicion posicion, Satelite duenio, double direccion){
		super(new Tamanio(ANCHO_MUNICION,ALTO_MUNICION), posicion);
		this.setDanio(DANIO_MUNICION);
		this.setVelocidad(VELOCIDAD_MUNICION);
		this.duenio = duenio;
		//le damos la dirección del que la lanzó
		//TODO LA DIRECCION MABEL
		this.setDireccion(direccion);
	}
	
	/**
	 * Setea el daño causado por la munición
	 * @param danio
	 */
	public void setDanio(int danio){
		this.danio = danio;
	}
	
	/**
	 * Retorna el daño que causa la munición
	 * @return daño causado por la municion
	 */
	public int getDanio(){
		return this.danio;
	}
	
	/**
	 * Comportamiento de la Munición al jugar. Sólo avanza
	 */
	@Override
	public void jugar() {
		this.avanzar(this.getVelocidad());
	}
	
	
	/**
	 * Comportamiento de la Munición al chocar otro elemento.
	 * Se destruye
	 */
	@Override
	public void chocarElemento(Elemento elem) {
		//TODO preguntar cómo se van a implementar los equipos
		//Si me choco con el que me lanzó, no hago nada

		
		if((elem instanceof TieneEscudo) && (!(esEquipo((Robot)this.getDuenio(), elem)))){
		//queda horripilante ese casteo, pero bueno
		//como no tenemos al Satelite y al Robot en la misma jerarquia ¬¬
		//lo casteamos a Robot que sabemos que va a tener referencia al equipo
		//pudo haber sido al Satelite tambien eh
		//O podriamos implementar una interfaz de TieneEquipo una onda asi
		//que tenga el metodo de set y get Equipo. La van a implementar
		//el Robot y el Satelite
		//Mejor (para este caso) quedaria poner lo del equipo en la interfaz TieneEscudo
		//no quedaria semanticamente correcto, pero vendria ideal para este caso
			TieneEscudo e = (TieneEscudo) elem;
			e.setNivelEscudo(e.getNivelEscudo() - this.danio);
		}
		else if (elem instanceof Bomba){
		//Si se choco con una bomba, la explotamos
		//SE CAMBIO EL MODIFICADOR DE ALCANCE DE Bomba.explotar()
			Bomba bomb = (Bomba) elem;
			bomb.explotar();
		}
		else if (elem instanceof Bonus){
		//que pasa aca, si el Bonus es de energia, solamente se lo podria asignar 
		//al duenio de la municion en caso de que sea un robot
		//si es de escudo, puede ser tanto a un Satelite como a un Robot
		//podriamos hacer que el metodo Bonus.darBonus reciba un objeto
		//de tipo Satelite (si es que estuvisen en la misma jerarquia ¬¬)
		//o podrian implementar otra interfaz que se llame ObtieneBonus
		//entonces el metodo Bonus.darBonus recibe un objeto que se comparta
		//como ObtieneBonus y cada tipo de bonus (Escudo/Energia)
		//redefine el metodo como necesite
			Bonus bon = (Bonus) elem;
//			this.getDuenio().
		}
		
		/*
		if(elem instanceof Robot){
			Robot e = (Robot)elem;
			//seteamos el nivel de escudo del Robot/Satelite a su nivel acual
			//menos el danio de la municion
			if()
			e.setNivelEscudo(e.getNivelEscudo() - this.danio);	
		}
		if(elem instanceof Satelite){
			Satelite e = (Satelite)elem;
			e.setNivelEscudo(e.getNivelEscudo() - this.danio);
		}*/
			
		
		this.setExiste(false);
	}
	
	/**
	 * Pregunta si el Elemento e recibido por parametro es parte del equipo del Robot robot
	 * Devuelve verdadero si e es del mismo equipo que robot
	 * @param robot que tiene el equipo
	 * @return
	 */
	public static boolean esEquipo (Robot robot, Elemento e){
	//estatico porque la clase Bomba tambien lo va a utilizar
		for(Elemento elemento: robot.getEquipo()){
			if(e == elemento)
				return true;
		}
		
		return false;
	
	}
	
	
	/**
	 * @return dueño de la Munción
	 */
	public Elemento getDuenio() {
		return this.duenio;
	}
}
