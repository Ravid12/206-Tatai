package application.view;

import java.util.ArrayList;
import java.util.Collections;

import application.controller.WindowController;
import application.model.Correctness;
import application.model.ExamModel;
import application.model.Result;
import application.model.Stat;
import application.model.Window;
import application.utils.MaoriUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EndWindowController extends WindowController{

	@FXML
	private TableView<Result> endList;
	
	@FXML
	private Label finalscore;
		
	private int noCorrect;
	private ArrayList<Result> resultList;
	
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
		noCorrect = Collections.frequency(ExamModel.getExamModel().getCorrectList(), Correctness.CORRECT);
		resultList = new ArrayList<Result>();
		
		for(int i =0; i<10; i++)
		{
			Result res = new Result(MaoriUtils.getMaoriNumber(ExamModel.getExamModel().getTestedNumbers().get(i)), ExamModel.getExamModel().getTestedNumbers().get(i).toString(), ExamModel.getExamModel().getCorrectList().get(i).toString());
			resultList.add(res);
		}
		ObservableList<Result> list = FXCollections.observableArrayList(resultList);
		endList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Result, String> maoriCol = new TableColumn<Result, String>("Maori Number");
        TableColumn<Result, String> numberCol = new TableColumn<Result, String>("Number");
        TableColumn<Result, String> correctCol = new TableColumn<Result, String>("Result");
        endList.getColumns().addAll(maoriCol, numberCol, correctCol);
        
        maoriCol.setCellValueFactory(cellData -> cellData.getValue().maoriNoProperty());
        numberCol.setCellValueFactory(cellData -> cellData.getValue().symbolProperty());
        correctCol.setCellValueFactory(cellData -> cellData.getValue().correctnessProperty());
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
