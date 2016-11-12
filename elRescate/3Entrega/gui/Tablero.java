package gui;
import elRescate.*;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Tablero extends Canvas implements KeyListener{
	private HashMap<String, BufferedImage> imagenes;

	
	public Tablero(){
		this.addKeyListener(this);
	}

	/*
	@Override
	public void paint(Graphics g) {
		mostrar();
	}*/
	
	
	private void limpiar(){
		this.getG2D().drawImage(getImagen("fondo3",Config.MAX_X, Config.MAX_Y), 0, 0, getWidth(), getHeight(), null);
	}
	
	public void mostrar(ArrayList<Elemento> elementos){
		
		limpiar();

		for(Elemento e : elementos){
			this.dibujarElemento(e);
						
		}
		this.getBufferStrategy().show();
		
	}
	
	private Graphics2D getG2D(){
		
		if (this.getBufferStrategy() == null)
			return (Graphics2D) this.getGraphics();
		else 
			return (Graphics2D)this.getBufferStrategy().getDrawGraphics();		
	}

	private BufferedImage getImagen(String key, int ancho, int alto){

		if (imagenes == null)
			imagenes = new HashMap<String, BufferedImage>();
		
		BufferedImage img = imagenes.get(key);

		if (img == null) {
			img = cargarImagen(System.getProperty("user.dir") + File.separator + "png" + File.separator + key + ".png");
			
			if (img != null){

				if (key != "fondo")
					img = cambiarTamanio(img, ancho, alto);
				
				imagenes.put(key, img);
			}
		}
		
		return img;
	}
	
	private BufferedImage cargarImagen(String fileName){
		try {
			return ImageIO.read(new File(fileName));
		} catch (Exception e) {
			System.out.println("No se encontro la imagen " + fileName);

			return null;
		}
		
	}
	
	private BufferedImage cambiarTamanio(BufferedImage img, int ancho, int alto){

		BufferedImage newImage = new BufferedImage(ancho,alto, BufferedImage.TYPE_INT_RGB);

		Graphics g = newImage.createGraphics();
		g.drawImage(img, 0, 0, ancho, alto, null);
		g.dispose();
		
		return newImage;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.MOVER_ABAJO);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.MOVER_ARRIBA);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.MOVER_DER);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.MOVER_IZQ);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.MOVER_IZQ);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.DISPARAR_MUNICION);
		}
		if (e.getKeyCode() == KeyEvent.VK_B){
			EquipoJugador.getEquipo().getRobot().setAccionTeclado(Config.LANZAR_BOMBA);
		}
		
	}

	public void inicializar() {

		this.setFocusable(true);
		
		//Crea dos buffers para dibujar.
		this.createBufferStrategy(2);
		
		this.addKeyListener(this);
	}

	public BufferedImage rotar(BufferedImage image, double angulo){
		Dimension dim = calcularDimension(image, angulo);

		int w2 = (int)dim.getWidth();
		int h2 = (int)dim.getHeight();		

		int w = image.getWidth();
		int h = image.getHeight();		

		BufferedImage image2 = new BufferedImage(w2, h2, BufferedImage.TRANSLUCENT);

		Graphics2D g2d = (Graphics2D)image2.getGraphics();

		double x = (w2- w) / 2.0;
		double y = (h2-h) / 2.0;

		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(Math.toRadians(angulo), w/2, h/2);

		g2d.drawRenderedImage(image, at);

		return image2;
	}

	private Dimension calcularDimension(BufferedImage img, double angulo){
		double w = (double)img.getWidth();
		double h = (double)img.getHeight();

		double x1 = Math.abs(w * Math.cos(Math.toRadians(angulo))); 
		double x2 = Math.abs(h * Math.sin(Math.toRadians(angulo)));

		double y1 = Math.abs(h * Math.cos(Math.toRadians(angulo))); 
		double y2 = Math.abs(w * Math.sin(Math.toRadians(angulo)));

		return new Dimension((int)(x1+x2), (int)(y1+y2));
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	
	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	private void dibujarElemento(Elemento elem){
		if(elem instanceof Robot){
			Robot r = (Robot)elem;
			dibujarElemento(r);
		}
		else if(elem instanceof Satelite){
			Satelite s = (Satelite)elem;
			dibujarElemento(s);
		}
		else if(elem instanceof Municion){
			Municion m = (Municion)elem;
			dibujarElemento(m);
		}
		else if(elem instanceof Bomba){
			Bomba b = (Bomba)elem;
			dibujarElemento(b);
		}
		else if(elem instanceof Refugio){
			Refugio r = (Refugio)elem;
			dibujarElemento(r);
		}
		else if(elem instanceof ZonaRescate){
			ZonaRescate z =(ZonaRescate)elem;
			dibujarElemento(z);
		}
		else if(elem instanceof Bonus){
			Bonus bo = (Bonus)elem;
			dibujarElemento(bo);
		}
	}
	
	private void dibujarElemento(Robot elem){
		BufferedImage robot = getImagen("robot",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		robot = rotar(robot, elem.getDireccion());
		
		this.getG2D().drawImage(robot, elem.getPos().getX(), elem.getPos().getY(), null);		
	}
	
	private void dibujarElemento(Satelite elem){
		BufferedImage satelite = getImagen("satelite",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		
		this.getG2D().drawImage(satelite, elem.getPos().getX(), elem.getPos().getY(), null);
	}
	
	private void dibujarElemento(Bomba elem){
		BufferedImage bomba = getImagen("bomba",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		bomba = rotar(bomba, elem.getDireccion());
		
		bomba = cambiarTamanio(bomba,elem.getTam().getAncho(),elem.getTam().getAlto());
		this.getG2D().drawImage(bomba, elem.getPos().getX(), elem.getPos().getY(), null);
	}
	
	private void dibujarElemento(Municion elem){
		BufferedImage municion = getImagen("municion",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		municion = rotar(municion, elem.getDireccion());
		
		this.getG2D().drawImage(municion, elem.getPos().getX(), elem.getPos().getY(), null);
	}
	
	private void dibujarElemento(Refugio elem){
		BufferedImage refugio = getImagen("refugio",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		refugio = rotar(refugio, 0);
		
		this.getG2D().drawImage(refugio, elem.getPos().getX(), elem.getPos().getY(), null);
	}
	
	private void dibujarElemento(ZonaRescate elem){
		BufferedImage zonaRescate = getImagen("zonaRescate",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		zonaRescate = rotar(zonaRescate, 0);
		
		this.getG2D().drawImage(zonaRescate, elem.getPos().getX(), elem.getPos().getY(), null);
	}
	
	private void dibujarElemento(Bonus elem){
		BufferedImage bonus = getImagen("bonus",elem.getTam().getAncho(),elem.getTam().getAlto());
		
		bonus = rotar(bonus, 0);
		
		this.getG2D().drawImage(bonus, elem.getPos().getX(), elem.getPos().getY(), null);
		
	}
		
}
