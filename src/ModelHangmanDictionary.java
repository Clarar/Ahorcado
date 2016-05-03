import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ModelHangmanDictionary {

	private ArrayList<String> words;
	private Scanner dictionarySc = null;
	private int random;
	private File dictionary;
	
	public ModelHangmanDictionary(File dictionary)throws Exception {
		this.dictionary = dictionary;
		this.dictionarySc = new Scanner(dictionary);
		this.words = new ArrayList<String>();
		this.getWordsOfDictionary();
	}
	
	public void getWordsOfDictionary(){
		while (dictionarySc.hasNext()) {
			 this.words.add(this.dictionarySc.next());
		 }
	}
	
	public String getWordRandom(){
		this.random = (int)(Math.random()*words.size()-1);
		System.out.println("random ---> "+random);
		return this.words.get(random);
	}
	public File getFile(){
		return this.dictionary;
	}
}
