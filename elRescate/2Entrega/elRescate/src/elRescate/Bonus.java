	package elRescate;

import java.util.Random;

/**
 * 
 * Bonus que otorga beneficios al que lo recoge
 *
 */

public abstract class Bonus extends Elemento{
	//Tamanio del bonus - predeterminado
	protected static final int ANCHO_BONUS = 3;
	protected static final int ALTO_BONUS = 3;
	
	private static int turnoAparicion;
	
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
	
	/**
	 * Comportamiento que va a tener el Bonus segun sea de energia o de escudo
	 * @param elem Objeto que se obtendra el bonus (sera un Robot/Satelite)
	 */
	public abstract void darBonus(Elemento elem);
	
	
	/**
	 * Crea un Bonus en una posicion del escenario
	 * @param pos
	 */
	public Bonus(Posicion pos){
		super(new Tamanio(ANCHO_BONUS, ALTO_BONUS), pos);
		//creamos contenedor del numero aleatorio
		Random random = new Random();
		//asignamos un nuevo valor de aparición para el bonus
		turnoAparicion = random.nextInt((20-10)+1) + 10;
	}
	
	/**
	 * Si el bonus se choca con un elemento, se destruye
	 */
	@Override
	public void chocarElemento(Elemento elem){
		elem.chocarBonus(this);
		//si choca algo, que se destruya
		this.setExiste(false);
	}


}
