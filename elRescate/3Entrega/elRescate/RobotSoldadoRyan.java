package elRescate;

import java.util.ArrayList;

public class RobotSoldadoRyan extends Robot {
	
	
	@Override
	public void jugar() {
		super.jugar();
		if(!this.llevandoPersona()){
			this.orientar(Escenario.getEscenario().getZonaRescate());
		} else{
			this.orientar(EquipoSoldadoRyan.getEquipo().getRefugio());
		}
		
		
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
		//bandera para que no itere de m�s
		boolean encontro = false;
		
		for(Elemento e : elementos){
			if(!encontro){
				if((e instanceof Bomba) || 
				  ((e instanceof BonusEscudo) && (this.getNivelEscudo() < (ESCUDO_DEFUALT * 0.4)))){
					/*Si detecta una bomba o si detecta un bonus de escudo 
					 * y tiene menos del 40% del escudo inicial, apunta y dispara*/
					this.getRadar().apuntar(e);
					this.dispararMunicion();
					encontro = true;
				}
			} else {
				break;
			}
		}
		
	}
	
	
}
