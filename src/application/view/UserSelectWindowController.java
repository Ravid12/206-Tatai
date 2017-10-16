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
//		errorMessage.setText("");
//		errorMessage.setTextFill(Color.web(redColour));
	}

	/**
	 * Called when the user clicks on the Start button.
	 */	
	@FXML
	private void handleLoginBtn() {
		//TODO: If user types name in text field and it's already in combobox
		String username = null;
		
		if (cb.getSelectionModel().isEmpty() && tf.getText().isEmpty() && tf.getText() == null){
			System.out.println("no username selected");
			username = null;
		}	
		else if (!cb.getSelectionModel().isEmpty() && !tf.getText().isEmpty()) {
			//TODO: make this intuitive please Zinzan
		}
		else {
			if (!cb.getSelectionModel().isEmpty()) {
				username = cb.getValue();
			} else {
				if(IOUtils.readFile("stats/users/user.txt").contains(tf.getText()))
				{
					errorMessage.setVisible(true);
				}
				else
				{
					username = tf.getText();
				}
			}
		}
		
		if (username !=null) {
			StatisticsModel.getStatisticsModel().setUser(username);
			IOUtils.appendFile("stats/users/user.txt", username);
			mainApp.showWindow(Window.MAIN);
			
		} 
	}
}
