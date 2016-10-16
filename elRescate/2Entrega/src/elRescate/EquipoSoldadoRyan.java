package elRescate;

public class EquipoSoldadoRyan extends Equipo {
	private static EquipoSoldadoRyan equipo;
	
	
	@Override
	public static Equipo getEquipo() {
		if(equipo == null){
			equipo = new EquipoSoldadoRyan(
					new RobotSoldadoRyan(new Posicion(10,10)), new Satelite());
		}
		return escenario;
	}
	
	/**
	 * Constructor con el robot, los dos satelites y el refugio del equipo.
	 * @param robot Robot del equipo
	 * @param sat1 Satelite 1
	 * @param sat2 Satelite 2
	 * @param refugio Refugio del equipo
	 */
	private public EquipoSoldadoRyan(Robot robot, Satelite sat1, Satelite sat2, Refugio refugio){
		this.robot = robot;
		this.elementos.add(this.robot);
		this.sat1 = sat1;
		this.elementos.add(this.sat1);
		this.sat2 = sat2;
		this.elementos.add(this.sat2);
		this.refugio = refugio;	
		this.elementos.add(this.refugio);
	}
}
