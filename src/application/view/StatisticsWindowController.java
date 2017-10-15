package application.view;

import application.controller.WindowController;
import application.model.Difficulty;
import application.model.Stat;
import application.model.StatisticsModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatisticsWindowController extends WindowController{
	@FXML
	private TabPane statsWindows = new TabPane();
	
	private StatisticsModel sm = StatisticsModel.getStatisticsModel();
	
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
	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
		Difficulty difficulties[] = Difficulty.values();
		for (int i=0; i<difficulties.length; i++) {
			Tab tab = new Tab(difficulties[i].toString());
			
			ObservableList<Stat> statlist = FXCollections.observableArrayList(StatsModel.getInstance().getStats(difficulties[i]));
			
			TableView<Stat> stats = new TableView<Stat>();
			stats.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	        TableColumn<Stat, Integer> numberCol = new TableColumn<Stat, Integer>("Number");
	        TableColumn<Stat, Integer> correctCol = new TableColumn<Stat, Integer>("Correct Attempts");
	        TableColumn<Stat, Integer> incorrectCol = new TableColumn<Stat, Integer>("Incorrect Attempts");
	        stats.getColumns().addAll(numberCol, correctCol, incorrectCol);
	        
	        numberCol.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asObject());
	        correctCol.setCellValueFactory(cellData -> cellData.getValue().correctProperty().asObject());
	        incorrectCol.setCellValueFactory(cellData -> cellData.getValue().incorrectProperty().asObject());
	        stats.setItems(statlist);
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
	}	
}
