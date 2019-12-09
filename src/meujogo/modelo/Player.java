package meujogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List <Tiro> tiros;
	private boolean isVisivel;
	
	public Player() {
		this.x= 100;
		this.y = 728/2;	
		isVisivel= true;
		
		tiros = new ArrayList<Tiro>();
		
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
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x + (largura/2), y + (altura/2)));
	}//tirosimples
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	
	public void keypressed(KeyEvent tecla) {
		int codigo  = tecla.getKeyCode();
		
		if(codigo== KeyEvent.VK_A) {
			tiroSimples();
		}//if
		
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
	
	

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	

}//class
