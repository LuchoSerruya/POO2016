package elRescate;

import java.util.ArrayList;

public class Equipo {
	/**
	 * Clase basica para el equipo
	 */
	private ArrayList<Elemento> elementos;
//	private static Equipo equipo;
	private Robot robot;
	private Satelite sat1, sat2;
	private Refugio refugio;

	
	/*
	public static Equipo getEquipo(){
		if (equipo == null){
			equipo = new Equipo();
		}
		return equipo;
	}*/
	
	private Equipo(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		this.robot = robot;
		this.elementos.add(this.robot);
		this.sat1 = sat1;
		this.elementos.add(this.sat1);
		this.sat2 = sat2;
		this.elementos.add(this.sat2);
		this.refugio = refugio;	
		this.elementos.add(this.refugio);
		
		this.robot.setEquipo(elementos);
		this.sat1.setEquipo(elementos);
		this.sat2.setEquipo(elementos);
		
	}
	
	public ArrayList<Elemento> getElementos(){
		return this.elementos;
	}
	

}
