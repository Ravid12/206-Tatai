package application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import application.controller.MainApp;

public class MainWindowController {
	@FXML
	private ComboBox<String> levelSelect;

	private ObservableList<String> levels = FXCollections.observableArrayList(
			"Easy (1-10)",
			"Hard (1-100)"
			);

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
		levelSelect.setItems(levels);
	}

	/**
	 * Called when the user clicks on the Easy button.
	 */
	@FXML
	private void handleStart() {
		if (levelSelect.getValue()!= null) {
			// TODO: Change to a new window controller
			System.out.println(levelSelect.getValue());
			mainApp.showEasyLevel();
		}
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