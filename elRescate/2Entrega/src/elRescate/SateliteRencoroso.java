package elRescate;

import java.util.ArrayList;

public class SateliteRencoroso extends Satelite {
	
	public SateliteRencoroso(Posicion posicion) {
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

		//bandera para no iterar de m�s
		boolean encontro= false;
		
		for(Elemento e : elementos){
			/*
			 *  apuntamos con el radar y disparamos
			 *  sea un Robot o un Bonus
			 */
			if(!encontro){
				if(e instanceof Robot){
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
			
		}
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoRencoroso.getEquipo();
	}
	
	@Override
	public String toString() {
		
		return String.format("%s SATELITE RECOROSO | Cantidad municiones: %d", super.toString(), this.getCantidadMuniciones());
	}
}
