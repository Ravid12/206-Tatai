package application.view;

import application.controller.WindowController;
import application.model.Mode;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class PracticeSelectWindowController extends WindowController{
	
	@FXML
	private ComboBox<Mode> cb;
	
	private ObservableList<Mode> levels = FXCollections.observableArrayList(Mode.values());
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public PracticeSelectWindowController() {
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
		System.out.println("Menu");		
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
//				errorMessage.setText("You need to get 8 or more correct in Easy mode to unlock Hard mode");
				System.out.println("Equation");
			}
			
			else
			{
				mainApp.showWindow(Window.PRACTICE);
			}
		}
		
		if (cb.getSelectionModel().isEmpty())
		{
//			errorMessage.setText("Please select a difficulty");
		}
	}
}
