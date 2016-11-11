package elRescate;
/**
 * Bonus que otorga más escudo a aquel que lo recibe
 *
 */
public class BonusEnergia extends Bonus{
	

	public int energia;
	
	/**
	 * Darle valor a la energía que otorga el bonus
	 * @param energia
	 */
	public void setEnergia(int energia){
		this.energia = energia;
	}
	
	/**
	 * Otorga el bonus de energia (solo aplicable para Robot)
	 */
	public void darBonus(Elemento elem){
		if (elem instanceof Robot){
			Robot robot = (Robot) elem;
			robot.setNivelEnergia(robot.getNivelEnergia() + this.energia);
		}
		
	}
		
	
	/**
	 * creamos el bonus en una posición del escenario
	 * @param pos posicion en la que creamos el bonus
	 */
	public BonusEnergia(Posicion pos){
		super(pos);
		
	}

}
