package elRescate;

public class Prueba {

	public static void main(String[] args) {
			
		System.out.println("Hola");
		Robot r1 = new Robot(new Posicion(2, 3));
		Robot r2 = new Robot(new Posicion(10, 10));
		Robot r3 = new Robot(new Posicion(5, 60));
		Robot r4 = new Robot(new Posicion(15, 75));
		
		Escenario.getEscenario().iniciarJuego();
	}

}
