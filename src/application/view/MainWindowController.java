package application.view;

import javafx.fxml.FXML;
import application.controller.WindowController;
import application.model.Window;

public class MainWindowController extends WindowController{
	
	
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	
	public MainWindowController () {
	}

	
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	
	@FXML
	private void initialize() {
	}

	
	
	/**
	 * Called when the user clicks on the Start button.
	 */
	
	@FXML
	private void handleStartBtn() {
		mainApp.showWindow(Window.MODESELECT);
	}	

	
	
	/**
	 * Called when the user clicks on the Statistics button.
	 */
	
	@FXML
	private void handleStatsBtn() {
		mainApp.showWindow(Window.STATISTICS);
	}
	
	

	/**
	 * Called when the user clicks on the Instructions button.
	 */
	
	@FXML
	private void handleInstructionsBtn() {
		mainApp.showWindow(Window.INSTRUCTION);
	}
	
	
	
	/**
	 * Called when the user clicks on the Logout button.
	 */
	
	@FXML
	private void handleLogoutBtn() {
		mainApp.showWindow(Window.USERSELECT);
	}
}