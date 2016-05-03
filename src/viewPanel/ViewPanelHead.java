package viewPanel;
import tool.CenterMessage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPanelHead extends JPanel {
	
	private String[] languages = {"Elija un idioma...","Español", "Ingles"};
	private JComboBox language;
	
	public JComboBox getLanguage() {
		return language;
	}

	public ViewPanelHead(){
		
		setLayout(new GridLayout(1,2));
		Font myfont = new Font("Eras Light ITC", Font.BOLD, 50);
		CenterMessage tittle = new CenterMessage("El horcado", myfont);
		JPanel languagesCombo = languagesCombo();
		
		tittle.setFont(myfont);
		
		//JPanel tittle = new ImageTittle(new ImageIcon("image/tittle.jpg").getImage());
		
		add(tittle);
		add(languagesCombo);
		
	}
	
	private JPanel languagesCombo(){
		
		JPanel p = new JPanel();
		
		language = new JComboBox(languages);
		language.setName("language");
		
		p.setLayout(new FlowLayout(FlowLayout.RIGHT,30,30));
		
		p.add(language);
		
		return p;
	}
	
	class ImageTittle extends JPanel {
		private Image tittle;
		public  ImageTittle(Image tittle){
			this.tittle = tittle;
		}
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(tittle,0,0,200, 100, null);
		}
		
	} 
	
}
