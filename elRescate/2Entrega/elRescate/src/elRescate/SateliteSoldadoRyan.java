package elRescate;

import java.util.ArrayList;

public class SateliteSoldadoRyan extends Satelite{
	
	public SateliteSoldadoRyan(Posicion posicion) {
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
		
		//bandera para que no itere de m�s
		boolean encontro= false;
		
		for(Elemento e : elementos){
			if(!encontro){
				if((e instanceof Bomba) || 
				  ((e instanceof BonusEscudo) && (this.getNivelEscudo() < (Config.ESCUDO_INICIAL * 0.4)))){
					/*
					 * Si detecta una bomba o si detecta un bonus de escudo 
					 * y tiene menos del 40% del escudo inicial y adem�s todavia
					 * no encontr� ni bomba ni bonus, apunta y dispara
					 * */
					
					//el apuntar deberia ser de Radar, o de Elemento de ultima
					//this.apuntar(e);
					System.out.println("SATELITE SOLDADO RYAN WA A DISPARA");
					this.getRadar().apuntar(e);
					this.dispararMunicion();
					encontro = true;
				}
			} else{
				break;
			}
			
		}
	}
	
	@Override
	public Equipo getEquipo() {
		return EquipoSoldadoRyan.getEquipo();
	}
	
}
