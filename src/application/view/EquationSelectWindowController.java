package application.view;

import application.controller.WindowController;
import application.model.Mode;
import application.model.Window;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class EquationSelectWindowController extends WindowController{
	
	@FXML
	private CheckBox addBox;
	
	@FXML
	private CheckBox subBox;
	
	@FXML
	private CheckBox mulBox;
	
	@FXML
	private CheckBox divBox;
	
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
		if (addBox.isSelected())
		{
			System.out.println("add");
		}
		
		if (subBox.isSelected())
		{
			System.out.println("sub");
		}
		
		if (mulBox.isSelected())
		{
			System.out.println("mul");
		}
		
		if (divBox.isSelected())
		{
			System.out.println("div");
		}
		
		else
		{
			
		}
	}
}
