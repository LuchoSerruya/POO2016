package elRescate;

public class Robot extends Movible {
	private int nivelEscudo;
	private int nivelEnergia;
	
	private Radar radar;
	
	private Persona persona;
	
	private int cantidadMuniciones;
	
	private int cantidadBombas;
	
	private static final int MUNICIONES_DEFAULT = 100;
	private static final int BOMBAS_DEFAULT = 10;
	
	public Robot(Tamanio tamanio, Posicion posicion){
		super(tamanio, posicion);
		
		setCantidadBombas(BOMBAS_DEFAULT);
		setCantidadMuniciones(MUNICIONES_DEFAULT);
		
		this.radar = new Radar(this.getPos());
	}
	
	public void setCantidadMuniciones(int cantidadMuniciones){
		this.cantidadMuniciones = cantidadMuniciones;
	}
	
	public void setCantidadBombas(int cantidadBombas){
		this.cantidadBombas = cantidadBombas;
	}
	
	public int getCantidadMuniciones(){
		return this.cantidadMuniciones;
	}
	
	public int getCantidadBombas(){
		return this.cantidadBombas;
	}
	
	public void setNivelEscudo(int nivelEscudo){
		this.nivelEscudo = nivelEscudo;
	}
	
	public void setNivelEnergia(int nivelEnergia){
		this.nivelEnergia = nivelEnergia;
	}
	
	public int getNivelEscudo(){
		return this.nivelEscudo;
	}
	
	public int getNivelEnergia(){
		return this.nivelEnergia;
	}
	
	public Municion dispararMunicion(){
		//pedimosm la direccion del robot
		double direccion = this.getDireccion();
		
		Posicion p = this.getPos();
		/*
		 * Aca iria una tramoya con el tema del angulo, la direccion y todo
		 * 
		 * Para finalmente hacer
		 * */
		return new Municion(p);
		
	}
	
	public Bomba lanzarBomba(){
		//pedimosm la direccion del robot
		double direccion = this.getDireccion();
		
		Posicion p = this.getPos();
		/*
		 * Aca iria una tramoya con el tema del angulo, la direccion y todo
		 * 
		 * Para finalmente hacer
		 * */
		return new Bomba(p);
	}
	
	public void cargarPersona(Persona persona){
		this.persona = persona;
	}
	
}

