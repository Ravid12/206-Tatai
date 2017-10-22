package application.view;

import java.util.ArrayList;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.EquationModel;
import application.model.Operator;
import application.model.StatisticsModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class EquationSelectWindowController extends WindowController{
	@FXML
	private ComboBox<Difficulty> cb = new ComboBox<Difficulty>();

	private ObservableList<Difficulty> levels = FXCollections.observableArrayList(Difficulty.values());

	@FXML
	private CheckBox addBox;

	@FXML
	private CheckBox subBox;

	@FXML
	private CheckBox mulBox;

	@FXML
	private CheckBox divBox;

	@FXML
	private Button selectButton;

	@FXML
	private Button menuButton;

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public EquationSelectWindowController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		cb.setItems(levels);
		//		errorMessage.setText("");
		//		errorMessage.setTextFill(Color.web(redColour));
	}

	/**
	 * Called when the user clicks on the Menu button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}

	/**
	 * Called when the user clicks on the Start button.
	 */	
	@FXML
	private void handleSelectBtn() {
		if (! cb.getSelectionModel().isEmpty()) {
			ArrayList<Operator> o = new ArrayList<Operator>();

			if (addBox.isSelected()) {
				o.add(Operator.ADDITION);
			}

			if (subBox.isSelected()) {
				o.add(Operator.SUBTRACTION);
			}

			if (mulBox.isSelected()) {
				o.add(Operator.MULTIPLICATION);
			}

			if (divBox.isSelected()) {
				o.add(Operator.DIVISION);
			}			
			
			EquationModel.resetExamModel();
			EquationModel.setOperators(o);
			EquationModel.getEquationModel().setDifficulty(cb.getValue());
			EquationModel.getEquationModel().createList();
			StatisticsModel.getStatisticsModel().startTempStat();
			
			mainApp.showWindow(Window.EXAM);
		}			
		else {
		}
	}
}
