package elRescate;

public class EquipoRencoroso extends Equipo {
	private static EquipoRencoroso equipo;
	
	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoRencoroso(
					new RobotRencoroso(Config.POSICION_ROBOT_RENCOROSO),
					new SateliteRencoroso(Config.POSICION_SAT1_RENCOROSO),
					new SateliteRencoroso(Config.POSICION_SAT2_RENCOROSO),
					new Refugio(Config.POSICION_REFUGIO_RENCOROSO));
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
	private EquipoRencoroso(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		super(robot, sat1, sat2, refugio);
		robot.setDireccion(90);
	}
}
