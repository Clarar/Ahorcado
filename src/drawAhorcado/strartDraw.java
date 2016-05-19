package drawAhorcado;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class strartDraw extends JFrame{

	public static void main(String[] args) {
		strartDraw frame = new strartDraw();
		
		//frame.pack();
		frame.setSize(700, 700);
		frame.setTitle("Hangman");
		frame.setLocationRelativeTo(null);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public strartDraw(){
		
		setLayout(new GridLayout(1, 1));
		
		DrawPiernaDerecha hangman = new DrawPiernaDerecha();
		
		add(hangman);
		
		Timer timer= new Timer();

	    TimerTask task = new TimerTask() {
	        int count = 1;
	        int i = 2;

	        @Override
	        public void run()
	        {
	        		hangman.setPosition(i);
	        		if (count%2==0) {
						i--;
					}else{
						i++;
					}
	        		
	        		if (i==1 || i==3){
	        			count++;
	        		}
	            
	            paintAll(getGraphics());
	        }
	    };
	        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 500ms
	    timer.schedule(task, 10, 500);
		
	}

}
