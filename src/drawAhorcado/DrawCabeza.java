package drawAhorcado;

import java.awt.Graphics;

public class DrawCabeza extends DrawPatibulo {

		protected int widthCenter 	= 0;
		protected int heightCenter 	= 0;
		protected int width;
		protected int height;
		protected int position;			// 1 izquierda, 2 centro, 3 derecha
	
		public DrawCabeza(){
			super();
			position = 2;
		}
		
		public void setPosition(int pos){
			position = pos;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			width 		= (int)(getWidth()*0.1);
			height 		= (int)(getHeight()*0.1);
			
			widthCenter = 0;
			
			if (widthCenter == 0) {
				if (position == 1) {
					moveLeft();
				}else if(position == 2){
					widthCenter 	= (int)(((getWidth()*0.60)-(width/2)));
					heightCenter 	= (int)(((getHeight()*0.25)));
				}else{
					moveRigth();
				}
		    	
			}
			
			g.drawOval(widthCenter, heightCenter, width, height);
		}

		public void moveLeft() {
			widthCenter 	= (int)(getWidth()*0.60)-(width/2)-3;
			heightCenter 	= (int)(getHeight()*0.25)-2;
		}
		
		public void moveRigth() {
			widthCenter 	= (int)(getWidth()*0.60)-(width/2)+3;
			heightCenter 	= (int)(getHeight()*0.25)-2;
		}
}
