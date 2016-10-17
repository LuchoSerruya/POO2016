package elRescate;

public class Prueba {

	public static void main(String[] args) {
			
		System.out.println("MY NAME IS POTATO");
		
		
		System.out.println(String.format("Esquina superior izquierda X: %d | Y: %d", ZonaRescate.ESQ_SUP_IZQ.getX(), ZonaRescate.ESQ_SUP_IZQ.getY()));
		System.out.println(String.format("Esquina superior derecha X: %d | Y: %d", ZonaRescate.ESQ_SUP_DER.getX(), ZonaRescate.ESQ_SUP_DER.getY()));
		System.out.println(String.format("Esquina inferior derecha X: %d | Y: %d", ZonaRescate.ESQ_INF_DER.getX(), ZonaRescate.ESQ_INF_DER.getY()));
		System.out.println(String.format("Esquina inferior izquierda X: %d | Y: %d", ZonaRescate.ESQ_INF_IZQ.getX(), ZonaRescate.ESQ_INF_IZQ.getY()));
		
		
		Equipo equipo = EquipoSoldadoRyan.getEquipo();
		Equipo equpo1 = EquipoQuejoDido.getEquipo();
		
		Escenario.getEscenario().iniciarJuego();
	}

}
