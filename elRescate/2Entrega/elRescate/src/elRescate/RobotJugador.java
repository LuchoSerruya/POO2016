package elRescate;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RobotJugador extends Robot{
	
	public final static int MOVER_IZQ = 1;
	public final static int MOVER_ARRIBA = 2;
	public final static int MOVER_DER = 3;
	public final static int MOVER_ABAJO = 4;
	public final static int DISPARAR_MUNICION = 5;
	public final static int LANZAR_BOMBA = 6;
	
	int accionTeclado = 0;
	
	public RobotJugador(Posicion posicion){
		super(posicion);
	}

	@Override
	public Equipo getEquipo() {
		
		return EquipoJugador.getEquipo();
	}
	
	public int getAccionTeclado() {
		return accionTeclado;
	}
	
	public void setAccionTeclado(int accionTeclado) {
		this.accionTeclado = accionTeclado;
	}
	
	@Override
	public void jugar() {
		this.getRadar().escanear();
		
		switch (getAccionTeclado()){
			case MOVER_IZQ:
				this.setDireccion(180);
				this.avanzar(Robot.VELOCIDAD_ROBOT);
				this.setAccionTeclado(0);
				break;
			case MOVER_ARRIBA:
				this.setDireccion(90);
				this.avanzar(Robot.VELOCIDAD_ROBOT);
				this.setAccionTeclado(0);
				break;
			case MOVER_DER:
				this.setDireccion(0);
				this.avanzar(Robot.VELOCIDAD_ROBOT);
				this.setAccionTeclado(0);
				break;
			case MOVER_ABAJO:
				this.setDireccion(270);
				this.avanzar(Robot.VELOCIDAD_ROBOT);
				this.setAccionTeclado(0);
				break;
			case DISPARAR_MUNICION:
				this.dispararMunicion();
				this.setAccionTeclado(0);
				break;
			case LANZAR_BOMBA:
				this.lanzarBomba();
				this.setAccionTeclado(0);
				break;
			default:
		}
	
		
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		
		//System.out.println("ROBOT JUGADOR: detecte algo");
		
	}
	
	/**
	 * Dispara una munición en la dirección en la
	 * que apunta el radar. Ésta es agregada al
	 * escenario
	 */
	public void dispararMunicion(){
		//disparamos la munición
		if(this.getCantidadMuniciones() > 0){

			Escenario.getEscenario().agregarElemento(new Municion(
					new Posicion(this.getPos().getX(), this.getPos().getY()),
					this,
					this.getDireccion()));

			//Disminuimos cantidad de municiones
			this.setCantidadMuniciones(this.getCantidadMuniciones() - 1);
		}
	}
	
	@Override
	public void setNivelEscudo(int nivelEscudo) {
		super.setNivelEscudo(nivelEscudo);
		if(this.getNivelEscudo() == 0){
			JOptionPane.showMessageDialog(null, new String("¡Robot destruido!"));
			Escenario.espera(1000);
			System.exit(0);
		}
	}
}
