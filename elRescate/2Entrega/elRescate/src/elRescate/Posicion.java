package elRescate;


public class Posicion {
	//constantes para definir el tamanio del escenario
	public static final int MAX_X= 600;
	public static final int MAX_Y = 600;
	public static final int MIN_X= 0;
	public static final int MIN_Y = 0;
	
	private int x = MIN_X;
	private int y = MIN_Y;

	/**
	 * Devuelve coordenada x de un elemento
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setea coordenada x de un elemento
	 * @param x
	 */
	public void setX(int x) {
		if(x >= MIN_X && x <= MAX_X)
			this.x = x;
	}

	/**
	 * Devuelve coordenada y de un elemento
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setea coordenada y de un elemento
	 * @param y
	 */
	public void setY(int y) {
		if(y >= MIN_Y && y <= MAX_Y)
			this.y = y;
	}
	
	/**
	 * Crea una posicion con coordenadas indicadas
	 * @param x
	 * @param y
	 */
	public Posicion(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Posicion){
			Posicion pos = (Posicion)obj;
			return ((this.getX() == pos.getX()) && (this.getY() == pos.getY()));
		}
		else
			return super.equals(obj);
	}
	
	/**
	 * Crea una posicion con valores predeterminados
	 */
	public Posicion(){
		this(MIN_X, MIN_Y);
	}
	
	
	
	

}
