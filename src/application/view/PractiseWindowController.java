package application.view;

import application.controller.MainApp;
import javafx.fxml.FXML;

public class PractiseWindowController {

	// Reference to the main application.
	private MainApp mainApp;

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
		mainApp.showExamWindow();
	}
	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showMainWindow();
		System.out.println("Menu");		
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
}
