package gui;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import elRescate.Elemento;
import elRescate.Escenario;

public class JuegoUI extends JFrame implements EscenarioListener, MouseListener  {

	private Tablero tablero;
	
	public JuegoUI(){

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tablero = new Tablero();
		tablero.setBackground(Color.black);
		tablero.setForeground(Color.red);
		
		Escenario.getEscenario().addEscenarioListener(this);
				
		Container c = this.getContentPane();
		
		c.setLayout(new BorderLayout());

		c.add(tablero, BorderLayout.CENTER);
		
		this.setSize(400, 400);
		this.setVisible(true);	
	}
 

	/*
	public void iniciar(Modelo modelo){
		this.modelo = modelo;
		
		this.modelo.addModeloListener(this);
		this.tablero.addMouseListener(this);

		this.tablero.setModelo(modelo);		

		this.setVisible(true);
	}*/


	@Override
	public void actualizar(ArrayList<Elemento> elementos) {
		tablero.mostrar(elementos);
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		
	}



	@Override
	public void mousePressed(MouseEvent e) {

		
	}



	@Override
	public void mouseReleased(MouseEvent e) {

		
	}



	
 
}
