package elRescate;

public class EquipoQuejoDido extends Equipo {
	private static EquipoQuejoDido equipo;
	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoQuejoDido(
					new RobotQuejoDido(Config.POSICION_ROBOT_QUEJO_DIDO),
					new SateliteQuejoDido(Config.POSICION_SAT1_QUEJO_DIDO),
					new SateliteQuejoDido(Config.POSICION_SAT2_QUEJO_DIDO),
					new Refugio(Config.POSICION_REFUGIO_QUEJO_DIDO));
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
	private EquipoQuejoDido(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		super(robot, sat1, sat2, refugio);
	}
}
