package application.view;

import javafx.fxml.FXML;
import application.controller.WindowController;

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
	 * Called when the user clicks on the Easy button.
	 */
	@FXML
	private void handleStartBtn() {
		mainApp.showWindow(Window.EXAM);
	}
	
	@FXML
	private void handlePractiseBtn() {
		mainApp.showWindow(Window.PRACTICE);
	}
	
	@FXML
	private void handleStatsBtn() {
		mainApp.showWindow(Window.LEADERBOARD);
	}
	
	@FXML
	private void handleInstructionsBtn() {
		mainApp.showWindow(Window.INSTRUCTION);
	}
}