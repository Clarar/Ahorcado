package drawAhorcado;

import java.awt.Graphics;

public class DrawTronco extends DrawCabeza {
	
	protected int widthX1Tronco;
	protected int heightX1Tronco;
	protected int widthX2Tronco;
	protected int heightX2Tronco;
	
	public DrawTronco(){
		super();
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		
		widthX1Tronco 	= (int)(getWidth()*0.6)-3;
		heightX1Tronco 	= (int)(getHeight()*0.35)-3;
		
		widthX2Tronco 	= (int)(getWidth()*0.6)-8;
		heightX2Tronco 	= (int)(getHeight()*0.65)-8;
		
	}
	
	@Override
	public void moveRigth() {
		super.moveRigth();
		
		widthX1Tronco 	= (int)(getWidth()*0.6)+3;
		heightX1Tronco 	= (int)(getHeight()*0.35)-3;
		
		widthX2Tronco 	= (int)(getWidth()*0.6)+8;
		heightX2Tronco 	= (int)(getHeight()*0.65)-8;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		widthX1Tronco = 0;
		
		if (widthX1Tronco == 0) {
			if (position == 1) {
				moveLeft();
			}else if(position == 2){
				widthX1Tronco 	= (int)(getWidth()*0.6);
				heightX1Tronco 	= (int)(getHeight()*0.35);
				
				widthX2Tronco 	= (int)(getWidth()*0.6);
				heightX2Tronco 	= (int)(getHeight()*0.65);
			}else{
				moveRigth();
			}
		}
		
		g.drawLine(	widthX1Tronco, heightX1Tronco,
					widthX2Tronco, heightX2Tronco );
	}

	
}
