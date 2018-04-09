package com.amara.pingpong;

import java.awt.Graphics2D;
import java.awt.Rectangle;
/*La classe qui décrit la boule:son dessin,son mouvement,ses collisions,sa vitesse..*/
public class Boule {
	private static final int DIAMETERE = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Jeu jeu;

	public Boule(Jeu jeu) {
		this.jeu= jeu;
	}
/*méthode move() redefinie pour décrire le mouvement de la boule*/
	void move() {
		
		if (x + xa < 0)
			xa = jeu.speed;
			if (x + xa > jeu.getWidth() - DIAMETERE)
			xa = -jeu.speed;
			if (y + ya < 0)
			ya = 1;
			if (y + ya > jeu.getHeight() - DIAMETERE)
			jeu.gameOver();
			if (collision()){
			ya = -jeu.speed;
			y = jeu.raquette.getTopY() - DIAMETERE;
			jeu.speed++;
			} 
				
			x = x + xa;
			y = y + ya;

	}

	
/*méthode qui permet de dessiner la boule*/
	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETERE, DIAMETERE);
	}
/*méthode qui gère le moment de collision*/	
	private boolean collision() {
		return jeu.raquette.getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETERE, DIAMETERE);
	}

}
