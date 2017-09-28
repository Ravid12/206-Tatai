package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.Stat;
import application.model.Window;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatisticsWindowController extends WindowController{
	@FXML
	private TabPane statsWindows = new TabPane();
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public StatisticsWindowController () {
		
	}

	/**	
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		Difficulty difficulties[] = Difficulty.values();
		for (int i=0; i<difficulties.length; i++) {
			Tab tab = new Tab(difficulties[i].toString());
			
			TableView<Stat> stats = new TableView<Stat>();
	        TableColumn numberCol = new TableColumn("Number");
	        TableColumn correctCol = new TableColumn("Correct Attempts");
	        TableColumn incorrectCol = new TableColumn("Incorrect Attempts");
	        
	        
	        stats.getColumns().addAll(numberCol, correctCol, incorrectCol);
	        
	        
			tab.setContent(stats);
			statsWindows.getTabs().add(tab);
		}
	}

	/**
	 * Called when the user clicks on the Record button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}	
}
