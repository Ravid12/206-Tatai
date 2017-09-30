package application.view;

import java.util.ArrayList;

import application.controller.WindowController;
import application.model.ExamModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EndWindowController extends WindowController{

	@FXML
	private ListView<String> endList;
		
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
		for(int i =0; i<10; i++)
		{
			// 
			list.add((i + 1) + ")" + "\t\t" + ExamModel.getExamModel().getTestedNumbers().get(i) + "\t\t" + ExamModel.getExamModel().getCorrectList().get(i));
			
		}
		endList.setItems(list);
	}
	
	/**
	 * Called when the user clicks on the Main Menu button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}
}
