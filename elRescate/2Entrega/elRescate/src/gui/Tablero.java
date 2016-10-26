package gui;
import elRescate.Elemento;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Tablero extends Canvas implements MouseMotionListener{
	

	
	public Tablero(){
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
