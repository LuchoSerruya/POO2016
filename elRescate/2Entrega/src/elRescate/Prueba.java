package elRescate;

public class Prueba {

	public static void main(String[] args) {
		
		Robot r1 = new Robot(new Posicion(2, 3));
		Robot r2 = new Robot(new Posicion(10, 3));
		Robot r3 = new Robot(new Posicion(5, 3));
		Robot r4 = new Robot(new Posicion(15, 3));
		
		Escenario.getEscenario().iniciarJuego();
		
		System.out.println("jjj");
	}

}
