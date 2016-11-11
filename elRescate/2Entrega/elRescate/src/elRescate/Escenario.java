package elRescate;

import java.util.ArrayList;
import gui.EscenarioListener;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Random;

/**
 * 
 * Clase administradora del juego
 * Sigue un patron SINGLETON
 */

public class Escenario{
	//lista de elementos
	private ArrayList<Elemento> elementos;
	private ArrayList<EscenarioListener> listeners;
	private static Escenario escenario = null;
	private Tamanio tamanioEscenario;
	private ZonaRescate zonaRescate;
	
	private int turnoBonus;
	
	private boolean pausado = false;
	
	Random rdm = new Random();
	/** 
	 * @return devuelve el escenario de juego
	 */
	public static Escenario getEscenario(){
		if(escenario == null){
			escenario = new Escenario(new Tamanio(Config.MAX_X, Config.MAX_Y));
		}
		return escenario;
	}
	
	
	/**
	 * Crea un escenario 
	 * @param tamanio
	 */
	
	/**
	 * Constructo privado del escenario (SINGLETON)
	 * @param tamanio
	 */
	private Escenario(Tamanio tamanio){
		this.elementos = new ArrayList<Elemento>();
		this.turnoBonus = 0;
		this.listeners = new ArrayList<EscenarioListener>();
		this.tamanioEscenario = tamanio;
	}
	
	/**
	 * Realiza espera
	 * @param millis cantidad de milisegundos a esperar
	 */
	public static void espera(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Inicia el juego
	 */
	public void iniciarJuego(){
		
		while(true){
		
			if(!pausado){

				aparecerBonus();
				
				//que jueguen todos
				turnos();
				
				this.turnoBonus++;
				
				//ver qué paso
				verificarChoques();
	
				//quitar elementos destruidos
				depurarElementos();
	
				mostrarUI();
				
				//mostrarEstado();
				
				espera(100);
			}
			else{

				espera(1000);
			}
			
		}
	}
	
	private void aparecerBonus() {
		if(turnoBonus == Bonus.turnoAparicion){
			int enOes = rdm.nextInt(2);
			//hay que agregar un bonus en la posicion random
			if(enOes % 2 == 0){
				Escenario.getEscenario().agregarElemento(new BonusEnergia(new Posicion(rdm.nextInt(Config.MAX_X), rdm.nextInt(Config.MAX_Y))));
			}
			else {
				Escenario.getEscenario().agregarElemento(new BonusEscudo(new Posicion(rdm.nextInt(Config.MAX_X), rdm.nextInt(Config.MAX_Y))));
			}
			this.turnoBonus = 0;
		}

	}


	private void mostrarUI(){
		for(EscenarioListener listener : listeners){
			listener.actualizar(this.elementos);
		}
	}	
	
	public void addEscenarioListener(EscenarioListener listener){
		listeners.add(listener);
	}
	
	/**
	 * Se fija si hay elementos para quitar del escenario y los quita
	 */
	private void depurarElementos() {
		Elemento elemento;
		for(int i = 0;i < this.elementos.size(); i++){
			elemento = elementos.get(i);
			//si tiene que ser quitado
			if(!elemento.estaVivo()){
				//se lo quita
				elemento.destruir();
			}
		}
	}
	
	
	public void pausa(){
		this.pausado = true;
		System.out.println("Pause");
	}
	
	public void reanudar(){
		this.pausado = false;
		System.out.println("Continuar");
	}
	/**
	 * Verifica las coliciónes entre elementos de juego
	 */
	private void verificarChoques() {
		Elemento e1, e2;
		for(int i = 0; i < elementos.size(); i++){
			//conseguimos tamaño y posicion de e1
			e1 = elementos.get(i);
			Rectangle rectanguloE1 = this.armarRectangulo(e1);
			
			for(int j = 0; j < elementos.size(); j++){
				//armo rectangulo de e2
				e2 = elementos.get(j);
				Rectangle rectanguloE2 = this.armarRectangulo(e2);
				
				//reviso si se intersectan, si se da, los choco
				if((rectanguloE1.intersects(rectanguloE2))&&(e1!=e2)){
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
		
		Elemento elemento;
		for(int i = 0;i < this.elementos.size(); i++){
			elemento = elementos.get(i);
			elemento.jugar();
		}
	}
	
	
	
	/**
	 * Agrega un elemento al escenario
	 * @param elemento Elemento a agregar
	 */
	public void agregarElemento(Elemento elemento){
		this.elementos.add(elemento);
	}
	
	/**
	 * Elimina de la lista de Elementos del Escenario
	 * un Elemento pasado por parametro
	 * @param elemento
	 */
	public void quitarElemento(Elemento elemento){
		this.elementos.remove(elemento);
	}
	
	
	/**
	 * 
	 * @param poligono
	 * @return lista con elementos que se encuentren dentro del poligono
	 */
	public ArrayList<Elemento> enArea(Polygon poligono){
		ArrayList<Elemento> listaElementos = new ArrayList<Elemento>();
		for(Elemento e: elementos){
			if(poligono.intersects(armarRectangulo(e))){
				listaElementos.add(e);
			}
		}
		
		return listaElementos;
	}
	
	/**
	 * Crea un Rectangulo a partir de un Elemento
	 * @param e
	 * @return el Rectangulo del Elemento
	 */
	private Rectangle armarRectangulo(Elemento e){
		Posicion posE = e.getPos();
		Tamanio tamE = e.getTam();
		return new Rectangle(
				posE.getX(), 
				posE.getY(),
				tamE.getAlto(), 
				tamE.getAncho());		
	}
	
	/**
	 * @return Zona de Rescate del escenario
	 */
	public ZonaRescate getZonaRescate(){
		if(this.zonaRescate == null)
			this.zonaRescate = new ZonaRescate();
		
		return this.zonaRescate;
	}
}