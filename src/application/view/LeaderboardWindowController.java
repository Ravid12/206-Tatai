package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.ExamModel;
import application.model.StatsModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class LeaderboardWindowController extends WindowController{

	@FXML
	private ListView<String> StatsList = new ListView<String>();

	private ObservableList<String> Statistics = FXCollections.observableArrayList(new StatsModel().getStats());
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public LeaderboardWindowController () {
		
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		StatsList.setItems(Statistics);
	}

	/**
	 * Called when the user clicks on the Record button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}	
}
