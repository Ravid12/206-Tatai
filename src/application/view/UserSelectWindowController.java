package application.view;

import application.controller.WindowController;
import application.model.StatisticsModel;
import application.model.Window;
import application.utils.IOUtils;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<String> cb;
	
	@FXML
	private TextField tf;
	
	@FXML
	private Label errorMessage;
	
	private ObservableList<String> users = FXCollections.observableArrayList(IOUtils.readFile("stats/users/user.txt"));
	private final String ERROR_NONE = "Please either:\nCreate a new user \nor Choose an existing user";
	private final String ERROR_TAKEN = "Username already taken";
	private final String ERROR_INVALID = "Usernames can contain only alphanumeric characters or underscores";
	
	
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	
	public UserSelectWindowController() {
	}

	
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	
	@FXML
	private void initialize() {
		cb.disableProperty().bind(Bindings.isNotEmpty(tf.textProperty()));
		cb.setItems(users);
		errorMessage.setVisible(false);
	}

	
	
	/**
	 * Called when the user clicks on the Start button.
	 */	
	
	@FXML
	private void handleLoginBtn() {
		String username = null;
		boolean comboBox = false;
		
		if (cb.getSelectionModel().isEmpty() && (tf.getText().isEmpty() || tf.getText() == null)){
			errorMessage.setText(ERROR_NONE);
			errorMessage.setVisible(true);
			username = null;
		}	
		else if (!cb.getSelectionModel().isEmpty() && !tf.getText().isEmpty()) {
			username = tf.getText();
		}
		else if (!tf.getText().isEmpty()) {
			username = tf.getText();
			
			// Regex for all alphanumeric characters and underscores
			if (!username.matches("^[a-zA-Z0-9_]+$")) {
				errorMessage.setText(ERROR_INVALID);
				errorMessage.setVisible(true);
				username = null;
			};
			
		} 
		else {
			username = cb.getValue();
			comboBox = true;
		}
		
		if(IOUtils.readFile("stats/users/user.txt").contains(username) && !comboBox){
			errorMessage.setText(ERROR_NONE);
			errorMessage.setVisible(true);
			username = null;	
		}
		
		if (username !=null) {
			StatisticsModel.getStatisticsModel().setUser(username);
			if(!comboBox){
				IOUtils.appendFile("stats/users/user.txt", username);
			}
			mainApp.showWindow(Window.MAIN);
		} 
	}
}
