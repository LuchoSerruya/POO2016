package elRescate;

public class EquipoQuejoDido extends Equipo {
	private static EquipoQuejoDido equipo;
	private static final Posicion POSICION_REFUGIO_QUEJO_DIDO = new Posicion(95, 1);
	private static final Posicion POSICION_SAT1_QUEJO_DIDO = new Posicion(10, 75);
	private static final Posicion POSICION_SAT2_QUEJO_DIDO = new Posicion(15, 80);
	private static final Posicion POSICION_ROBOT_QUEJO_DIDO = new Posicion(ZonaRescate.ESQ_SUP_IZQ.getX(),ZonaRescate.ESQ_SUP_IZQ.getY());
	
	/**
	 * @return referencia al equipo
	 */
	public static Equipo getEquipo() {
		
		if(equipo == null){
			equipo = new EquipoQuejoDido(
					new RobotQuejoDido(POSICION_ROBOT_QUEJO_DIDO),
					new SateliteQuejoDido(POSICION_SAT1_QUEJO_DIDO),
					new SateliteQuejoDido(POSICION_SAT2_QUEJO_DIDO),
					new Refugio(POSICION_REFUGIO_QUEJO_DIDO));
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
