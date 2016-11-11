package elRescate;

import java.util.ArrayList;

public class RobotQuejoDido extends Robot{
	
	@Override
	/**
	 * Comportamiento del Robot QuejoDido
	 */
	public void jugar() {
		super.jugar();
		this.patrullar();		
	}
	
	/**
	 * Se mueve alrededor de la ZonaRescate con un cierto margen de distancia
	 */
	private void patrullar() {
		 /*
		  * Con esta estructura de selecci�n el robot se mueve
		  * alrededor de la zona de rescate, manteniendo una 
		  * distancia de 5
		  */
			
		if(this.getPos().equals(Config.ESQ_SUP_DER)){
			this.setDireccion(270);
		}
		else if(this.getPos().equals(Config.ESQ_INF_DER)){
			this.setDireccion(180);
		}
		else if(this.getPos().equals(Config.ESQ_INF_IZQ)){
			this.setDireccion(90);
			
		}
		else if(this.getPos().equals(Config.ESQ_SUP_IZQ)){
			this.setDireccion(0);
		}
		
		
	}

	public RobotQuejoDido(Posicion posicion){
		super(posicion);
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoQuejoDido.getEquipo();
	}
	
	@Override
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		
		//bandera para que no itere de m�s
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
				else if((e instanceof BonusEnergia) && (this.getNivelEnergia() < Config.ENERGIA_DEFAULT * 0.2)){
					this.getRadar().apuntar(e);
					this.dispararMunicion();
					encontro = true;
				}
			} else{
				break;
			}
		}
		
	}

}
