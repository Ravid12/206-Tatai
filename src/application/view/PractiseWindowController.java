package application.view;

import application.controller.WindowController;
import javafx.fxml.FXML;

public class PractiseWindowController extends WindowController{

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public PractiseWindowController () {
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
	private void handleTestBtn() {
		System.out.println("Testing 1, 2, 3");
		mainApp.showWindow(Window.EXAM);
	}
	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}
}
