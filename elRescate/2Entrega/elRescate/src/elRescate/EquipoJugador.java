package elRescate;

public class EquipoJugador extends Equipo{
	private static EquipoJugador equipo;
	private static final Posicion POSICION_REFUGIO_JUGADOR = new Posicion(1, 95);
								//Esquina inferior izquierda del escenario
	private static final Posicion POSICION_SAT1_JUGADOR = new Posicion(5, 85);
	private static final Posicion POSICION_SAT2_JUGADOR = new Posicion(10, 90);
	private static final Posicion POSICION_ROBOT_JUGADOR = new Posicion(10, 85);
	
	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoJugador(
					new RobotJugador(POSICION_ROBOT_JUGADOR),
					new SateliteJugador(POSICION_SAT1_JUGADOR),
					new SateliteJugador(POSICION_SAT2_JUGADOR),
					new Refugio(POSICION_REFUGIO_JUGADOR));
		}
		return equipo;
	}
	
	/**
	 * Constructor con el robot, los dos satelites y el refugio del equipo.
	 * @param robot Robot del equipo
	 * @param sat1 Satelite 1
	 * @param sat2 Satelite 2
	 * @param refugio Refugio del equipo
	 */
	private EquipoJugador(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		super(robot, sat1, sat2, refugio);
	}

}
