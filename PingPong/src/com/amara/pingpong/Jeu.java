package com.amara.pingpong;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*Cette classe est la classe principale*/

@SuppressWarnings("serial")
public class Jeu extends JPanel {
	
	Boule boule = new Boule(this);
	Raquette raquette = new Raquette(this);
	int speed = 1;
	
	private int getScore() {
		return speed - 1;
	}

	public Jeu() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raquette.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raquette.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	/*Méthode pour le mouvement de la boule et de la raquette,décrite pour chacun dans leurs classes respectives*/
	
	private void move() {
		boule.move();
		raquette.move();
	}
	
    /*méthode qui permet de dessiner la fenetre principale du jeu,le canvas,aussi bien que la boule et la raquette*/
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		boule.paint(g2d);
		raquette.paint(g2d);
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}
	
	/*méthode qui annonce la fin du jeu en affichant le score final*/
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Votre score est: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
		}


	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Ping Pong");
		Jeu jeu = new Jeu();
		frame.add(jeu);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			jeu.move();
			jeu.repaint();
			Thread.sleep(10);
		}
	}
}
