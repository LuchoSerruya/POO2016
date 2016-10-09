package elRescate;

public class BonusEscudo extends Bonus{
	public static final int VALOR_BONUS = 10;
	
	
	private int escudo;
	
	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	
	public void darBonus(){
		//este podria acceder al metodo setescudo del satelite/robot que gano el bonus
		//y asignarle el bonus
		//otra podria ser que le envie un mensaje al satelite/robot que lo gano
		//y ejecute el setescudo
		
		//tambien podriamos tener en esta clase el metodo getBonus
		//y que el que gane el bonus llame a ese metodo
		//y se lo asigne a su escudo/escudo
		//TODO implementación bonus escudo
		/*
		 * Del lado del robot, llama a darBonus
		 * del lado del bonus, destruirse
		 */
		
	}
	
	/**
	 * Creamos un bonus de escudo en una posicion pasada
	 * @param pos Posicion a donde crear el bonus
	 */
	public BonusEscudo(Posicion pos){
		super(pos);
		this.setEscudo(VALOR_BONUS);		
		
	}
	
	public void jugar(){
		
	}
	

}
