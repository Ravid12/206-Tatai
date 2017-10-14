package application.view;

import java.util.ArrayList;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.EquationModel;
import application.model.ExamModel;
import application.model.NumberModel;
import application.model.Operator;
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
				/**
				 * TODO: Currently only chooses addition. Have to fix this for users 
				 * to choose what operators etc;
				 */
				ArrayList<Operator> o = new ArrayList<Operator>();
				o.add(Operator.DIVISION);
				o.add(Operator.MULTIPLICATION);
				o.add(Operator.SUBTRACTION);
				EquationModel.resetExamModel(o);
				EquationModel.getExamModel().createList(cb.getValue());
				//TODO: Add users so we can put username in here
				StatisticsModel.getStatisticsModel().startTempStat("user");
				mainApp.showWindow(Window.EXAM);
			}
		}
		
		if (cb.getSelectionModel().isEmpty())
		{
			errorMessage.setText("Please select a difficulty");
		}
	}
}
