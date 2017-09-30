package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.ExamModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class LevelSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<Difficulty> cb = new ComboBox<Difficulty>();

	@FXML
	private Label errorMessage;
	
	private ObservableList<Difficulty> levels = FXCollections.observableArrayList(Difficulty.values());

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
		errorMessage.setText("");
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
		if (! cb.getSelectionModel().isEmpty())
		{
			if(cb.getValue().equals(Difficulty.HARD) && ! mainApp.getUnlocked())
			{
				errorMessage.setText("You need to get 8 or more correct in Easy mode to unlock Hard mode");
			}
			
			else
			{
				ExamModel.resetExamModel(false);
				ExamModel.getExamModel().createList(cb.getValue());
				mainApp.showWindow(Window.EXAM);
			}
		}
		
		if (cb.getSelectionModel().isEmpty())
		{
			errorMessage.setText("Please select a difficulty");
		}
	}
}
