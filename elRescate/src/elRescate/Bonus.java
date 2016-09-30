package elRescate;

public abstract class Bonus extends Elemento{
	
	private int tiempoVida;

	public int getTiempoVida() {
		return tiempoVida;
	}

	public void setTiempoVida(int tiempoVida) {
		this.tiempoVida = tiempoVida;
	}
	
	public abstract void darBonus();
	
	public Bonus(Tamanio tam, Posicion pos){
		super(tam, pos);
	}
	
	

}
