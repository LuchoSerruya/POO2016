package elRescate;

import java.util.ArrayList;

public class SateliteQuejoDido extends Satelite {

	public SateliteQuejoDido(Posicion posicion) {
		super(posicion);
	}
	
	@Override
	public void jugar() {
		//que podria hacer??
		super.jugar();
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		/* 
		 * bandera para que no itere de m�s
		 */
		boolean encontro = false;
		for(Elemento e : elementos){
			if(!encontro){
				if(e instanceof Robot) {
					Robot robot = (Robot)e;
					if(robot.llevandoPersona()){
						this.getRadar().apuntar(robot);
						this.dispararMunicion();
						encontro = true;
					}	
				}	
			} 
			else {
				break;
			}
			
		}
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoQuejoDido.getEquipo();
	}
	


}
