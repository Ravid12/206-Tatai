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
	@FXML
	private void initialize() {
		showDailyStats();
	}

	/**
	 * Called when the user clicks on the Record button.
	 */	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}
	
	@SuppressWarnings("unchecked")
	private void showDailyStats() {
		Tab tab_daily = new Tab("Daily Stats");
		
		ObservableList<Stat> statlist = FXCollections.observableArrayList(sm.loadDayStats());
		
		TableView<Stat> stats = new TableView<Stat>();
		stats.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Stat, String> questionCol = new TableColumn<Stat, String>("Question");
        TableColumn<Stat, String> answerCol = new TableColumn<Stat, String>("Correct Answer");
        TableColumn<Stat, String> resultCol = new TableColumn<Stat, String>("Result");
        stats.getColumns().addAll(questionCol, answerCol, resultCol);
        
        questionCol.setCellValueFactory(cellData -> cellData.getValue().equationProperty());
        answerCol.setCellValueFactory(cellData -> cellData.getValue().resultProperty());
        resultCol.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        stats.setItems(statlist);
		tab_daily.setContent(stats);
		statsWindows.getTabs().add(tab_daily);
		
	}
}
