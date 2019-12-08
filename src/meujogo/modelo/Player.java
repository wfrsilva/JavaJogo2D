package meujogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	
	public Player() {
		this.x= 100;
		this.y = 728/2;		
	}//constructor
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\spaceship.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}//load
	
	public void update() {
		x += dx;
		y += dy;
	}//update
	
	public void keypressed(KeyEvent tecla) {
		int codigo  = tecla.getKeyCode();
		
		if(codigo== KeyEvent.VK_UP) {
			dy = -3;
		}//if
		if(codigo== KeyEvent.VK_DOWN) {
			dy = 3;
		}//if		
		if(codigo== KeyEvent.VK_LEFT) {
			dx = -3;
		}//if
		if(codigo== KeyEvent.VK_RIGHT) {
			dx = 3;
		}//if
		
	}//Keypressed
	
	public void keyRelease(KeyEvent tecla) {
		int codigo  = tecla.getKeyCode();
		
		if(codigo== KeyEvent.VK_UP) {
			dy = 0;
		}//if
		if(codigo== KeyEvent.VK_DOWN) {
			dy = 0;
		}//if		
		if(codigo== KeyEvent.VK_LEFT) {
			dx = 0;
		}//if
		if(codigo== KeyEvent.VK_RIGHT) {
			dx = 0;
		}//if
		
	}//KeyRelease

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	

}//class
