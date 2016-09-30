package elRescate;


public class Posicion {
	//constantes para definir el tamanio del escenario
	public static final int MAX_X= 100;
	public static final int MAX_Y = 100;
	public static final int MIN_X= 0;
	public static final int MIN_Y = 0;
	
	private int x = MIN_X;
	private int y = MIN_Y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x >= MIN_X && x <= MAX_X)
			this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(x >= MIN_Y && x <= MAX_Y)
			this.y = y;
	}
	
	public Posicion(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	public Posicion(){
		this(MIN_X, MIN_Y);
	}
	
	
	
	

}
