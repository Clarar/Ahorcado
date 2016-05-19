package drawAhorcado;

import java.awt.Graphics;

public class DrawPiernaIzquierda extends DrawBrazoDerecho {
	
	protected int widthX2PI;
	protected int heightX2PI;
	
	public DrawPiernaIzquierda(){
		super();
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		
		widthX2PI 	= (int)(getWidth()*0.55)-8;
		heightX2PI 	= (int)(getHeight()*0.80)-8;
	}
	
	@Override
	public void moveRigth() {
		super.moveRigth();
		
		widthX2PI 	= (int)(getWidth()*0.55)+8;
		heightX2PI 	= (int)(getHeight()*0.80)-8;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		widthX2PI 	= 0;
		
		if (widthX2PI == 0) {
			if (position == 1) {
				moveLeft();
			}else if (position == 2) {
				widthX2PI 	= (int)(getWidth()*0.55);
				heightX2PI 	= (int)(getHeight()*0.80);
			}else{
				moveRigth();
			}
		}
		
		
		g.drawLine(	super.widthX2Tronco	, super.heightX2Tronco,
					widthX2PI			, heightX2PI);
	}

	
}
