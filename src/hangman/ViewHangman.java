package hangman;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import drawAhorcado.DrawCabeza;
import viewPanel.ViewPanelCenter;
import viewPanel.ViewPanelFoot;
import viewPanel.ViewPanelHead;

import viewPanel.*;
public class ViewHangman extends JFrame {
	
	protected ViewPanelCenter panelCenter;
	protected ViewPanelHead panelHead;
	protected ViewPanelFoot panelFoot;
	
	public ViewHangman(){
		setLayout(new BorderLayout(5,5));
		panelCenter = new ViewPanelCenter();
		panelHead = new ViewPanelHead();
		panelFoot = new ViewPanelFoot(); 
		
		add(panelHead,BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);
		add(panelFoot,BorderLayout.SOUTH);
		
		
		//clase anonima
		panelCenter.getJchk_teclado().addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	panelFoot.setVisible(panelCenter.getJchk_teclado().isSelected());
		        	panelCenter.getJbtn_letra().setEnabled(!panelCenter.getJchk_teclado().isSelected());
		        	panelCenter.getJtxt_letra().setEnabled(!panelCenter.getJchk_teclado().isSelected());
		        } else {
		        	panelFoot.setVisible(panelCenter.getJchk_teclado().isSelected());
		        	panelCenter.getJbtn_letra().setEnabled(!panelCenter.getJchk_teclado().isSelected());
		        	panelCenter.getJtxt_letra().setEnabled(!panelCenter.getJchk_teclado().isSelected());
		        }
		    }
		});
		
		startButtonVisible(true);
		
		/*addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	panelFoot.setVisible(panelCenter.jchk_teclado.isSelected());
		        } else {
		        	panelFoot.setVisible(panelCenter.jchk_teclado.isSelected());
		        }
		    }
		});*/
		
		/*addMouseListener(new MouseAdapter() { 
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.getSource() == panelCenter.jchk_teclado) {
					panelFoot.setVisible(panelCenter.jchk_teclado.isSelected());
				}
			} 
			});*/
		
	}
	
	public void startButtonVisible(boolean visible){
		
		panelCenter.getJbtn_start().setVisible(visible);
		
		if (!panelCenter.getJbtn_start().isVisible()) {
			panelCenter.getPl1().setBorder(BorderFactory.createEtchedBorder());
			panelCenter.getJlbl_maskWord().setVisible(true);
			panelCenter.getJbtn_pista().setVisible(true);
			panelCenter.getJbtn_pista().setEnabled(false);
			panelCenter.getDrawHangman().setVisible(true);
			panelCenter.getJchk_teclado().setEnabled(true);
			panelCenter.getJtxt_letra().setEnabled(true);
			panelCenter.getJbtn_letra().setEnabled(true);
		}
	}
	
	public void setTextError(String textError){
		panelCenter.getJlbl_error().setText(textError);
		panelCenter.getJlbl_error().setVisible(true);
		panelCenter.getJlbl_error().setForeground(Color.RED);
		
	}
	
	public void setTextEnd(String textError){
		panelCenter.getJlbl_letra().setText(textError);
		panelCenter.getJlbl_letra().setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		panelCenter.getJtxt_letra().setForeground(Color.BLUE);
		panelCenter.getJtxt_letra().setVisible(false);
		panelCenter.getJbtn_letra().setVisible(false);
		panelCenter.getJtxt_palabra().setEnabled(false);
		panelCenter.getJbtn_palabra().setEnabled(false);
		panelCenter.getJchk_teclado().setEnabled(false);
	}
	public void setTextEnd(ImageIcon imagen){
		panelCenter.getJlbl_letra().setText("");
		//panelCenter.setDrawHangman(new drawImageEnd(imagen));
		panelCenter.getJlbl_image().setIcon(imagen);
		//panelCenter.getJpl_letter().add(new drawImageEnd(imagen.getImage()));
		//panelCenter.getJlbl_letra().setVisible(false);
		panelCenter.getJpl_letter().setBackground(Color.WHITE);;
		panelCenter.getJpl_letra().setVisible(false);
		//panelCenter.getJlbl_letra().setEnabled(false);
		//panelCenter.getJtxt_letra().setEnabled(false);
		//panelCenter.getJbtn_letra().setEnabled(false);
		panelCenter.getJtxt_palabra().setEnabled(false);
		panelCenter.getJbtn_palabra().setEnabled(false);
		panelCenter.getJchk_teclado().setEnabled(false);
	}
	
	public void run(){
		setSize(700, 700);
	    setTitle("Hangman");
	    setLocationRelativeTo(null); // Center the frame   
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	public void setController(ControllerHangman controller){
		panelFoot.setActionButton(controller);
		panelCenter.getJtxt_letra().addKeyListener(controller);
		panelCenter.getJtxt_palabra().addKeyListener(controller);
		panelCenter.getJbtn_start().addActionListener(controller);
		panelCenter.getJbtn_palabra().addActionListener(controller);
		panelCenter.getJbtn_letra().addActionListener(controller);
		panelCenter.getJbtn_pista().addActionListener(controller);
	}
	
	class drawImageEnd extends JPanel{
		
		private Image imagen;
		
		public drawImageEnd(Image imagen){
			this.imagen = imagen;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(imagen, 0, 0, 400,200,null);
		}
	}
}
