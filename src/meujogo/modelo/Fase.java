package meujogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
	private Image fundo;
	private Image nebulosa;
	private Player player;
	private  Timer timer;
	private List<Inimigo1> inimigo1;
	private List<Nebula> nebulas;
	private boolean emJogo;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\background.jpg");
		fundo  = referencia.getImage();
		ImageIcon iiNebulosa = new ImageIcon("res\\Nebula2.png");
		nebulosa  = iiNebulosa.getImage();
		
		player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();
		
		inicializaInimigos();
		inicializaNebulas();
		emJogo = true;
		
		
	}//constructor
	
	public void inicializaInimigos() {
		int coordenadas [] = new int [40];
		inimigo1 = new ArrayList<Inimigo1>();
		
		for (int i = 0; i < coordenadas.length; i++) {
			int x  = (int)(Math.random() * 8000+1024);
			int y =  (int)(Math.random() * 650+30);
			inimigo1.add(new Inimigo1(x,y));
		}//for
		
	}//inicializaInimigos
	
	
	public void inicializaNebulas() {
		int coordenadas [] = new int [3];
		nebulas = new ArrayList<Nebula>();
		
		for (int i = 0; i < coordenadas.length; i++) {
			int x  = (int)(Math.random() * 1050+1024);
			int y =  (int)((Math.random() * 768)  - (Math.random() * 768));
			nebulas.add(new Nebula(x,y));
		}//for
	}//inicializaNebulas
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if(emJogo==true) {
			graficos.drawImage(fundo, 0, 0, null);
			//graficos.drawImage(nebulosa, 0, 0, null);
			
			for(int j = 0; j < nebulas.size();j++) {
				Nebula n = nebulas.get(j);
				n.load();
				graficos.drawImage(n.getImagem(), n.getX(), n.getY(), this);
			}//for
			
			
			
			
			List <Tiro> tiros = player.getTiros();
			for(int i = 0; i < tiros.size();i++) {
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}//for
			
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this); ///inverti aqui com o original, para  a nave ficar aciam do tro, visualmente fica mais bonito
			
			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 in = inimigo1.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(),in.getY(), this);
			}//for
		}//if
		else {
			ImageIcon fimJogo = new ImageIcon("..\\res\\fimdejogo.png");
			graficos.drawImage(fimJogo.getImage(), 0,0,1024,728, null);
		}//else
		
		g.dispose();
		
	}// paint

	@Override
	public void actionPerformed(ActionEvent e) {
			player.update();
			
			for (int p = 0; p < nebulas.size(); p++) {
				Nebula on = nebulas.get(p);
				if(on.isVisivel()) {
					on.update();
				}//if
				else {
					nebulas.remove(p);
				}//else
			}//for
			
			List <Tiro> tiros = player.getTiros();
			for(int i = 0; i < tiros.size();i++) {
				Tiro m = tiros.get(i);
				if(m.isVisivel()){
					m.update();
				}//if
				else {
					tiros.remove(i);
				}//else
			}//for
			
			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 in = inimigo1.get(o);
				if(in.isVisivel()) {
					in.update();
				}//if
				else {
					inimigo1.remove(o);
				}//else
				
			}//for
			
			checarColisoes();
			
			repaint();
		
	}//actionPerformed
	
	public void checarColisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaInimigo1;
		Rectangle formaTiro ;
		
		for (int i = 0; i < inimigo1.size(); i++) {
			Inimigo1 tempInimigo1 = inimigo1.get(i);
			formaInimigo1 = tempInimigo1.getBounds();
			if(formaNave.intersects(formaInimigo1)) {
				player.setVisivel(false);
				tempInimigo1.setVisivel(false);
				emJogo = false;
			}//if
		}//for
		
		List<Tiro> tiros = player.getTiros();
		
		for (int j = 0; j < tiros.size(); j++) {
			Tiro tempTiro = tiros.get(j);
			formaTiro = tempTiro.getBounds();
			for (int k = 0; k < inimigo1.size(); k++) {
				Inimigo1 tempInimigo1 = inimigo1.get(k);
				formaInimigo1 = tempInimigo1.getBounds();
				if(formaTiro.intersects(formaInimigo1)) {
					tempInimigo1.setVisivel(false);
					tempTiro.setVisivel(false);
				}//if
			}//for
		}//for
		
	}//checarColisoes
	
	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			player.keypressed(e);
		}//keyPressed
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}//keyRelease
		
	}//class TecladoAdapter

}//class


