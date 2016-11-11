package elRescate;

import java.util.ArrayList;

public abstract class Equipo {
	/**
	 * Clase basica para el equipo
	 */
	private ArrayList<Elemento> elementos;
	protected Robot robot;
	private Satelite sat1, sat2;
	private Refugio refugio;
	
	/**
	 * Constructor con el robot, los dos satelites y el refugio del equipo.
	 * @param robot Robot del equipo
	 * @param sat1 Satelite 1
	 * @param sat2 Satelite 2
	 * @param refugio Refugio del equipo
	 */
	public Equipo(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		this.elementos = new ArrayList<Elemento>();
		this.robot = robot;
		this.elementos.add(this.robot);
		this.sat1 = sat1;
		this.elementos.add(this.sat1);
		this.sat2 = sat2;
		this.elementos.add(this.sat2);
		this.refugio = refugio;	
		this.elementos.add(this.refugio);
	}
	
	/**
	 * @return Lista de elementos del equipo
	 */
	public ArrayList<Elemento> getElementos(){
		return this.elementos;
	}
	
	/**
	 * 
	 * @return Referencia al refugio del Equipo
	 */
	public Refugio getRefugio(){
		return this.refugio;
	}
	
	

}
