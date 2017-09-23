package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.ExamModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class LevelSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<Difficulty> cb = new ComboBox<Difficulty>();

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
			ExamModel.resetExamModel(false);
			ExamModel.getExamModel().createList(cb.getValue());
			mainApp.showWindow(Window.EXAM);
		}
	}
}
