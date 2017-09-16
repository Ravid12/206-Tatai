package application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import application.controller.MainApp;

public class MainWindowController {

	// Reference to the main application.
	private MainApp mainApp;

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
		mainApp.showExamWindow();
	}
	
	@FXML
	private void handlePractiseBtn() {
		mainApp.showPractiseWindow();
	}
	
	@FXML
	private void handleStatsBtn() {
		mainApp.showLeaderboardWindow();
	}
	
	@FXML
	private void handleInstructionsBtn() {
		mainApp.showInstructionWindow();
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