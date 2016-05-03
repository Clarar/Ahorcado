package viewPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import drawAhorcado.DrawPatibulo;

public class ViewPanelCenter extends JPanel {
	
	protected JLabel jlbl_error;
	protected JPanel drawHangman;
	protected JPanel pl1;
	protected JPanel jpl_resolver;
	protected JButton jbtn_start;
	protected JLabel jlbl_maskWord;
	protected JButton jbtn_pista;
	protected JCheckBox jchk_teclado;
	protected JTextField jtxt_letra;
	protected JButton jbtn_letra;
	protected JTextField jtxt_palabra;
	protected JButton jbtn_palabra;
	protected JLabel jlbl_introduced;
	protected JLabel jlbl_attempts;
	protected JLabel jlbl_letra;
	protected JPanel jpl_letter;
	protected JPanel jpl_letra;
	protected JLabel jlbl_image;
	
	public ViewPanelCenter(){
		setLayout(new GridLayout(1, 2));
		
		//Panel Derecho
		JPanel panelRight = new JPanel();
		panelRight.setLayout(new BorderLayout(30,30));
		
		//-- Panel contenedor del dibujo
		JPanel jpl_panelDraw = new JPanel();
		jpl_panelDraw.setLayout(new GridLayout(1,1));
		
		drawHangman = new DrawPatibulo();
		drawHangman.setVisible(false);
		
		jpl_panelDraw.setBorder(BorderFactory.createEtchedBorder());//createLineBorder(Color.black));
		jpl_panelDraw.add(drawHangman);
		//--
		
		//-- label para posibles errores
		jlbl_error =new JLabel();
		jlbl_error.setText("Texto de error");
		jlbl_error.setFont(new Font(getFont().getName(), Font.BOLD,20));
		jlbl_error.setForeground(getBackground());
		//--
		
		//añadir elementos al panel derecho
		panelRight.add(jlbl_error, BorderLayout.NORTH);
		panelRight.add(jpl_panelDraw,BorderLayout.CENTER);
		//--
		
		
		
		
		//Panel izquierdo
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new BorderLayout(29,29));
		
		JPanel pleftcenter = new JPanel();
		pleftcenter.setLayout(new GridLayout(5,1,1,1));
		
		pl1 = new JPanel();
		JPanel jpl_detail = new JPanel();
		JPanel pl3 = new JPanel();
		jpl_letter = new JPanel();
		JPanel jpl_teclado = new JPanel();
		
		//-- 1Panel de iniciar partida
		pl1.setLayout(new FlowLayout(FlowLayout.LEFT,50,25));
		
		jbtn_start = new JButton();
		jbtn_start.setText("Comenzar partida");
		jbtn_start.setName("start");
		jbtn_start.setFont(new Font(getFont().getName(), Font.PLAIN,15));
		jbtn_start.setVisible(false);
		jbtn_start.setVerticalAlignment(pl1.getHeight()/2);
		
		jlbl_maskWord = new JLabel();
		jlbl_maskWord.setText("_ _ _ _ _ _ _ _ _ _ _ _");
		jlbl_maskWord.setFont(new Font(getFont().getName(), Font.PLAIN,15));
		jlbl_maskWord.setVisible(false);
		jlbl_maskWord.setVerticalAlignment(pl1.getHeight()/2);
		
		jbtn_pista = new JButton();
		jbtn_pista.setText("Pista");
		jbtn_pista.setName("pista");
		jbtn_pista.setFont(new Font(getFont().getName(), Font.PLAIN,15));
		jbtn_pista.setVisible(false);
		jbtn_pista.setVerticalAlignment(pl1.getHeight()/2);
		
		
		
		pl1.add(jbtn_start);
		pl1.add(jlbl_maskWord);
		pl1.add(jbtn_pista,FlowLayout.RIGHT);
		//-- Fin primer panel
		
		
		
		
		//-- 2Panel de los detalles de la partida
		jpl_detail.setBorder(BorderFactory.createEtchedBorder());
		jpl_detail.setLayout(new GridLayout(2, 1));
		
		//Panel de letras introducidas
		JPanel jpl_Introduced = new JPanel(new FlowLayout(FlowLayout.LEFT,20,15));
		
		JLabel jlbl_txtIntroduced = new JLabel("Letras introducidas: "); 
		
		jlbl_introduced = new JLabel();
		jlbl_introduced.setName("introduced");
		jlbl_introduced.setText("");
		
		jpl_Introduced.add(jlbl_txtIntroduced);
		jpl_Introduced.add(jlbl_introduced);
		
		//Panel de intentos restantes
		JPanel jpl_attempts = new JPanel(new FlowLayout(FlowLayout.LEFT,20,15));
		
		JLabel jlbl_txtAttempts = new JLabel("Intentos restantes: "); 
		
		jlbl_attempts = new JLabel();
		jlbl_attempts.setName("attempts");
		jlbl_attempts.setText("");
		
		jpl_attempts.add(jlbl_txtAttempts);
		jpl_attempts.add(jlbl_attempts);
		
		jpl_detail.add(jpl_attempts);	
		jpl_detail.add(jpl_Introduced);
		//-- Fin segundo panel
		
		
		//-- 3Panel de resolver palabra
		pl3.setBorder(BorderFactory.createEtchedBorder());
		pl3.setLayout(new GridLayout(1, 1));
		/*pl3.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Resuelve la palabra"));*/
		jpl_resolver = new JPanel(new FlowLayout(FlowLayout.LEFT,20,30));
		
		JLabel jlbl_palabra = new JLabel();
		jlbl_palabra.setText("Resuelve:");
		
		jtxt_palabra = new JTextField(8);
		
		jbtn_palabra = new JButton();
		jbtn_palabra.setText("Resolver");
		jbtn_palabra.setName("resolver");
		
		jtxt_palabra.setEnabled(false);
		jbtn_palabra.setEnabled(false);
		
		jpl_resolver.add(jlbl_palabra);
		jpl_resolver.add(jtxt_palabra);
		jpl_resolver.add(jbtn_palabra);
		
		pl3.add(jpl_resolver);
		
		//--Fin tercer panel
		
		//-- 4Panel de insertar letra
		jpl_letter.setBorder(BorderFactory.createEtchedBorder());
		jpl_letter.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		jlbl_image = new JLabel();
		
		jpl_letra = new JPanel();
		jpl_letra.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
		
		jlbl_letra = new JLabel();
		jlbl_letra.setText("Introduce una letra:");
		
		jtxt_letra = new JTextField(5);
		jtxt_letra.setEnabled(false);
		
		jbtn_letra = new JButton();
		jbtn_letra.setText("Comprobar");
		jbtn_letra.setName("comprobar");
		jbtn_letra.setEnabled(false);
		
		jpl_letra.add(jlbl_letra);
		jpl_letra.add(jtxt_letra);
		jpl_letra.add(jbtn_letra);
		
		jpl_letter.add(jlbl_image);
		jpl_letter.add(jpl_letra);
		//-- Fin cuarto panel
		
		//-- 5Panel de activacion de teclado
		jpl_teclado.setBorder(BorderFactory.createEtchedBorder());
		jpl_teclado.setLayout(new GridLayout(1,1,0,20));
		
		jchk_teclado = new JCheckBox();
		jchk_teclado.setText("Activar el teclado");
		jchk_teclado.setVerticalAlignment(jpl_teclado.getHeight()/2);
		jchk_teclado.setEnabled(false);
		
		jpl_teclado.add(jchk_teclado);
		//-- Fin quinto panel 
		
		//-- Añadir elementos al panel central izquierdo
		pleftcenter.add(pl1);
		pleftcenter.add(jpl_detail);
		pleftcenter.add(pl3);
		pleftcenter.add(jpl_letter);
		pleftcenter.add(jpl_teclado);
		//--
		
		JLabel text1 =new JLabel();
		text1.setText("hola");
		text1.setFont(new Font(getFont().getName(), Font.BOLD,20));
		text1.setForeground(getBackground());
		
		//-- Añadir elementos al panel izquierdo 
		panelLeft.add(text1,BorderLayout.NORTH );
		panelLeft.add(pleftcenter,BorderLayout.CENTER);
		//--
		
		
		
		
		//añadir elementos al panel central
		add(panelLeft);
		add(panelRight);
		
	}
	
	public JLabel getJlbl_error() {
		return jlbl_error;
	}

	public JPanel getDrawHangman() {
		return drawHangman;
	}
	
	public void setDrawHangman(JPanel draw) {
		drawHangman = draw;
	}

	public JPanel getPl1() {
		return pl1;
	}

	public JButton getJbtn_start() {
		return jbtn_start;
	}

	public JLabel getJlbl_maskWord() {
		return jlbl_maskWord;
	}

	public JButton getJbtn_pista() {
		return jbtn_pista;
	}

	public JCheckBox getJchk_teclado() {
		return jchk_teclado;
	}

	public JTextField getJtxt_letra() {
		return jtxt_letra;
	}

	public JButton getJbtn_letra() {
		return jbtn_letra;
	}
	
	public JTextField getJtxt_palabra() {
		return jtxt_palabra;
	}

	public JButton getJbtn_palabra() {
		return jbtn_palabra;
	}
	
	public JLabel getJlbl_introduced() {
		return jlbl_introduced;
	}
	
	public JLabel getJlbl_attempts() {
		return jlbl_attempts;
	}
	
	public JLabel getJlbl_letra(){
		return jlbl_letra;
	}
	
	public JPanel getJpl_resolver(){
		return jpl_resolver;
	}
	
	public JPanel getJpl_letra(){
		return jpl_letra;
	}
	
	public JLabel getJlbl_image(){
		return jlbl_image;
	}
	
	public JPanel getJpl_letter(){
		return jpl_letter;
	}

	public void setDrawHangman(ImageIcon imageIcon) {
		JPanel draw = new JPanel(new GridLayout(1, 1));
		draw.add(new JLabel(imageIcon));
		drawHangman = draw;		
	}
}
