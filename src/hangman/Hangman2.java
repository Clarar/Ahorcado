package hangman;
public class Hangman2 {

	public static void main(String[] args) throws Exception {
		ViewHangman2 view = new ViewHangman2(); 
		ControllerHangman2 controller = new ControllerHangman2(view);
		
		view.setController(controller);
		view.run();
	}
	
}
