package elRescate;

import java.util.ArrayList;

public class RobotSoldadoRyan extends Robot {
	
	
	@Override
	public void jugar() {
		if(!this.llevandoPersona()){
			this.apuntar(Escenario.getEscenario().getZonaRescate());
		} else{
			this.apuntar(EquipoSoldadoRyan.getEquipo().getRefugio()));
		}
	}
	
	public RobotSoldadoRyan(Posicion posicion){
		super(posicion);
	}
	
	@Override
	public Equipo getEquipo() {
		// TODO Auto-generated method stub
		return null;
	}
}
