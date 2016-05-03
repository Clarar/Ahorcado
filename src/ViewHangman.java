import javax.swing.JOptionPane;

public class ViewHangman {
	
	private ControllerHangman controller;
	
	
	public ViewHangman(){
	}
	
	public int menu(){
		String menu = "         Menu\n"+
	                  "\n 1. Insertar letra"+
				      "\n 2. Dar una pista";
		if (controller.getIntroduced()) {
			menu += "\n 3. Resolver palabra";
		}
		menu += "\n\n\n\tPulse 4 para salir";
		boolean repeat = true;
		do {
			String option=(String) JOptionPane.showInputDialog(
	                null,menu,
	                "Juego del Ahorcado",
	                JOptionPane.PLAIN_MESSAGE,
	                null,null,
	                "Introduce una opcion..");
			try {
				int optionN = Integer.parseInt(option);
				return optionN;
			} catch (NumberFormatException e) {
				repeat = false;
				this.showMessage("'"+option+"'"+" No es un numero.");
			}
		} while (repeat);
		return 0;
	}
	
	public int menutheEnd(){
		int n = JOptionPane.showConfirmDialog(null,"¿Quieres iniciar una nueva partida?",
			    "Fin del juego del Ahorcado",
			    JOptionPane.YES_NO_OPTION);
		return n;
	}
	
	public void setController(ControllerHangman c){
		controller = c;
	}
	
	public void windowsGame() throws Exception{
		int option = 0;
		do {
			if (!controller.hangmanTheEnd()) {
				option = raiseWindow();
				if (controller.notAttempts()) {
					showMessage("Se ha quedado sin intentos. Ha perdido :)\n\n");
				}
			}else{
				option = raiseWindowTheEnd();
			}
			
		} while (option != 4);
		
		showMessage("¡Hasta la vista! :)");
	}
	
	public int raiseWindow(){
		int option = 0;

		option = menu();
		controller.operateOption(option);
		
		return option;
	}
	
	public int raiseWindowTheEnd() throws Exception{
		int option = 0;
		
		if (menutheEnd() == 1) {
			option = 4;
		}else{
			setController(controller.resetController());
		}
		return option;
	}
	
	public void showMessage( String s ){
		JOptionPane.showMessageDialog(null,s,
			    "Juego del Ahorcado",
			    JOptionPane.INFORMATION_MESSAGE,
			    null);
	}
	
	public char insertChar(){
		String word = (String) JOptionPane.showInputDialog(
                null,"Inserta una letra:",
                "Juego del Ahorcado",
                JOptionPane.PLAIN_MESSAGE,
                null,null,
                "...");
		return word.charAt(0);
	}
	
	public String insertWord(){
		String word = (String) JOptionPane.showInputDialog(
                null,"Inserta la palabra a resolver:",
                "Juego del Ahorcado",
                JOptionPane.PLAIN_MESSAGE,
                null,null,
                "...");
		return word;
	}

	public void chooseDictionary() {
		 boolean wd = false;
		do{
			String word = (String) JOptionPane.showInputDialog(
	                null,"¿En que idioma desea inicializar la palabra?",
	                "Juego del Ahorcado",
	                JOptionPane.PLAIN_MESSAGE,
	                null,null,
	                "Introduce el nombre del idioma..");
			wd = controller.setDictionary(word);
			
		}while(!wd);
	}
	
}

