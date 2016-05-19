package drawAhorcado;

import java.awt.Graphics;

public class DrawBrazoIzquierdo extends DrawTronco{
	
	protected int heightX1BI;
	protected int widthX1BI;
	protected int heightX2BI;
	protected int widthX2BI;
	
	public DrawBrazoIzquierdo(){
		super();
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		
		heightX2BI 	= (int)(getHeight()*0.4)-3;
		widthX2BI 	= (int)(getWidth()*0.6)-3;
		
		widthX1BI 	= (int)(getWidth()*0.55)-8;
		heightX1BI 	= (int)(getHeight()*0.5)-8;
		
	}
	
	
	@Override
	public void moveRigth() {
		super.moveRigth();
		
		heightX2BI 	= (int)(getHeight()*0.4)-3;
		widthX2BI 	= (int)(getWidth()*0.6)+3;
		
		widthX1BI 	= (int)(getWidth()*0.55)+8;
		heightX1BI 	= (int)(getHeight()*0.5)-8;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		widthX1BI = 0;
		
		if (widthX1BI == 0) {
			if (position == 1) {
				moveLeft();
			}else if (position == 2) {
				widthX2BI 	= (int)(getWidth()*0.6);
				heightX2BI	= (int)(getHeight()*0.4);
				
				widthX1BI 	= (int)(getWidth()*0.55);
				heightX1BI 	= (int)(getHeight()*0.5);
			}else{
				moveRigth();
			}
		}
		
		g.drawLine(	widthX2BI, heightX2BI,
					widthX1BI, heightX1BI );
	}
}
