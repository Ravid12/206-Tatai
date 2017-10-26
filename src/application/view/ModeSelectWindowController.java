package application.view;

import application.controller.WindowController;
import application.model.Mode;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ModeSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<Mode> cb;
	
	@FXML
	private Label error;
	
	private ObservableList<Mode> levels = FXCollections.observableArrayList(Mode.values());
	
	
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	
	public ModeSelectWindowController() {
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
	}

	
	
	/**
	 * Called when the user clicks on the Start button.
	 */	
	
	@FXML
	private void handleSelectBtn() {
		if (! cb.getSelectionModel().isEmpty()) {
			if(cb.getValue().equals(Mode.EQUATION)) {
				mainApp.showWindow(Window.EQUATIONSELECT);
			}
			
			else if (cb.getValue().equals(Mode.NUMBER)) {
				mainApp.showWindow(Window.LEVELSELECT);
			}
			
			else if (cb.getValue().equals(Mode.PRACTICE)) {
				mainApp.showWindow(Window.PRACTICE);
			}
		} else {
			error.setText("Please select a gamemode...");
		}
	}
}

