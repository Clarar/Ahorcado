import java.io.File;

public class ControllerHangman {
	
	private ModelHangman model;
	private ViewHangman view;
	private boolean hangmanTheEnd;
	private ModelHangmanDictionary modelDictionary;
	
	public ControllerHangman( ModelHangman model, ViewHangman view ){
		this.model = model;
		this.view = view;
		this.hangmanTheEnd = false;
	}
	
	public boolean hangmanTheEnd(){
		return hangmanTheEnd;
	}
	
	public void ResethangmanTheEnd(){
		hangmanTheEnd = false;
	}
	
	public String youWin(String word){
		String message = "";
		message += "\nLa palabra introducida es: "+word+"\n";
		for (int i = 0; i < model.getWord().length(); i++) {
			if (word.toLowerCase().charAt(i) != model.getWord().toLowerCase().charAt(i)) {
				message += "\nLa palabra no es correcta. Ha perdido :(\n\n";
				hangmanTheEnd = true;
			}
			if (hangmanTheEnd) {
				model.setChar(i, model.getWord().charAt(i));
			}
		}
		message += "\n\n"+model.getMaskWord()+"\n\n¡¡Ha ganado!!\n\n";
		hangmanTheEnd = true;
		return message;
	}
	
	public void operateOption( int option ){
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
	}
	
	public String processLetter(){
		char letter;
		String message = "";
		int count = -1;
		do {
			count++;
			if (count > 0) {
				view.showMessage("\nLa letra ya esta introducida.\n");
			}
			letter = view.insertChar();
		} while (isRepeatedLetter(letter));
		message += "La letra introducida es: "+letter;
		if (checkLetter(letter)) {
			if (isWordCompleted()) {
				hangmanTheEnd = true;
				message += "\n"+model.getMaskWord();
				message += "\n\n\t¡¡Has ganado!!\n\n";
			}else{
				message += "\n"+model.getMaskWord();
				message += "\nHas acertado.\n";
			}
		}else{
			model.incrementmMistake();
			message += "\n"+model.getMaskWord();
			message += "\nFallaste, llevas "+model.getMistake()+" fallos.";
		}
		return message;
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
			view.showMessage("El diccionario "+dictionary+" no existe.");
		}
		return false;
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
	
	public ControllerHangman resetController() throws Exception{
		ControllerHangman controller;
		String wordRandom = modelDictionary.getWordRandom();
		
		controller = new ControllerHangman(new ModelHangman(wordRandom), new ViewHangman());
		controller.setModelDictionary(new ModelHangmanDictionary(modelDictionary.getFile()));
		return controller;
	}
	
	public boolean getIntroduced(){
		if (model.getIntroduced().length() > 0) {
			return true;
		}else{
			return false;
		}
	}
	public void setModelDictionary( ModelHangmanDictionary modelDictionary){
		this.modelDictionary = modelDictionary;
	}
}
