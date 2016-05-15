import hangman.ViewStart;
import hangman.ControllerStart;

public class Hangman {

	public static void main(String[] args) throws Exception {
		ViewStart view = new ViewStart(); 
		ControllerStart controller = new ControllerStart(view);
		
		view.setController(controller);
		view.runGame();
	}
	
}
