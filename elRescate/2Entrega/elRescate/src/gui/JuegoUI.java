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

import elRescate.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoUI extends JFrame implements EscenarioListener{

	private Tablero tablero;
	private JTextArea statsRobotJugador;
	private JTextArea statsSatelite1Jugador;
	private JTextArea statsSatelite2Jugador;
	private JTextArea statsRefugioJugador;
	JTextArea statsRobotSoldadoRyan;
	JTextArea statsRobotQuejoDido;
	JTextArea statsRobotRencoroso;
	JTextArea statsSatelite1SoldadoRyan;
	JTextArea statsSatelite1QuejoDido;
	JTextArea statsSatelite1Rencoroso;	
	JTextArea statsSatelite2SoldadoRyan;
	JTextArea statsSatelite2QuejoDido;
	JTextArea statsSatelite2Rencoroso;
	JTextArea statsRefugioQuejoDido;
	JTextArea statsRefugioSoldadoRyan;
	JTextArea statsRefugioRencoroso;
	

	
	public JuegoUI(){

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tablero = new Tablero();
		tablero.setBounds(0, 0, 594, 565);
		tablero.setBackground(Color.black);
		tablero.setForeground(Color.red);
		
		Escenario.getEscenario().addEscenarioListener(this);
				
		Container c = this.getContentPane();
		getContentPane().setLayout(null);

		c.add(tablero);
		
		JPanel panel = new JPanel();
		panel.setBounds(593, 0, 584, 565);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStats.setBounds(272, 11, 54, 14);
		panel.add(lblStats);
		
		JLabel lblEquipoJugador = new JLabel("Equipo Jugador");
		lblEquipoJugador.setBounds(10, 43, 95, 14);
		panel.add(lblEquipoJugador);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 30, 891, 2);
		panel.add(separator_1);
		
		JLabel lblRobot = new JLabel("Robot");
		lblRobot.setBounds(10, 61, 46, 14);
		panel.add(lblRobot);
		
		statsRobotJugador = new JTextArea();
		statsRobotJugador.setBounds(10, 79, 125, 108);
		statsRobotJugador.setEditable(false);
		panel.add(statsRobotJugador);
		
		JLabel lblSatelite = new JLabel("Satelite 1");
		lblSatelite.setBounds(10, 209, 60, 14);
		panel.add(lblSatelite);
		
		statsSatelite1Jugador = new JTextArea();
		statsSatelite1Jugador.setEditable(false);
		statsSatelite1Jugador.setBounds(10, 223, 125, 92);
		panel.add(statsSatelite1Jugador);
		
		JLabel lblSatelite_1 = new JLabel("Satelite 2");
		lblSatelite_1.setBounds(10, 352, 60, 14);
		panel.add(lblSatelite_1);
		
		statsSatelite2Jugador = new JTextArea();
		statsSatelite2Jugador.setEditable(false);
		statsSatelite2Jugador.setBounds(10, 364, 125, 92);
		panel.add(statsSatelite2Jugador);
		
		JLabel lblRefugio = new JLabel("Refugio");
		lblRefugio.setBounds(10, 493, 46, 14);
		panel.add(lblRefugio);
		
		statsRefugioJugador = new JTextArea();
		statsRefugioJugador.setEditable(false);
		statsRefugioJugador.setBounds(10, 507, 125, 47);
		panel.add(statsRefugioJugador);
		
		JLabel lblRyan = new JLabel("Equipo Soldado Ryan");
		lblRyan.setBounds(145, 43, 125, 14);
		panel.add(lblRyan);
		
		JLabel label = new JLabel("Robot");
		label.setBounds(145, 61, 46, 14);
		panel.add(label);
		
		statsRobotSoldadoRyan = new JTextArea();
		statsRobotSoldadoRyan.setEditable(false);
		statsRobotSoldadoRyan.setBounds(145, 79, 125, 108);
		panel.add(statsRobotSoldadoRyan);
		
		JLabel label_1 = new JLabel("Satelite 1");
		label_1.setBounds(145, 209, 60, 14);
		panel.add(label_1);
		
		statsSatelite1SoldadoRyan = new JTextArea();
		statsSatelite1SoldadoRyan.setEditable(false);
		statsSatelite1SoldadoRyan.setBounds(145, 223, 125, 92);
		panel.add(statsSatelite1SoldadoRyan);
		
		JLabel label_2 = new JLabel("Satelite 2");
		label_2.setBounds(145, 352, 60, 14);
		panel.add(label_2);
		
		statsSatelite2SoldadoRyan = new JTextArea();
		statsSatelite2SoldadoRyan.setEditable(false);
		statsSatelite2SoldadoRyan.setBounds(145, 364, 125, 92);
		panel.add(statsSatelite2SoldadoRyan);
		
		JLabel label_3 = new JLabel("Refugio");
		label_3.setBounds(145, 493, 46, 14);
		panel.add(label_3);
		
		statsRefugioSoldadoRyan = new JTextArea();
		statsRefugioSoldadoRyan.setEditable(false);
		statsRefugioSoldadoRyan.setBounds(145, 507, 125, 47);
		panel.add(statsRefugioSoldadoRyan);
		
		JLabel label_4 = new JLabel("Robot");
		label_4.setBounds(280, 61, 46, 14);
		panel.add(label_4);
		
		statsRobotRencoroso = new JTextArea();
		statsRobotRencoroso.setEditable(false);
		statsRobotRencoroso.setBounds(280, 79, 125, 108);
		panel.add(statsRobotRencoroso);
		
		JLabel label_5 = new JLabel("Satelite 1");
		label_5.setBounds(280, 209, 60, 14);
		panel.add(label_5);
		
		statsSatelite1Rencoroso = new JTextArea();
		statsSatelite1Rencoroso.setEditable(false);
		statsSatelite1Rencoroso.setBounds(280, 223, 125, 92);
		panel.add(statsSatelite1Rencoroso);
		
		JLabel label_6 = new JLabel("Satelite 2");
		label_6.setBounds(280, 352, 60, 14);
		panel.add(label_6);
		
		statsSatelite2Rencoroso = new JTextArea();
		statsSatelite2Rencoroso.setEditable(false);
		statsSatelite2Rencoroso.setBounds(280, 364, 125, 92);
		panel.add(statsSatelite2Rencoroso);
		
		JLabel label_7 = new JLabel("Refugio");
		label_7.setBounds(280, 493, 46, 14);
		panel.add(label_7);
		
		statsRefugioRencoroso = new JTextArea();
		statsRefugioRencoroso.setEditable(false);
		statsRefugioRencoroso.setBounds(280, 507, 125, 47);
		panel.add(statsRefugioRencoroso);
		
		JLabel label_8 = new JLabel("Robot");
		label_8.setBounds(415, 61, 46, 14);
		panel.add(label_8);
		
		statsRobotQuejoDido = new JTextArea();
		statsRobotQuejoDido.setEditable(false);
		statsRobotQuejoDido.setBounds(415, 79, 125, 108);
		panel.add(statsRobotQuejoDido);
		
		JLabel label_9 = new JLabel("Satelite 1");
		label_9.setBounds(415, 209, 60, 14);
		panel.add(label_9);
		
		statsSatelite1QuejoDido = new JTextArea();
		statsSatelite1QuejoDido.setEditable(false);
		statsSatelite1QuejoDido.setBounds(415, 223, 125, 92);
		panel.add(statsSatelite1QuejoDido);
		
		JLabel label_10 = new JLabel("Satelite 2");
		label_10.setBounds(415, 352, 60, 14);
		panel.add(label_10);
		
		statsSatelite2QuejoDido = new JTextArea();
		statsSatelite2QuejoDido.setEditable(false);
		statsSatelite2QuejoDido.setBounds(415, 364, 125, 92);
		panel.add(statsSatelite2QuejoDido);
		
		JLabel label_11 = new JLabel("Refugio");
		label_11.setBounds(415, 493, 46, 14);
		panel.add(label_11);
		
		statsRefugioQuejoDido = new JTextArea();
		statsRefugioQuejoDido.setEditable(false);
		statsRefugioQuejoDido.setBounds(415, 507, 125, 47);
		panel.add(statsRefugioQuejoDido);
		
		JLabel lblEquipoRencoroso = new JLabel("Equipo Rencoroso");
		lblEquipoRencoroso.setBounds(277, 42, 117, 14);
		panel.add(lblEquipoRencoroso);
		
		JLabel lblEquipoQuejodido = new JLabel("Equipo QuejoDido");
		lblEquipoQuejodido.setBounds(415, 43, 117, 14);
		panel.add(lblEquipoQuejodido);
		
		this.setSize(1200, 625);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		/*
		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mntmReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Escenario.getEscenario().reiniciar();
			}
		});
		mnJuego.add(mntmReiniciar);*/
		
		JMenuItem mntmPausar = new JMenuItem("Pausar");
		mntmPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Escenario.getEscenario().pausa();
			}
		});
		mnJuego.add(mntmPausar);
		
		JMenuItem mntmContinuar = new JMenuItem("Continuar");
		mntmContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Escenario.getEscenario().reanudar();
			}
		});
		mnJuego.add(mntmContinuar);
		
		JSeparator separator = new JSeparator();
		mnJuego.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		mnJuego.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		this.setVisible(true);	
		
		tablero.inicializar();
	}
 

	
	@Override
	public void actualizar(ArrayList<Elemento> elementos) {
		tablero.mostrar(elementos);
		statsEquipo(elRescate.EquipoJugador.getEquipo().getElementos(),
				statsRobotJugador,
				statsSatelite1Jugador,
				statsSatelite2Jugador,
				statsRefugioJugador);
		statsEquipo(elRescate.EquipoSoldadoRyan.getEquipo().getElementos(),
				statsRobotSoldadoRyan,
				statsSatelite1SoldadoRyan,
				statsSatelite2SoldadoRyan,
				statsRefugioSoldadoRyan);
		statsEquipo(elRescate.EquipoRencoroso.getEquipo().getElementos(),
				statsRobotRencoroso,
				statsSatelite1Rencoroso,
				statsSatelite2Rencoroso,
				statsRefugioRencoroso);
		statsEquipo(elRescate.EquipoQuejoDido.getEquipo().getElementos(),
				statsRobotQuejoDido,
				statsSatelite1QuejoDido,
				statsSatelite2QuejoDido,
				statsRefugioQuejoDido);

	}



	private void statsEquipo(
			ArrayList<Elemento> elementos, 
			JTextArea statsRobot,
			JTextArea statsSatelite1, 
			JTextArea statsSatelite2, 
			JTextArea statsRefugio) {
			
		boolean encontreSatelite = false; 
		for(Elemento e : elementos){
			if(e instanceof Robot){
				Robot robot = (Robot)e;
				statsRobot.setText(robot.toString());
			}
			else if(e instanceof Satelite){
				Satelite sat = (Satelite)e;
				if(!encontreSatelite){
					statsSatelite1.setText(sat.toString());
					encontreSatelite = true;
				} 
				else{
					statsSatelite2.setText(sat.toString());
				}
			}
			else if(e instanceof Refugio){
				Refugio refugio = (Refugio)e;
				statsRefugio.setText(refugio.toString());
			}
		}
	}
}
