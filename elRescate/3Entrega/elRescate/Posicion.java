package elRescate;


public class Posicion {
	
	private int x = Config.MIN_X;
	private int y = Config.MIN_Y;

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
		if(x >= Config.MIN_X && x <= Config.MAX_X)
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
		if(y >= Config.MIN_Y && y <= Config.MAX_Y)
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
		this(Config.MIN_X, Config.MIN_Y);
	}
	
	
	
	

}
