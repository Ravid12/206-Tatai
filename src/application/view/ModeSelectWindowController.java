package application.view;

import application.controller.WindowController;
import application.model.EquationModel;
import application.model.Mode;
import application.model.NumberModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ModeSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<Mode> cb;
	
	private ObservableList<Mode> levels = FXCollections.observableArrayList(Mode.values());
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public ModeSelectWindowController() {
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
		if (! cb.getSelectionModel().isEmpty())
		{
			if(cb.getValue().equals(Mode.EQUATION))
			{
				EquationModel.resetExamModel();
				mainApp.showWindow(Window.EQUATIONSELECT);
			}
			
			else
			{
				NumberModel.resetExamModel();
				mainApp.showWindow(Window.LEVELSELECT);
			}
		}
		
		if (cb.getSelectionModel().isEmpty())
		{
		}
	}
}

