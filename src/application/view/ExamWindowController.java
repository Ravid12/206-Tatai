package application.view;

import javafx.fxml.FXML;
import application.controller.MainApp;

public class ExamWindowController {
	
	// Reference to the main application.
	private MainApp mainApp;
	private int Counter = 1;

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public ExamWindowController () {
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
	private void handleRecordBtn() {
		System.out.println("Zinzan sucks at recorder");		
	}
	
	/**
	 * Called when the user clicks on the listen button.
	 */
	@FXML
	private void handleListenBtn() {
		System.out.println("Ravid you just need to listen");		
	}
	
	/**
	 * Called when the user clicks on the Confirm button.
	 */
	@FXML
	private void handleConfirmBtn() {
		System.out.println("Confirm " + Counter);
		Counter++;
		mainApp.showEndWindow();
	}
	
	/**
	 * Called when the user clicks on the Menu button.
	 */
	@FXML
	private void handleMenuBtn() {
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