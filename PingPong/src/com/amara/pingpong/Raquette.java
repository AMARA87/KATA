package com.amara.pingpong;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/*La classe qui d�crit la raquette,son mouvement,son dessin et sa manipulation avec le clavier*/

public class Raquette {
	private static final int Y = 330;
	private static final int Largeur = 60;
	private static final int Hauteur = 10;
	int x = 115;
	int xa = 0;
	private Jeu jeu;

	public Raquette(Jeu jeu) {
		this.jeu= jeu;
	}
	/*m�thode move() redefinie pour d�crire le mouvement de la raquette*/
	public void move() {
		if (x + xa > 0 && x + xa < jeu.getWidth()-60)
			x = x + xa;
	}
	
/*m�thode qui dessine la raquette*/
	
	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}
	
/*l� quand on lache le clavier,on d�crit le comportement de la raquette (statique)*/
	
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
/*l� quand on presse sur le bouton droit ou gauche du clavier,
 * on d�crit comment �a se passe au fur et � mesure avec la vitesse du jeu*/
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -jeu.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = jeu.speed;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, Y, Largeur, Hauteur);
	}

	public int getTopY() {
		return Y;
	}
}
