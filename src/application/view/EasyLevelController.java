package application.view;

import application.controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EasyLevelController {
	@FXML
	private Label number;
	
	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public EasyLevelController () {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		number.setText("Elevtyleven");
	}

	/**
	 * Called when the user clicks on the Easy button.
	 */
	@FXML
	private void handleMenu() {
		mainApp.showMainWindow();
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
