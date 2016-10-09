package elRescate;
/**
 * Bonus que otorga más escudo a aquel que lo recibe
 *
 */
public class BonusEnergia extends Bonus{
	
	//valor de energia que otorga
	public static final int VALOR_BONUS = 10;

	
	private int energia;
	/**
	 * @return energía que otorga el bonus
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Darle valor a la energía que otorga el bonus
	 * @param energia
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	/**
	 * Otorga el bonus
	 */
	public void darBonus(){
		//este podria acceder al metodo setEnergia del satelite/robot que gano el bonus
		//y asignarle el bonus
		//otra podria ser que le envie un mensaje al satelite/robot que lo gano
		//y ejecute el setEnergia
		
		//tambien podriamos tener en esta clase el metodo getBonus
		//y que el que gane el bonus llame a ese metodo
		//y se lo asigne a su energia/escudo
		//TODO implementación del bonus
	}
	
	/**
	 * creamos el bonus en una posición del escenario
	 * @param pos posicion en la que creamos el bonus
	 */
	public BonusEnergia(Posicion pos){
		super(pos);
		this.setEnergia(VALOR_BONUS);
		
		
	}

	public void jugar(){
		
	}

}
