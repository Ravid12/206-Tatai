package application.view;

import javafx.fxml.FXML;
import application.controller.WindowController;

public class ExamWindowController extends WindowController{
	
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
		mainApp.showWindow(Window.END);
	}
	
	/**
	 * Called when the user clicks on the Menu button.
	 */
	@FXML
	private void handleMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}
}