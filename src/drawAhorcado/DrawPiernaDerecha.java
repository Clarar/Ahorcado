package drawAhorcado;

import java.awt.Graphics;

public class DrawPiernaDerecha extends DrawPiernaIzquierda {
	
	protected int widthX2PD;
	protected int heightX2PD;
	
	public DrawPiernaDerecha(){
		super();
	}
	
	@Override
	public void moveLeft(){
		super.moveLeft();
		
		widthX2PD 	= (int)(getWidth()*0.65)-8;
		heightX2PD 	= (int)(getHeight()*0.80)-8;
	}
	
	@Override
	public void moveRigth() {
		super.moveRigth();
		
		widthX2PD 	= (int)(getWidth()*0.65)+8;
		heightX2PD 	= (int)(getHeight()*0.80)-8;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		heightX2PD 	= 0;
		
		if (heightX2PD == 0) {
			if (position == 1) {
				moveLeft();
			}else if (position == 2) {
				widthX2PD 	= (int)(getWidth()*0.65);
				heightX2PD 	= (int)(getHeight()*0.80);
			}else{
				moveRigth();
			}
		}
		
		g.drawLine(	super.widthX2Tronco	, super.heightX2Tronco,
					widthX2PD			, heightX2PD);
	}
}
