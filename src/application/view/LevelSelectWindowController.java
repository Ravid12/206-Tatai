package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.NumberModel;
import application.model.StatisticsModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LevelSelectWindowController extends WindowController{

	@FXML
	private ComboBox<Difficulty> cb = new ComboBox<Difficulty>();

	@FXML
	private Label errorMessage;

	private ObservableList<Difficulty> levels = FXCollections.observableArrayList(Difficulty.values());
	private final String redColour = "#e80000";
	
	
	
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
		errorMessage.setTextFill(Color.web(redColour));
	}

	
	
	/**
	 * Called when the user clicks on the Menu button.
	 */	
	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MODESELECT);	
	}


	
	/**
	 * Called when the user clicks on the Start button.
	 */	
	
	@FXML
	private void handleStartBtn() {
		if (! cb.getSelectionModel().isEmpty()) {
			NumberModel.resetExamModel();
			NumberModel.getExamModel().setDifficulty(cb.getValue());
			NumberModel.getExamModel().createList();
			StatisticsModel.getStatisticsModel().startTempStat();
			mainApp.showWindow(Window.EXAM);
		}

		if (cb.getSelectionModel().isEmpty()) {
			errorMessage.setText("Please select a difficulty");
		}
	}
}
