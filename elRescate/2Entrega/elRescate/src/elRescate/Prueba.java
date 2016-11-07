package elRescate;

import java.io.File;
import java.lang.management.ManagementFactory;

import gui.JuegoUI;

public class Prueba {
	
	
	private static void inicializarEquipos(){
		Equipo equipo = EquipoSoldadoRyan.getEquipo();
		Equipo equipo1 = EquipoQuejoDido.getEquipo();
		Equipo equipo2 = EquipoRencoroso.getEquipo();
		Equipo equipo3 = EquipoJugador.getEquipo();
	}
	
	public static void main(String[] args) {

		inicializarEquipos();
		
		JuegoUI jui = new JuegoUI();
		
		Escenario.getEscenario().iniciarJuego();
	}

}
