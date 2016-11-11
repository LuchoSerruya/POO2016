package elRescate;

import java.util.ArrayList;

public class SateliteJugador extends Satelite{

	
	public SateliteJugador(Posicion posicion){
		super(posicion);
	}
	
	
	@Override
	public Equipo getEquipo() {
		
		return EquipoJugador.getEquipo();
	}
	
	@Override
	public void jugar() {
		super.jugar();
	}
	
	@Override
	/**
	 * Satelite del jugador dispara a otros robots que pasen
	 */
	public void elementosDetectado(ArrayList<Elemento> elementos) {
		super.elementosDetectado(elementos);
		
		//bandera para que no itere de m�s
		boolean encontro= false;
		
		for(Elemento e : elementos){
			if(!encontro){
				//le dispara a Robots salvo al de su equipo
				if((e instanceof Robot) && (!(this.getEquipo().getElementos().contains(e)))){
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
