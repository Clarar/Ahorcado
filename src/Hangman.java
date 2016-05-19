import hangman.ControllerHangman;
import hangman.ViewHangman;

public class Hangman {

	public static void main(String[] args) throws Exception {
		ViewHangman view = new ViewHangman(); 
		ControllerHangman controller = new ControllerHangman(view);
		
		view.setController(controller);
		view.run();
	}
	
}
