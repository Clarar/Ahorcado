package hangman;
public class StartGame {

	public static void main(String[] args) throws Exception {
		ViewHangman view = new ViewHangman(); 
		ControllerHangman controller = new ControllerHangman(view);
		
		view.setController(controller);
		view.run();
	}
	
}
