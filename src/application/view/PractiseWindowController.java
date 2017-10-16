
package application.view;

import application.controller.WindowController;
import application.model.ExamModel;
import application.model.Window;
import application.utils.StringUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PractiseWindowController extends WindowController{

	@FXML
	private TextField textField = new TextField();
	
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
	 * Called when the user clicks on the Record button.
	 */
	@FXML
	private void handleTestBtn() {
		// TODO: Notify user of invalid string input and out of bound numbers
		if (StringUtils.isNumeric(textField.getText())) {
			
			mainApp.showWindow(Window.EXAM);			
		}
		//reset the exammodel later
//		ExamModel.resetExamModel(false);

	}
	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}	
}
