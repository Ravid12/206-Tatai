package application.view;

import application.controller.WindowController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class LevelSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<String> cb = new ComboBox<String>();

	private ObservableList<String> levels = FXCollections.observableArrayList(
			"Easy",
			"Hard"
	);

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public LevelSelectWindowController () {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		cb.setItems(levels);
	}

	/**
	 * Called when the user clicks on the Menu button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}

	/**
	 * Called when the user clicks on the Start button.
	 */	
	@FXML
	private void handleStartBtn() {
		mainApp.showWindow(Window.EXAM);
		System.out.println(cb.getValue());		
	}
}
