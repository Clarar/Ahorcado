package tool;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CenterMessage extends JPanel {
	
	String text;
	Font font;
	
	
	public CenterMessage(){
		this("");
	}
	
	public CenterMessage(String text){
		this.text = text;
		this.font = getFont();
	}
	
	public CenterMessage(String text, Font font){
		this.text = text;
		this.font = font;
	}
	
  @Override /** Paint the message */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Get font metrics for the current font
    FontMetrics fm = g.getFontMetrics(font);

    // Find the center location to display
    int stringWidth = fm.stringWidth(text);
    int stringAscent = fm.getAscent();

    // Get the position of the leftmost character in the baseline
    int xCoordinate = getWidth() / 2 - stringWidth / 2;
    int yCoordinate = getHeight() / 2 + stringAscent / 2;

    g.drawString(text, xCoordinate, yCoordinate);
  }
}