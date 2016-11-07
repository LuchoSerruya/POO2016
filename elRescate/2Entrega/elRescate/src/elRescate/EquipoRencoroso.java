package elRescate;

public class EquipoRencoroso extends Equipo {
	private static EquipoRencoroso equipo;
	private static final Posicion POSICION_REFUGIO_RENCOROSO = new Posicion(540, 510);
								//Esquina inferior derecha del escenario
	private static final Posicion POSICION_SAT1_RENCOROSO = new Posicion(160, 160);
	private static final Posicion POSICION_SAT2_RENCOROSO = new Posicion(365, 365);
	private static final Posicion POSICION_ROBOT_RENCOROSO = new Posicion(400, 400);
	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoRencoroso(
					new RobotRencoroso(POSICION_ROBOT_RENCOROSO),
					new SateliteRencoroso(POSICION_SAT1_RENCOROSO),
					new SateliteRencoroso(POSICION_SAT2_RENCOROSO),
					new Refugio(POSICION_REFUGIO_RENCOROSO));
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
