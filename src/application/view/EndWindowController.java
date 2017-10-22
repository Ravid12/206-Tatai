package application.view;

import java.util.ArrayList;
import application.controller.WindowController;
import application.model.Result;
import application.model.StatisticsModel;
import application.model.Window;
import application.utils.IOUtils;
import application.utils.MaoriUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EndWindowController extends WindowController{

	@FXML
	private TableView<Result> endList;
	
	@FXML
	private Label finalscore;
		
	private int noCorrect = 0;
	private ArrayList<Result> resultList;
	private ArrayList<String> results = IOUtils.readFile("stats/temp.txt");
	
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
	
	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
		StatisticsModel.getStatisticsModel().saveStats();

		resultList = new ArrayList<Result>();
		
		for(int i =0; i<10; i++)
		{
			String[] current = results.get(i+1).split("%");
			Result res = new Result(current[0], "(" + current[1] + ") " + MaoriUtils.getMaoriNumber(current[1]), current[2] );
			resultList.add(res);
		}
		ObservableList<Result> list = FXCollections.observableArrayList(resultList);
		endList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Result, String> questionCol = new TableColumn<Result, String>("Question");
        TableColumn<Result, String> answerCol = new TableColumn<Result, String>("Answer");
        TableColumn<Result, String> correctCol = new TableColumn<Result, String>("Result");
        endList.getColumns().addAll(questionCol, answerCol, correctCol);
        
        questionCol.setCellValueFactory(cellData -> cellData.getValue().maoriNoProperty());
        answerCol.setCellValueFactory(cellData -> cellData.getValue().symbolProperty());
        correctCol.setCellValueFactory(cellData -> cellData.getValue().correctnessProperty());
		endList.setItems(list);
		finalscore.setText("You got " + StatisticsModel.getStatisticsModel().getRoundScore() + "/10 Correct!");
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
