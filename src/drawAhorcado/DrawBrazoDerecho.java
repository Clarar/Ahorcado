package drawAhorcado;

import java.awt.Graphics;

public class DrawBrazoDerecho extends DrawBrazoIzquierdo {
	
	protected int heightX2BD;
	protected int widthX2BD;
	
	public DrawBrazoDerecho(){
		super();
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		
		widthX2BD 	= (int)(getWidth()*0.65)-8;
		heightX2BD 	= (int)(getHeight()*0.5)-8;
	}
	
	@Override
	public void moveRigth() {
		super.moveRigth();
		
		widthX2BD 	= (int)(getWidth()*0.65)+8;
		heightX2BD 	= (int)(getHeight()*0.5)-8;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		widthX2BD	= 0;
		
		if (widthX2BD == 0) {
			if (position == 1) {
				moveLeft();
			}else if (position == 2) {
				widthX2BD 	= (int)(getWidth()*0.65);
				heightX2BD 	= (int)(getHeight()*0.5);
			}else{
				moveRigth();
			}
		}
		
		
		g.drawLine(	super.widthX2BI	, super.heightX2BI,
					widthX2BD		, heightX2BD);
	}
}
