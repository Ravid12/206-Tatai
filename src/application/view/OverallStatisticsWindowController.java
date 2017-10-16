package application.view;

import application.controller.WindowController;
import application.model.Window;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class OverallStatisticsWindowController extends WindowController{
	@FXML
	private TabPane statsWindows = new TabPane();
	
//	private StatisticsModel sm = StatisticsModel.getStatisticsModel();
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public OverallStatisticsWindowController () {
		
	}

	/**	
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Called when the user clicks on the Record button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}
	
	@FXML
	private void handleDailyStatsBtn() {
		mainApp.showWindow(Window.DAILYSTATISTICS);
	}
	
}
