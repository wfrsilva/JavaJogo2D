package meujogo;

import javax.swing.JFrame;

import meujogo.modelo.Fase;

public class Container extends JFrame{
  
	public Container (){
		add(new Fase());
    	setTitle("Meu jogo");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}// constructor
             
	public static void main (String [] args){
		new Container();
	}// main
    
  
}//class Container
