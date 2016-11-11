package elRescate;

public class BonusEscudo extends Bonus{
	
	private int escudo;

	/**
	 * Setea el valor de escudo que dara como bonus a quien se lo gano
	 * @param escudo
	 */
	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	
	/**
	 * Otorga el bonus de escudo (Robot/Satelite)
	 */
	public void darBonus(Elemento elem){
		if (elem instanceof TieneEscudo){
			TieneEscudo e = (TieneEscudo) elem;
			e.setNivelEscudo(e.getNivelEscudo() + this.escudo);
		}
	}
	
	/**
	 * Creamos un bonus de escudo en una posicion pasada
	 * @param pos Posicion a donde crear el bonus
	 */
	public BonusEscudo(Posicion pos){
		super(pos);
		this.setEscudo(Config.VALOR_BONUS);		
		
	}
}
