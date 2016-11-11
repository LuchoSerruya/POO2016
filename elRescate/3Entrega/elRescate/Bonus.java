	package elRescate;

import java.util.Random;

/**
 * 
 * Bonus que otorga beneficios al que lo recoge
 *
 */

public abstract class Bonus extends Elemento{
	
	public static int turnoAparicion = 0;
	
	//tiempo de vida del bonus
	private int tiempoVida;
	private int tiempoVivido;
	
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
		super(new Tamanio(Config.ANCHO_BONUS, Config.ALTO_BONUS), pos);
		//creamos contenedor del numero aleatorio
		Random random = new Random();
		//asignamos un nuevo valor de aparición para el bonus
		turnoAparicion = random.nextInt((20-10)+1) + 10;
		
		this.tiempoVivido = 0;
		this.tiempoVida = random.nextInt((200-150)+1) + 150;
	}
	
	/**
	 * Si el bonus se choca con un elemento, se destruye
	 */
	@Override
	public void chocarElemento(Elemento elem){
		elem.chocarBonus(this);
		//si choca algo, que se destruya
		this.destruir();
	}

	@Override
	public void jugar() {
		this.tiempoVivido++;
		if(tiempoVivido == tiempoVida){
			this.destruir();
		}
	}

}
