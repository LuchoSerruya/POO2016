package elRescate;
//pancho
public class EquipoSoldadoRyan extends Equipo {
	private static EquipoSoldadoRyan equipo;

	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoSoldadoRyan(
					new RobotSoldadoRyan(Config.POSICION_ROBOT_SOLDADO_RYAN),
					new SateliteSoldadoRyan(Config.POSICION_SAT1_SOLDADO_RYAN),
					new SateliteSoldadoRyan(Config.POSICION_SAT2_SOLDADO_RYAN),
					new Refugio(Config.POSICION_REFUGIO_SOLDADO_RYAN));
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
	private EquipoSoldadoRyan(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		super(robot, sat1, sat2, refugio);
	}
}
