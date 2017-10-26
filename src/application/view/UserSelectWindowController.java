package application.view;

import java.util.Optional;

import application.controller.WindowController;
import application.model.StatisticsModel;
import application.model.Window;
import application.utils.IOUtils;
import application.utils.StringUtils;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class UserSelectWindowController extends WindowController{

	@FXML
	private ComboBox<String> cb;

	@FXML
	private TextField tf;

	@FXML
	private Label errorMessage;

	@FXML
	private Button deleteButton;

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
		deleteButton.disableProperty().bind(Bindings.isNotEmpty(tf.textProperty()));
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

		// If no username is given
		if (cb.getSelectionModel().isEmpty() && (tf.getText().isEmpty() || tf.getText() == null)){
			errorMessage.setText(ERROR_NONE);
			errorMessage.setVisible(true);
			username = null;
		}	
		else if (!tf.getText().isEmpty()) {
			username = tf.getText();

			if (!StringUtils.isValidUsername(username)) {
				errorMessage.setText(ERROR_INVALID);
				errorMessage.setVisible(true);
				username = null;
			}
		} 
		else {
			username = cb.getValue();
			comboBox = true;
		}

		// If username is already Taken
		if(IOUtils.readFile("stats/users/user.txt").contains(username) && !comboBox){
			errorMessage.setText(ERROR_TAKEN);
			errorMessage.setVisible(true);
			username = null;	
		}

		// If a valid user is selected
		if (username !=null) {
			StatisticsModel.getStatisticsModel().setUser(username);
			if(!comboBox){
				IOUtils.appendFile("stats/users/user.txt", username);
			}
			mainApp.showWindow(Window.MAIN);
		} 
	}

	@FXML
	private void handleDeleteBtn() {
		if (cb.getValue() == null || cb.isDisabled()) {			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a user to delete.");
			
			alert.showAndWait();

		} else {
			Alert DeleteAlert = new Alert(AlertType.WARNING);
			DeleteAlert.setTitle("Delete Confirmation");
			DeleteAlert.setHeaderText("!! WARNING !!");
			DeleteAlert.setContentText("Are you sure you want to delete <" + cb.getValue() + ">?\n"
					+ "All the statistics for this user will be deleted\n"
					+ "and will NOT be recoverable.");

			ButtonType buttonTypeYes = new ButtonType("Yes");
			ButtonType buttonTypeNo = new ButtonType("No");

			DeleteAlert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

			Optional<ButtonType> result1 = DeleteAlert.showAndWait();
			if (result1.get() == buttonTypeYes){
				IOUtils.deleteUser(cb.getValue());
				users = FXCollections.observableArrayList(IOUtils.readFile("stats/users/user.txt"));
				cb.setItems(users);
			}
		}
	}
}
