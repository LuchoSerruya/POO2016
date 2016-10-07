package elRescate;

import java.util.ArrayList;

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
			for(int j = 0; j < elementos.size(); i++){
				Elemento e2= elementos.get(i);
				// si se chocaron
				e1.chocarElemento(e2);
				e2.chocarElemento(e1);	
			}
		}
	}

	//TODO CLASE RECTAnnnnNNNNNNNnnNNnnNnGLEEEEEE
	
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