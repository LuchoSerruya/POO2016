package elRescate;

import java.util.ArrayList;

/**
 * 
 * Administradora del juego
 * @author pablo
 *
 */

public class Escenario{

	/*
	 * Esto tendria que tener una coleccion y que jueguen todos
	 * 
	 * */
	
	private ArrayList<Elemento> elementos;
	
	
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
	
	public void turnos(){
		for(int i = 0;i < this.elementos.size(); i++){
			Elemento elemento = elementos.get(i);
			elemento.jugar();
		}
	}
	
	private void crearElementos(){
		this.elementos = new ArrayList<Elemento>();
	}
	
	
}