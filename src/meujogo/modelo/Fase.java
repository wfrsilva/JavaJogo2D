package meujogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
	private Image fundo;
	private Image nebulosa;
	private Player player;
	private  Timer timer;
	
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
		
		
	}//constructor
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(nebulosa, 0, 0, null);
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		
		
		g.dispose();
	}// paint

	@Override
	public void actionPerformed(ActionEvent e) {
			player.update();
			repaint();
		
	}//actionPerformed
	
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


