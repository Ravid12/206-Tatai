package application.view;

import application.controller.WindowController;
import application.model.Window;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EasyLevelController extends WindowController{
	@FXML
	private Label number;

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
	 * Called when the user clicks on the Menu button.
	 */
	@FXML
	private void handleMenu() {
		mainApp.showWindow(Window.MAIN);
	}
}
