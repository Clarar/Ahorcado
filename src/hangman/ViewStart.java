package hangman;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewStart extends JFrame {

	public ViewStart(){
		setLayout(new GridLayout(1,1));
		
		JPanel main = new JPanel();
		
		
		
		add(main);
		
	}

	public void setController(ControllerStart controller){
		
	}
	
	public void runGame(){
		pack();
		//setSize(700, 700);
	    setTitle("Hangman");
	    setLocationRelativeTo(null);   
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
}
