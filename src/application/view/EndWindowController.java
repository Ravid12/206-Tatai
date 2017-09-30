package application.view;

import java.util.ArrayList;
import java.util.Collections;

import application.controller.WindowController;
import application.model.Correctness;
import application.model.ExamModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class EndWindowController extends WindowController{

	@FXML
	private ListView<String> endList;
	
	@FXML
	private Label finalscore;
		
	private int noCorrect;
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public EndWindowController () {
	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	
	@FXML
	private void initialize() {
		ObservableList<String> list = FXCollections.observableArrayList();
		noCorrect = Collections.frequency(ExamModel.getExamModel().getCorrectList(), Correctness.CORRECT);
		for(int i =0; i<10; i++)
		{
			// 
			list.add((i + 1) + ")" + "\t\t" + ExamModel.getExamModel().getTestedNumbers().get(i) + "\t\t\t\t" + ExamModel.getExamModel().getCorrectList().get(i));
			
		}
		endList.setItems(list);
		finalscore.setText("You got " + noCorrect + "/10 Correct!");
	}
	
	/**
	 * Called when the user clicks on the Main Menu button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		if(noCorrect > 7)
		{
			mainApp.setUnlocked();
		}
		mainApp.showWindow(Window.MAIN);
	}
}
