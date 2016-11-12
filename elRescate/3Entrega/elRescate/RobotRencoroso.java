package elRescate;

import java.util.ArrayList;
import java.util.Random;

public class RobotRencoroso extends Robot {
	
	@Override
	public void jugar() {
		super.jugar();
		if(fueraDeEscenario()){
			this.setDireccion(new Random().nextInt(360));
		}
	}
	
	public RobotRencoroso(Posicion posicion){
		super(posicion);
		this.setDireccion(new Random().nextInt(360));
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoRencoroso.getEquipo();
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		
		/*
		 * Bandera para que no itere de m�s
		 */
		boolean encontro = false;
		
		for(Elemento e : elementos){
			/*
			 * Orientamos el robot en la direcci�n del robot detectado
			 * apuntamos con el radar y le disparamos
			 */
			if(!encontro){
				if(e instanceof Robot){
					
					this.orientar(e);
					this.getRadar().apuntar(e);
					this.dispararMunicion();
					encontro = true;
				}
				else if(e instanceof Bonus){
					this.getRadar().apuntar(e);
					this.dispararMunicion();
					encontro = true;
				}	
			}
			else{
				
				break;
			}
		}
		
	}
	
}
