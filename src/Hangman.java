public class Hangman {

	public static void main(String[] args) throws Exception {
		ViewHangman view = new ViewHangman(); 
		ModelHangman model = new ModelHangman();
		ControllerHangman controller = new ControllerHangman(model, view);
		
		view.setController(controller);
		view.chooseDictionary();
		view.windowsGame();
	}
	
}
