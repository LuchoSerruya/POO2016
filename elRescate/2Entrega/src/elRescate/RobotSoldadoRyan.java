package elRescate;

import java.util.ArrayList;

public class RobotSoldadoRyan extends Robot {
	
	
	@Override
	public void jugar() {
		if(!this.llevandoPersona()){
			this.getRadar().apuntar(Escenario.getEscenario().getZonaRescate());
		} else{
			this.getRadar().apuntar(EquipoSoldadoRyan.getEquipo().getRefugio());
		}
		
		//que onda con la velocidad????
		//faltarian definir constantes de velocidad para el robot
		this.avanzar(VELOCIDAD_ROBOT);
	}
	
	public RobotSoldadoRyan(Posicion posicion){
		super(posicion);
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoSoldadoRyan.getEquipo();
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		for(Elemento e : elementos){
			if((e instanceof Bomba) || 
			  ((e instanceof BonusEscudo) && (this.getNivelEscudo() < (ESCUDO_DEFUALT * 0.4)))){
				/*Si detecta una bomba o si detecta un bonus de escudo 
				 * y tiene menos del 40% del escudo inicial, apunta y dispara*/
				this.getRadar().apuntar(e);
				this.dispararMunicion();
			}
		}
		
	}
}
