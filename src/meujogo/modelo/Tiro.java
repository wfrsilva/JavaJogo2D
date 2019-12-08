package meujogo.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro {
	
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	
	private static final int LARGURA = 938;
	private static int VELOCIDADE = 2;
	
	public Tiro (int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}//constructor
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\tiroSimples.png");
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}//load
	
	public void update() {
		this.x += VELOCIDADE;
		if (this.x > LARGURA) {
			isVisivel = false;
		}//if
	}//update
	

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	
}//class
