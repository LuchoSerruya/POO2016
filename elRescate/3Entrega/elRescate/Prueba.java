package elRescate;

import gui.JuegoUI;

public class Prueba {

	public static void main(String[] args) {

		Equipo equipo = EquipoSoldadoRyan.getEquipo();
		Equipo equipo1 = EquipoQuejoDido.getEquipo();
		Equipo equipo2 = EquipoRencoroso.getEquipo();
		Equipo equipo3 = EquipoJugador.getEquipo();
		
		JuegoUI jui = new JuegoUI();
		
		Escenario.getEscenario().iniciarJuego();
	}

}
