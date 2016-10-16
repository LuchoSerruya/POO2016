package elRescate;
//pancho
public class EquipoSoldadoRyan extends Equipo {
	private static EquipoSoldadoRyan equipo;
	private static final Posicion POSICION_REFUGIO_SOLDADO_RYAN = new Posicion(1, 1);
	private static final Posicion POSICION_SAT1_SOLDADO_RYAN = new Posicion(10, 5);
	private static final Posicion POSICION_SAT2_SOLDADO_RYAN = new Posicion(5, 10);
	private static final Posicion POSICION_ROBOT_SOLDADO_RYAN = new Posicion(10,10);
	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoSoldadoRyan(
					new RobotSoldadoRyan(POSICION_ROBOT_SOLDADO_RYAN),
					new SateliteSoldadoRyan(POSICION_SAT1_SOLDADO_RYAN),
					new SateliteSoldadoRyan(POSICION_SAT2_SOLDADO_RYAN),
					new Refugio(POSICION_REFUGIO_SOLDADO_RYAN));
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
