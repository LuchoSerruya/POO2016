package elRescate;

import java.util.ArrayList;

import java.awt.Rectangle;

/**
 * 
 * Clase administradora del juego
 * Sigue un patron SINGLETON
 */

public class Escenario{
	//lista de elementos
	private ArrayList<Elemento> elementos;
	private static Escenario escenario;
	private Tamanio tamanioEscenario;
	/** 
	 * @return devuelve el escenario de juego
	 */
	public static Escenario getEscenario(){
		if(escenario == null){
			escenario = new Escenario(new Tamanio(Posicion.MAX_X, Posicion.MAX_Y));
		}
		return escenario;
	}
	
	/**
	 * Crea un escenario 
	 * @param tamanio
	 */
	private Escenario(Tamanio tamanio){
		this.crearListaElementos();
		this.tamanioEscenario = tamanio;
	}
	
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
		
		for (Elemento elemento : elementos){
			//Elemento elemento = elementos.get(i);
			//si tiene que ser quitado
			if(!elemento.estaVivo()){
				//se lo quita
				elemento.destruir();
			}
		}
	}
			
			/*
		for(int i = 0;i < this.elementos.size(); i++){
			Elemento elemento = elementos.get(i);
			//si tiene que ser quitado
			if(!elemento.estaVivo()){
				//se lo quita
				elemento.destruir();
			}
		}
	}*/
	
			
	/**
	 * Verifica las coliciónes entre elementos de juego
	 */
	private void verificarChoques() {
		for(Elemento e1 : elementos){
			//conseguimos tamaño y posicion de e1
			Posicion posE1 = e1.getPos();
			Tamanio tamE1 = e1.getTam();
			Rectangle rectanguloE1 = new Rectangle(
					tamE1.getAlto(), 
					tamE1.getAncho(), 
					posE1.getX(), 
					posE1.getY());
			
			for(Elemento e2 : elementos){
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
	
	/*
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
	}*/
	
	/**
	 * Otorga un turno de juego a cada elemento del escenario
	 */
	public void turnos(){
		for(Elemento elemento : elementos){
			elemento.jugar();
		}
	}
	
	/*
		for(int i = 0;i < this.elementos.size(); i++){
			Elemento elemento = elementos.get(i);
			elemento.jugar();
		}
	}*/
	
	/**
	 * Crea los elementos del juego
	 */
	private void crearListaElementos(){
		this.elementos = new ArrayList<Elemento>();
	}
	
	/**
	 * Agrega un elemento al escenario
	 * @param elemento Elemento a agregar
	 */
	public void agregarElemento(Elemento elemento){
		this.elementos.add(elemento);
	}
	
	public Tamanio getTamanio(){
		return this.tamanioEscenario;
	}
	
}