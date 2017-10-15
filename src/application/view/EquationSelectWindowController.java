package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.Mode;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
		System.out.println("Menu");		
	}

	/**
	 * Called when the user clicks on the Start button.
	 */	
	@FXML
	private void handleSelectBtn() {
		if (! cb.getSelectionModel().isEmpty()) 
		{
			if(cb.getValue().equals(Difficulty.EASY))
			{
				
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
			
			else if(cb.getValue().equals(Difficulty.HARD))
			{
				
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
			
			else
			{
				System.out.println("Please select a difficulty");
			}
		}
	}
}
