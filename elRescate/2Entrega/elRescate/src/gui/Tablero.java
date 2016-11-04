package gui;
import elRescate.Elemento;
import elRescate.EquipoJugador;
import elRescate.RobotJugador;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Tablero extends Canvas implements KeyListener{
	

	
	public Tablero(){
		this.addKeyListener(this);
	}

	/*
	@Override
	public void paint(Graphics g) {
		mostrar();
	}*/
	
	public void mostrar(ArrayList<Elemento> elementos){
		Graphics g = this.getGraphics();
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(this.getForeground());

		for(Elemento e : elementos){

			g.fillOval((int)e.getPos().getX(), (int)e.getPos().getY(), (int)e.getTam().getAncho(), (int)e.getTam().getAlto());
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("tecla pulsada");
			
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.MOVER_ABAJO);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.MOVER_ARRIBA);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.MOVER_DER);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.MOVER_IZQ);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.MOVER_IZQ);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.DISPARAR_MUNICION);
		}
		if (e.getKeyCode() == KeyEvent.VK_B){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(RobotJugador.LANZAR_BOMBA);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}

}
