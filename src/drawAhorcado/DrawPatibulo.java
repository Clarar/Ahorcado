package drawAhorcado;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPatibulo extends JPanel {
	
	public DrawPatibulo(){
		setBackground(Color.WHITE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		int height = getHeight();
		int width = getWidth();
		
	    super.paintComponent(g);
	    
	    //pie
	    g.drawLine(	(int)(((width*0.30))), (int)(((height*0.9))), 		//primer punto
	    			(int)(((width*0.70))), (int)(((height*0.9))));		//segundo punto
	    //cuerpo
	    g.drawLine(	(int)(((width*0.35))), (int)(((height*0.15))), 
	    			(int)(((width*0.35))), (int)(((height*0.9))));
	    
	    g.drawLine(	(int)(((width*0.40))), (int)(((height*0.15))), 
    			(int)(((width*0.35))), (int)(((height*0.20))));
	    
	    //cabeza
	    g.drawLine(	(int)(((width*0.35))), (int)(((height*0.15))), 
	    			(int)(((width*0.60))), (int)(((height*0.15))));
	    //cuerda
	    g.drawLine(	(int)(((width*0.60))), (int)(((height*0.15))), 
    				(int)(((width*0.60))), (int)(((height*0.25))));
	    
	}
}
