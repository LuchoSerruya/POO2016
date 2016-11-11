package elRescate;

public class EquipoJugador extends Equipo{
	private static EquipoJugador equipo;
	
	
	
	/**
	 * @return referencia al equipo
	 */
	public static EquipoJugador getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoJugador(
					new RobotJugador(Config.POSICION_ROBOT_JUGADOR),
					new SateliteJugador(Config.POSICION_SAT1_JUGADOR),
					new SateliteJugador(Config.POSICION_SAT2_JUGADOR),
					new Refugio(Config.POSICION_REFUGIO_JUGADOR));
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
	
	public RobotJugador getRobot() {
		RobotJugador robot = (RobotJugador)this.robot;
		return robot;

	}

}
