package hangman;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import drawAhorcado.*;

public class ControllerHangman implements ActionListener, KeyListener  {
	
	private ModelHangman model;
	private ViewHangman view;
	private boolean hangmanTheEnd;
	private ModelHangmanDictionary modelDictionary;
	private boolean dictionary;
	private ImageIcon imageWinner;
	private ImageIcon imageLoser;
	
	public ControllerHangman( ViewHangman view ){
		this.model = new ModelHangman();
		this.view = view;
		this.hangmanTheEnd = false;
		this.dictionary = false;
		this.imageWinner = new ImageIcon("image/enhorabuena.jpg");
		this.imageLoser = new ImageIcon("image/loser.jpg");
	}
	
	/*public boolean hangmanTheEnd(){
		return hangmanTheEnd;
	}*/
	
	/*public void ResethangmanTheEnd(){
		hangmanTheEnd = false;
	}*/
	
	public void youWin(String word){
		for (int i = 0; i < model.getWord().length(); i++) {
			if (model.getWord().length() != word.length() || word.toLowerCase().charAt(i) != model.getWord().toLowerCase().charAt(i)) {
				hangmanTheEnd = true;
				view.setTextEnd(imageLoser);
			}
			if (hangmanTheEnd) {
				model.setChar(i, model.getWord().charAt(i));
			}
		}
		
		if (hangmanTheEnd) {
			//view.setTextEnd(new ImageIcon("image/congratulation.jpg").getImage());
			view.setTextEnd(imageWinner);
		}
		//view.panelCenter.setDrawHangman(new ImageIcon("image/congratulation.jpg"));
		//view.setTextEnd(new ImageIcon("image/congratulation.jpg"));
		view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
		hangmanTheEnd = true;
	}
	
	/*public void operateOption( int option ){
		String message ="";
		switch (option) {
		case 1:
			message += processLetter();
			view.showMessage(message);
			break;
		case 2:
			int random;
			char letter;
			message = "";
			do {
				random = (int)(Math.random()*model.getWord().length());
				letter = model.getWord().charAt(random);
			} while (isRepeatedLetter(letter));
			message = "La letra revelada es "+letter;
			if (this.checkLetter(letter)) {
				if (isWordCompleted()) {
					hangmanTheEnd = true;
					message += "\n\nPalabra completada.¡¡Has ganado!!\n\n";
				}
				model.incrementmMistake();
			}
			view.showMessage(message+"\n\t"+model.getMaskWord()+"\nTe quedan "+model.getAttempts()+" intentos\n");
			break;
		case 3:
			message = "\n\t"+model.getMaskWord()+"\nTe quedan "+model.getAttempts()+" intentos\n";
			String word = view.insertWord();
			message += youWin(word);
			view.showMessage(message);
			break;
		}
	}*/
	
	public void processLetter(){
		char letter;
		letter = view.panelCenter.getJtxt_letra().getText().charAt(0);
		//int count = -1;
		/*do {
			count++;
			if (count > 0) {
				view.setTextError("La letra ya esta introducida.");
			}
			letter = view.panelCenter.getJtxt_letra().getText().charAt(0);
		} while (isRepeatedLetter(letter));*/
		
		if (isRepeatedLetter(letter)) {
			view.setTextError("La letra ya esta introducida.");
		}else{
			if (checkLetter(letter)) {
				if (isWordCompleted()) {
					hangmanTheEnd = true;
					//view.panelCenter.setDrawHangman(new ImageIcon("image/congratulation.jpg"));
					view.setTextEnd(imageWinner);
					view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
				}else{
					view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
					view.panelCenter.getJlbl_introduced().setText(model.getIntroduced());
					view.panelCenter.getJlbl_attempts().setText(model.getAttempts()+"/6");
				}
			}else{
				model.incrementmMistake();
				view.panelCenter.getJlbl_attempts().setText(model.getAttempts()+"/6");
				view.panelCenter.getJlbl_introduced().setText(model.getIntroduced());
				view.setTextError("Has fallado");
			}
		}
	}
	
	public boolean isRepeatedLetter(char letter){
		if (model.getIntroduced().indexOf(letter) == -1) {
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isWordCompleted(){
		for (int i = 0; i < model.getWord().length(); i++) {
			if (model.getChar(i) == '_' ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkLetter(char letter){
		String word = model.getWord();
		boolean isInWord = false;
		for (int i = 0; i < word.length(); i++) {
			if ( Character .toLowerCase(letter) == word.toLowerCase().charAt(i) ) {
				model.setChar(i, word.charAt(i));
				isInWord = true;
			}
		}
		if ( isInWord ) {
			model.SetIntroduced(letter);
			return true;
		}else{
			model.SetIntroduced(letter);
			return false;
		}
	}
	
	public boolean notAttempts(){
		if (model.getAttempts() == 0) {
			hangmanTheEnd = true;
			return true;
		}
		return false;
	}
	
	public boolean setDictionary( String word ) {
		String dictionary = this.selectDictionary(word);
		File wd = new File(dictionary);
			try {
				this.setWord(wd);
				return true;
			} catch (Exception e) {
				return false;
			}
	}
	
	public String selectDictionary( String word ){
		String dictionary = "";
		
		if (word.toLowerCase().indexOf("spa") != -1) {
			dictionary = "dictionaryES.txt";
		}else if (word.toLowerCase().indexOf("ngl") != -1) {
			dictionary = "dictionaryEN.txt";
		}
		return dictionary;
	}
	
	public void setWord(File wd) throws Exception {
		String wordRandom;
		
		modelDictionary = new ModelHangmanDictionary(wd);
		wordRandom = modelDictionary.getWordRandom();
		model.setWord(wordRandom);
	}
	
	/*public ControllerHangman2 resetController() throws Exception{
		ControllerHangman2 controller;
		String wordRandom = modelDictionary.getWordRandom();
		
		controller = new ControllerHangman2(new ModelHangman(wordRandom), new ViewHangman());
		controller.setModelDictionary(new ModelHangmanDictionary(modelDictionary.getFile()));
		return controller;
	}*/
	
	private boolean getIntroduced(){
		if (model.getIntroduced().length() > 0) {
			return true;
		}else{
			return false;
		}
	}
	/*public void setModelDictionary( ModelHangmanDictionary modelDictionary){
		this.modelDictionary = modelDictionary;
	}*/
	
	private boolean validateDictionary(String dictionary){
		if (dictionary != "Elija un idioma...") {
			if (!setDictionary(dictionary)) {
				view.setTextError("El dic. "+dictionary+" no está disponible");
				return false;
			}else{
				return true;
			}
		}else{
			view.setTextError("Elija un lenguaje");
			return false;
		}
	} 
	
	private boolean isLetter(){
		
		if (view.panelCenter.getJtxt_letra().getText().length() == 1 && 
				!Character.isDigit((view.panelCenter.getJtxt_letra().getText()).charAt(0)) ) {
			return true;
		}
		view.setTextError("Introduce una letra");
		return false;
	}
	public void drawHangman(){
		
		switch (model.getMistake()) {
		case 1:
			view.panelCenter.setDrawHangman(new DrawCabeza());
			break;
		case 2:
			view.panelCenter.setDrawHangman(new DrawTronco());
			break;
		case 3:
			view.panelCenter.setDrawHangman(new DrawBrazoIzquierdo());
			break;
		case 4:
			view.panelCenter.setDrawHangman(new DrawBrazoDerecho());
			break;
		case 5:
			view.panelCenter.setDrawHangman(new DrawPiernaIzquierda());
			break;
		case 6:
			view.panelCenter.setDrawHangman(new DrawPiernaDerecha());
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//char a = 'A';
		
		if (((JButton)e.getSource()).getName() == "start") {
			String dictionary = (String)view.panelHead.getLanguage().getSelectedItem();
			if (validateDictionary(dictionary)) {
				view.startButtonVisible(false);
				view.setTextError(" ");
				view.panelHead.getLanguage().setEnabled(false);
				view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
				view.panelCenter.getJlbl_attempts().setText(model.getAttempts()+"/6");
				view.panelCenter.getJlbl_introduced().setText(model.getIntroduced());
				this.dictionary = true;
			}
		}
		
		if (((JButton)e.getSource()).getName() == "comprobar" ) {
			if (getIntroduced()) {
				view.panelCenter.getJbtn_palabra().setEnabled(true);
				view.panelCenter.getJtxt_palabra().setEnabled(true);
				view.panelCenter.getJbtn_pista().setEnabled(true);
			}
			view.setTextError(" ");
			if (notAttempts()) {
				view.setTextError("Sin intentos");
				view.setTextEnd(imageLoser);
			}else{
				if (isLetter()) {
					processLetter();
				}
			}
		}
		
		if (((JButton)e.getSource()).getName() == "pista") {
			view.setTextError(" ");
			if (notAttempts()) {
				view.setTextError("Sin intentos");
				view.setTextEnd(imageLoser);
			}else{
				int random;
				char letter;
				do {
					random = (int)(Math.random()*model.getWord().length());
					letter = model.getWord().charAt(random);
				} while (isRepeatedLetter(letter));
				if (this.checkLetter(letter)) {
					if (isWordCompleted()) {
						hangmanTheEnd = true;
						//view.panelCenter.setDrawHangman(new ImageIcon("image/congratulation.jpg"));
						view.setTextEnd(imageWinner);
					}
					model.incrementmMistake();
				}
				view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
				view.panelCenter.getJlbl_attempts().setText(model.getAttempts()+"/6");
				
			}
			
		}
		
		if (((JButton)e.getSource()).getName() == "resolver") {
			youWin(view.panelCenter.getJtxt_palabra().getText());
			
		}
		
		
		/*for (int i = 0; i < 26; i++) {
			if (((JButton)e.getSource()).getName() == (""+(char)(i+(int)a))) {
				view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
			}
			//JOptionPane.showMessageDialog(null, ((JButton)e.getSource()).getName()+(" "+(char)(i+(int)a)));
		}*/
		if (((JButton)e.getSource()).getName() == "A") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "B") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "C") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "D") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "E") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "F") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "G") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "H") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "I") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "J") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "K") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "L") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "M") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "N") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "Ñ") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "O") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "P") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "Q") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "R") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "S") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "T") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "U") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "V") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "W") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "X") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "Y") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		if (((JButton)e.getSource()).getName() == "Z") {
			view.panelCenter.getJtxt_letra().setText(((JButton)e.getSource()).getName());
		}
		
		
		if (((JButton)e.getSource()).getName() == "Enter") {
			if (getIntroduced()) {
				view.panelCenter.getJbtn_palabra().setEnabled(true);
				view.panelCenter.getJtxt_palabra().setEnabled(true);
				view.panelCenter.getJbtn_pista().setEnabled(true);
			}
			if (notAttempts()) {
				view.setTextError("Sin intentos");
				view.setTextEnd(imageLoser);
			}else{
				if (view.panelCenter.getJtxt_letra().getText().length() > 0) {
					view.setTextError(" ");
					processLetter();
				}
				
				if (view.panelCenter.getJtxt_palabra().getText().length() > 0) {
					youWin(view.panelCenter.getJtxt_palabra().getText());
				}
			}
			
		}
		view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
		if (dictionary) {
			view.panelCenter.getJlbl_attempts().setText(model.getAttempts()+"/6");
		}
		view.panelCenter.getJlbl_introduced().setText(model.getIntroduced());
		drawHangman();
		//view.paintAll(view.getGraphics());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (getIntroduced()) {
			view.panelCenter.getJbtn_palabra().setEnabled(true);
			view.panelCenter.getJtxt_palabra().setEnabled(true);
			view.panelCenter.getJbtn_pista().setEnabled(true);
		}
		view.setTextError(" ");
		if (e.VK_ENTER == e.getKeyCode()){
			if (view.panelCenter.getJtxt_letra().getText().length() > 0) {
				view.setTextError(" ");
				processLetter();
				if (notAttempts()) {
					view.setTextError("Sin intentos");
					view.setTextEnd(imageLoser);
				}
			}
			
			if (view.panelCenter.getJtxt_palabra().getText().length() > 0) {
				youWin(view.panelCenter.getJtxt_palabra().getText());
			}
		}
		view.panelCenter.getJlbl_maskWord().setText(model.getMaskWord());
		//if (dictionary) {
			view.panelCenter.getJlbl_attempts().setText(model.getAttempts()+"/6");
		//}
		view.panelCenter.getJlbl_introduced().setText(model.getIntroduced());
		drawHangman();
		//view.paintAll(view.getGraphics());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
