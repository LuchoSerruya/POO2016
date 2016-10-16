package elRescate;

import java.util.ArrayList;

public class RobotRencoroso extends Robot {
	
	
	@Override
	public void jugar() {
		super.jugar();
		
		this.avanzar(VELOCIDAD_ROBOT);
	}
	
	public RobotRencoroso(Posicion posicion){
		super(posicion);
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoRencoroso.getEquipo();
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		/*
		 * Bandera para que no itere de más
		 */
		boolean encontro = false;
		
		for(Elemento e : elementos){
			/*
			 * Orientamos el robot en la direcciòn del robot detectado
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
