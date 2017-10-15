package application.view;

import java.util.ArrayList;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.EquationModel;
import application.model.ExamModel;
import application.model.Mode;
import application.model.Operator;
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
	private void handleSelectBtn() 
	{
		if (! cb.getSelectionModel().isEmpty()) 
		{
			ArrayList<Operator> o = new ArrayList<Operator>();
			if(cb.getValue().equals(Difficulty.EASY))
			{
				
				if (addBox.isSelected())
				{
					System.out.println("add");					
					o.add(Operator.ADDITION);
					
				}
				
				if (subBox.isSelected())
				{
					System.out.println("sub");
					o.add(Operator.SUBTRACTION);
				}
				
				if (mulBox.isSelected())
				{
					System.out.println("mul");
					o.add(Operator.MULTIPLICATION);
				}
				
				if (divBox.isSelected())
				{
					System.out.println("div");
					o.add(Operator.DIVISION);
				}
				
				if (!divBox.isSelected() && !mulBox.isSelected() && !subBox.isSelected() && !addBox.isSelected())
				{
					System.out.println("none selected");
				}
				EquationModel.resetExamModel(o);
				ExamModel.setDifficulty(Difficulty.EASY);
				EquationModel.getExamModel().createList();
			}
			
			else if(cb.getValue().equals(Difficulty.HARD))
			{
				
				if (addBox.isSelected())
				{
					System.out.println("add");					
					o.add(Operator.ADDITION);
					
				}
				
				if (subBox.isSelected())
				{
					System.out.println("sub");
					o.add(Operator.SUBTRACTION);
				}
				
				if (mulBox.isSelected())
				{
					System.out.println("mul");
					o.add(Operator.MULTIPLICATION);
				}
				
				if (divBox.isSelected())
				{
					System.out.println("div");
					o.add(Operator.DIVISION);
				}
				
				if (!divBox.isSelected() && !mulBox.isSelected() && !subBox.isSelected() && !addBox.isSelected())
				{
					System.out.println("none selected");
				}
				EquationModel.resetExamModel(o);
				ExamModel.setDifficulty(Difficulty.HARD);
				EquationModel.getExamModel().createList();
			}
			
			mainApp.showWindow(Window.EXAM);
		}
		
		else
		{
			System.out.println("Please select a difficulty");
		}
	}
}
