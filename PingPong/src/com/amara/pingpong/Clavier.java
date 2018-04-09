package com.amara.pingpong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/*la classe qui permet de lire le clavier par notre jeu*/

@SuppressWarnings("serial")
public class Clavier extends JPanel {
	
	public Clavier() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}
	
	/*La classe listener qui permet de recevoir ce qu'on tape sur le clavier afin de pouvoir gérer les mouvements dans notre jeu*/
	
	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	}
}
