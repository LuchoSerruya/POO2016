package elRescate;

import java.util.ArrayList;

public class RobotJugador extends Robot{
	
	
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
			case Config.MOVER_IZQ:
				this.setDireccion(180);
				this.avanzar();
				this.setAccionTeclado(0);
				break;
			case Config.MOVER_ARRIBA:
				this.setDireccion(90);
				this.avanzar();
				this.setAccionTeclado(0);
				break;
			case Config.MOVER_DER:
				this.setDireccion(0);
				this.avanzar();
				this.setAccionTeclado(0);
				break;
			case Config.MOVER_ABAJO:
				this.setDireccion(270);
				this.avanzar();
				this.setAccionTeclado(0);
				break;
			case Config.DISPARAR_MUNICION:
				this.dispararMunicion();
				this.setAccionTeclado(0);
				break;
			case Config.LANZAR_BOMBA:
				this.lanzarBomba();
				this.setAccionTeclado(0);
				break;
			default:
		}
	
		
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		
		
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
}
