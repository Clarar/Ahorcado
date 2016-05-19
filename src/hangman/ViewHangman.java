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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import drawAhorcado.DrawBrazoDerecho;
import drawAhorcado.DrawBrazoIzquierdo;
import drawAhorcado.DrawCabeza;
import drawAhorcado.DrawPiernaDerecha;
import drawAhorcado.DrawPiernaIzquierda;
import drawAhorcado.DrawTronco;
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
		panelCenter.getJbtn_pista().setEnabled(false);
	}
	public void setTextEnd(ImageIcon imagen){
		panelCenter.getJlbl_letra().setText("");
		panelCenter.getJlbl_image().setIcon(imagen);
		panelCenter.getJpl_letter().setBackground(Color.WHITE);;
		panelCenter.getJpl_letra().setVisible(false);
		panelCenter.getJtxt_palabra().setEnabled(false);
		panelCenter.getJbtn_palabra().setEnabled(false);
		panelCenter.getJchk_teclado().setEnabled(false);
		panelCenter.getJbtn_pista().setEnabled(false);
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
	
public void drawHangman(int mistake){
		
		switch (mistake) {
		case 1:
			
			panelCenter.setDrawHangman(new DrawCabeza());
			panelCenter.getDrawHangman().paintAll(panelCenter.getDrawHangman().getGraphics());
			break;
		case 2:
			panelCenter.setDrawHangman(new DrawTronco());
			panelCenter.getDrawHangman().paintAll(panelCenter.getDrawHangman().getGraphics());
			break;
		case 3:
			panelCenter.setDrawHangman(new DrawBrazoIzquierdo());
			panelCenter.getDrawHangman().paintAll(panelCenter.getDrawHangman().getGraphics());
			break;
		case 4:
			panelCenter.setDrawHangman(new DrawBrazoDerecho());
			panelCenter.getDrawHangman().paintAll(panelCenter.getDrawHangman().getGraphics());
			break;
		case 5:
			panelCenter.setDrawHangman(new DrawPiernaIzquierda());
			panelCenter.getDrawHangman().paintAll(panelCenter.getDrawHangman().getGraphics());
			break;
		case 6:
			DrawPiernaDerecha draw = new DrawPiernaDerecha();
			panelCenter.setDrawHangman(draw);
			timerDraw(draw);
			break;
		}
	}

	private void timerDraw(DrawPiernaDerecha hangman){
		Timer timer= new Timer();
	
	    TimerTask task = new TimerTask() {
	        int count = 1;
	        int i = 2;
	
	        @Override
	        public void run()
	        {
	        		hangman.setPosition(i);
	        		if (count%2==0) {
						i--;
					}else{
						i++;
					}
	        		
	        		if (i==1 || i==3){
	        			count++;
	        		}
	            
	        		panelCenter.getDrawHangman().paintAll(panelCenter.getDrawHangman().getGraphics());
	        }
	    };
	        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 500ms
	    timer.schedule(task, 10, 500);
	}
	
	public int newGame(){
		int confirmar = JOptionPane.showConfirmDialog(null,
									"¿Desea Empezar una nueva partida?", "Hangman", JOptionPane.YES_NO_OPTION);
		
		return confirmar;
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
