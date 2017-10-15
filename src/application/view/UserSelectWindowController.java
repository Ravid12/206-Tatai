package application.view;

import application.controller.WindowController;
import application.model.Mode;
import application.model.StatisticsModel;
import application.model.Window;
import application.utils.IOUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UserSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<String> cb;
	
	@FXML
	private TextField tf;
	
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
		cb.setItems(users);
//		errorMessage.setText("");
//		errorMessage.setTextFill(Color.web(redColour));
	}

	/**
	 * Called when the user clicks on the Start button.
	 */	
	@FXML
	private void handleLoginBtn() {
		if (!cb.getSelectionModel().isEmpty())
		{
			if(!tf.getText().isEmpty() && tf.getText() != null)
			{
				StatisticsModel.getStatisticsModel().setUser(tf.getText());
				IOUtils.appendFile("stats/users/user.txt", tf.getText());
				mainApp.showWindow(Window.MAIN);
			}
			
			else
			{
				StatisticsModel.getStatisticsModel().setUser(cb.getValue());
				mainApp.showWindow(Window.MAIN);
			}
		}
		
		if (cb.getSelectionModel().isEmpty())
		{
			if(!tf.getText().isEmpty() && tf.getText() != null)
			{
				StatisticsModel.getStatisticsModel().setUser(tf.getText());
				IOUtils.appendFile("stats/users/user.txt", tf.getText());
				mainApp.showWindow(Window.MAIN);
			}
			
			else
			{
				System.out.println("no username selected");
			}
		}
	}
}
