package com.amara.pingpong;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/*La classe qui décrit la raquette,son mouvement,son dessin et sa manipulation avec le clavier*/

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
	/*méthode move() redefinie pour décrire le mouvement de la raquette*/
	public void move() {
		if (x + xa > 0 && x + xa < jeu.getWidth()-60)
			x = x + xa;
	}
	
/*méthode qui dessine la raquette*/
	
	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}
	
/*là quand on lache le clavier,on décrit le comportement de la raquette (statique)*/
	
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
/*là quand on presse sur le bouton droit ou gauche du clavier,
 * on décrit comment ça se passe au fur et à mesure avec la vitesse du jeu*/
	
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
