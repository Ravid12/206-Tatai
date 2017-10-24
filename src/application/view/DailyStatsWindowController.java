package application.view;

import application.controller.WindowController;
import application.model.Stat;
import application.model.StatisticsModel;
import application.model.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DailyStatsWindowController extends WindowController{
	
	@FXML
	private TableView<Stat> stats = new TableView<Stat>();
	
	@FXML
	private ComboBox<String> dateBox = new ComboBox<String>();
	
	@FXML
	private Label dateLabel;
	
	private StatisticsModel sm = StatisticsModel.getStatisticsModel();
	
	
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	
	public DailyStatsWindowController () {
	}

	
	
	/**	
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	
	@FXML
	private void initialize() {
		dateBox.setItems(FXCollections.observableArrayList(sm.getDates()));
		stats.setPlaceholder(new Label("Choose a Date below to display stats..."));
	}

	
	
	/**
	 * Called when the user clicks on the Menu button.
	 */	
	
	@FXML
	private void handleMainMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}
	
	
	
	/**
	 * Called when the user clicks on the Statistics button.
	 */	
	
	@FXML
	private void handleOverallStatsBtn() {
		mainApp.showWindow(Window.STATISTICS);
	}
	
	
	
	/**
	 * Called when the user clicks on the Statistics button.
	 */	
	
	@FXML
	private void comboBoxChange() {
		showDailyStats();
		dateLabel.setText("Stats for " + sm.getCurrentUser() + " on " + dateBox.getValue());
	}
	
	
	
	/**
	 * Method that changes the contents of the TableView in
	 */	
	
	@SuppressWarnings("unchecked")
	private void showDailyStats() {
		stats.getColumns().clear();

		ObservableList<Stat> statlist = FXCollections.observableArrayList(sm.loadDayStats(dateBox.getValue()));
		
		stats.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Stat, String> questionCol = new TableColumn<Stat, String>("Question");
        TableColumn<Stat, String> answerCol = new TableColumn<Stat, String>("Correct Answer");
        TableColumn<Stat, String> resultCol = new TableColumn<Stat, String>("Result");
        stats.getColumns().addAll(questionCol, answerCol, resultCol);
        
        questionCol.setCellValueFactory(cellData -> cellData.getValue().equationProperty());
        answerCol.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        resultCol.setCellValueFactory(cellData -> cellData.getValue().resultProperty());
        stats.setItems(statlist);
	}
}
