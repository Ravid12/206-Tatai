
package application.view;

import application.controller.WindowController;
import application.model.PracticeModel;
import application.model.Window;
import application.utils.StringUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PractiseWindowController extends WindowController{

	@FXML
	private TextField textField = new TextField();

	@FXML
	private Label errorLabel = new Label();

	private final String ERROR_NOT_INT = "Please input an Integer";
	private final String ERROR_BOUNDS = "Please input a number between 1 and 99";

	
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	
	public PractiseWindowController () {
	}

	
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	
	@FXML
	private void initialize() {
		// Listen for TextField text changes
		textField.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				if (newValue.length()>3) {
					textField.setText(textField.getText().substring(0, 3));
				}
			}
		});
	}

	
	
	/**
	 * Called when the user clicks on the test button.
	 */
	
	@FXML
	private void handleTestBtn() {
		if (!StringUtils.isNumeric(textField.getText())) {
			errorLabel.setText(ERROR_NOT_INT);
		} else {
			int num = Integer.parseInt(textField.getText());
			if (num < 0 || num > 99) {
				errorLabel.setText(ERROR_BOUNDS);
			} else {
				PracticeModel.getPracticeModel().createList(num);
				mainApp.showWindow(Window.EXAM);
			}
		}
	}

	
	
	/**
	 * Called when the user clicks on the Menu button.
	 */
	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}	
}
