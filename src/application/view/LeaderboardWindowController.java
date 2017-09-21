package application.view;

import application.controller.WindowController;
import application.model.Window;
import javafx.fxml.FXML;

public class LeaderboardWindowController extends WindowController{

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public LeaderboardWindowController () {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Called when the user clicks on the Record button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}	
}
