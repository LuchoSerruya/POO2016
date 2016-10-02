package elRescate;

public class BonusEnergia extends Bonus{
	public static final int VALOR_BONUS = 10;
	
	
	private int energia;
	
	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	public void darBonus(){
		//este podria acceder al metodo setEnergia del satelite/robot que gano el bonus
		//y asignarle el bonus
		//otra podria ser que le envie un mensaje al satelite/robot que lo gano
		//y ejecute el setEnergia
		
		//tambien podriamos tener en esta clase el metodo getBonus
		//y que el que gane el bonus llame a ese metodo
		//y se lo asigne a su energia/escudo
	}
	
	public BonusEnergia(Tamanio tam, Posicion pos){
		super(tam, pos);
		this.setEnergia(VALOR_BONUS);		
		
	}

	

}
