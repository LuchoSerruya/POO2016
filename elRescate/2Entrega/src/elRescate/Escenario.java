package elRescate;

import java.util.ArrayList;

import java.awt.Rectangle;

/**
 * 
 * Clase administradora del juego
 */

public class Escenario{
	//lista de elementos
	private ArrayList<Elemento> elementos;
	
	/**
	 * Inicia el juego
	 */
	public void iniciarJuego(){
		//crearElementos();
		
		while(true){
			//que jueguen todos
			turnos();
			//ver qué paso
			verificarChoques();
			//quitar los que haya que
			depurarElementos();
		}
	}
	
	/**
	 * Se fija si hay elementos para quitar del escenario y los quita
	 */
	private void depurarElementos() {
		for(int i = 0;i < this.elementos.size(); i++){
			Elemento elemento = elementos.get(i);
			//si tiene que ser quitado
			if(!elemento.estaVivo()){
				//se lo quita
				elemento.destruir();
			}
			
		}
		
	}

	/**
	 * Verifica las coliciónes entre elementos de juego
	 */
	private void verificarChoques() {
		for(int i = 0; i < elementos.size(); i++){
			Elemento e1= elementos.get(i);
			
			//conseguimos tamaño y posicion de e1
			Posicion posE1 = e1.getPos();
			Tamanio tamE1 = e1.getTam();
			Rectangle rectanguloE1 = new Rectangle(
					tamE1.getAlto(), 
					tamE1.getAncho(), 
					posE1.getX(), 
					posE1.getY());
			
			for(int j = 0; j < elementos.size(); i++){
				Elemento e2= elementos.get(i);
	
				//armo rectangulo de e2
				Posicion posE2 = e2.getPos();
				Tamanio tamE2 = e2.getTam();
				Rectangle rectanguloE2 = new Rectangle(
						tamE2.getAlto(), 
						tamE2.getAncho(), 
						posE2.getX(), 
						posE2.getY());
				
				//reviso si se intersectan, si se da, los choco
				if(rectanguloE1.intersects(rectanguloE2)){
					e1.chocarElemento(e2);
					e2.chocarElemento(e1);
				}
				
					
			}
		}
	}

	
	
	/**
	 * Otorga un turno de juego a cada elemento del escenario
	 */
	public void turnos(){
		for(int i = 0;i < this.elementos.size(); i++){
			Elemento elemento = elementos.get(i);
			elemento.jugar();
		}
	}
	
	/**
	 * Crea los elementos del juego
	 */
	private void crearElementos(){
		this.elementos = new ArrayList<Elemento>();
	}
	
	
}