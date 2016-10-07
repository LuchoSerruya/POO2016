package elRescate;
/**
 * 
 * Bonus que otorga beneficios al que lo recoge
 *
 */
public abstract class Bonus extends Elemento{
	//Tamanio del bonus - predeterminado
	protected static final int ANCHO_BONUS = 3;
	protected static final int ALTO_BONUS = 3;
	
	//tiempo de vida del bonus
	private int tiempoVida;
	
	
	/**
	 * @return Tiempo de vida del Bonus
	 */
	public int getTiempoVida() {
		return tiempoVida;
	}

	/**
	 * Le da un valor al tiempo de vida del bonus
	 * @param tiempoVida
	 */
	public void setTiempoVida(int tiempoVida) {
		this.tiempoVida = tiempoVida;
	}
	
	public abstract void darBonus();
	
	/**
	 * Crea un bonus es una posicion determinadas
	 * @param pos Posicion del bonus
	 */
	public Bonus(Posicion pos){
		super(new Tamanio(ANCHO_BONUS, ALTO_BONUS), pos);
	}
	
	

}
