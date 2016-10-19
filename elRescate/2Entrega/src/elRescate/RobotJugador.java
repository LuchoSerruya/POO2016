package elRescate;

import java.util.ArrayList;

public class RobotJugador extends Robot{
	
	public RobotJugador(Posicion posicion){
		super(posicion);
	}

	@Override
	public Equipo getEquipo() {
		
		return EquipoJugador.getEquipo();
	}
	
	@Override
	public void jugar() {
		super.jugar();
		if(this.fueraDeEscenario())
			this.cambioDireccion();
		
		/*
		 * Comportamiento que va a tener el Robot de que va a manejar el jugador
		 * 
		 * La clase debe implementar los correspondientes listeners para Mouse y/o teclado
		 * y implementar sus metodos segun la configuracion de botones que se decida
		 * 
		 * 
		 * Por lo pronto el Robot del jugador se mueve 
		 * y cuando llega a algun extremo del escenario, cambia su direccion
		 */
		
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		
		System.out.println("ROBOT JUGADOR: detecte algo");
		
	}
	

		
	
	private void cambioDireccion(){
		if((this.getDireccion() == 90))
			this.setDireccion(0);
		else if((this.getDireccion() == 0))
			this.setDireccion(270);
		else if((this.getDireccion() == 270))
			this.setDireccion(180);
		else if((this.getDireccion() == 180))
			this.setDireccion(0);
	}
	
	
	@Override
	public String toString() {
		
		return String.format("%s ROBOT JUGADOR | Cantidad municiones: %d", super.toString(), this.getCantidadMuniciones());
	}

}
