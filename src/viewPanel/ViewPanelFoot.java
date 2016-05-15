package viewPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hangman.ControllerHangman;

public class ViewPanelFoot extends JPanel {
	
	private ArrayList<JButton> buttons;
	public JButton a;
	public JButton b;
	public JButton c;
	public JButton d;
	public JButton e;
	public JButton f;
	public JButton g;
	public JButton h;
	public JButton i;
	public JButton j;
	public JButton k;
	public JButton l;
	public JButton m;
	public JButton n;
	public JButton ñ;
	public JButton o;
	public JButton p;
	public JButton q;
	public JButton r;
	public JButton s;
	public JButton t;
	public JButton u;
	public JButton v;
	public JButton w;
	public JButton x;
	public JButton y;
	public JButton z;
	public JButton enter;
	
	public ViewPanelFoot(){
		setLayout(new GridLayout(3,10,2,2));
		setVisible(false);
		
		//buttons = new ArrayList<JButton>();
		//addButton();
		
		/*for (int i = 0; i < buttons.size(); i++) {
			add(getButton(i));
			
		}*/
		a = new JButton("A");
		a.setName("A");
		
		b = new JButton("B");
		b.setName("B");
		
		c = new JButton("C");
		c.setName("C");
		
		d = new JButton("D");
		d.setName("D");
		
		e = new JButton("E");
		e.setName("E");
		
		f = new JButton("F");
		f.setName("F");
		
		g = new JButton("G");
		g.setName("G");
		
		h = new JButton("H");
		h.setName("H");
		
		i = new JButton("I");
		i.setName("I");
		
		j = new JButton("J");
		j.setName("J");
		
		k = new JButton("K");
		k.setName("K");
		
		l = new JButton("L");
		l.setName("L");
		
		m = new JButton("M");
		m.setName("M");
		
		n = new JButton("N");
		n.setName("N");
		
		ñ = new JButton("Ñ");
		ñ.setName("Ñ");
		
		o = new JButton("O");
		o.setName("O");
		
		p = new JButton("P");
		p.setName("P");
		
		q = new JButton("Q");
		q.setName("Q");
		
		r = new JButton("R");
		r.setName("R");
		
		s = new JButton("S");
		s.setName("S");
		
		t = new JButton("T");
		t.setName("T");
		
		u = new JButton("U");
		u.setName("U");
		
		v = new JButton("V");
		v.setName("V");
		
		w = new JButton("W");
		w.setName("W");
		
		x = new JButton("X");
		x.setName("X");
		
		y = new JButton("Y");
		y.setName("Y");
		
		z = new JButton("Z");
		z.setName("Z");
		
		enter = new JButton("Enter");
		enter.setName("Enter");
		
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		add(f);
		add(g);
		add(h);
		add(i);
		add(new JLabel());
		add(j);
		add(k);
		add(l);
		add(m);
		add(n);
		add(ñ);
		add(o);
		add(p);
		add(q);
		add(enter);
		add(r);
		add(s);
		add(t);
		add(u);
		add(v);
		add(w);
		add(x);
		add(y);
		add(z);
		add(new JLabel());
	}
	
	private JButton getButton(int i){
		return buttons.get(i);
	}
	
	private void addButton(){
		JButton ñ = new JButton("Ñ");
		ñ.setName("Ñ");
		
		for (int i = 0; i < 26; i++) {
			if (i == 14) {
				buttons.add(ñ);
			}
			buttons.add(boton(i));
			
		}
	}
	
	public void setActionButton(ControllerHangman controller){
		/*for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(controller);
			
		}*/
		a.addActionListener(controller);
		b.addActionListener(controller);
		c.addActionListener(controller);
		d.addActionListener(controller);
		e.addActionListener(controller);
		f.addActionListener(controller);
		g.addActionListener(controller);
		h.addActionListener(controller);
		i.addActionListener(controller);
		j.addActionListener(controller);
		k.addActionListener(controller);
		l.addActionListener(controller);
		m.addActionListener(controller);
		n.addActionListener(controller);
		ñ.addActionListener(controller);
		o.addActionListener(controller);
		p.addActionListener(controller);
		q.addActionListener(controller);
		r.addActionListener(controller);
		s.addActionListener(controller);
		t.addActionListener(controller);
		u.addActionListener(controller);
		v.addActionListener(controller);
		w.addActionListener(controller);
		x.addActionListener(controller);
		y.addActionListener(controller);
		z.addActionListener(controller);
		enter.addActionListener(controller);
	}
	
	
	private JButton boton (int index){
		char a = 'A';
		
		JButton b = new JButton();
		
		b.setText(""+(char)(index+(int)a));
		b.setName(""+(char)(index+(int)a));
		
		return b;
	}
	
	

}
