package elRescate;

public class BonusEscudo extends Bonus{
	public static final int VALOR_BONUS = 10;
	
	private int escudo;

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	
	/**
	 * Otorga el bonus
	 */
	public int darBonus(){
		return this.escudo;
	}
	
	/**
	 * Creamos un bonus de escudo en una posicion pasada
	 * @param pos Posicion a donde crear el bonus
	 */
	public BonusEscudo(Posicion pos){
		super(pos);
		this.setEscudo(VALOR_BONUS);		
		
	}
}
