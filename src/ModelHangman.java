public class ModelHangman {
	private String word;
	private char[] letters;
	private String letterIntroduced;
	private int mistake;
	public int random;
	
	public ModelHangman(){
		this("");
	}
	
	public ModelHangman(String word){
		this.word = word;
		this.letterIntroduced = "";
		this.mistake = 0;
		letters = new char[getWord().length()];
		inicializeLetters();
	}
	
	public String getWord(){
		return this.word;
		
	}
	
	public void setWord( String word ){
		this.word = word;
		letters = new char[getWord().length()];
		inicializeLetters();

	}
	
	public int getMistake(){
		return mistake;
	}
	
	public int getAttempts(){
		return 6-mistake;
	}
	
	public int incrementmMistake(){
		return mistake++;
	}
	
	public char getChar(int index){
		return letters[index];
	}
	
	public void setChar(int index, char charInWord){
			letters[index] = charInWord;
	}
	
	public void inicializeLetters(){
		for (int i = 0; i < letters.length; i++) {
			letters[i] = '_';
		}
	}
	
	public String getIntroduced(){
		return letterIntroduced;
	}
	
	public void SetIntroduced(char charIntroduced){
		letterIntroduced += charIntroduced;
	}
	
	public String getMaskWord(){
		String letter = "";
		for (int i = 0; i < letters.length; i++) {
			letter += letters[i]+" ";
		}
		return letter;
	}
	
}
