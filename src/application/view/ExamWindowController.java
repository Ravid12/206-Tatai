package application.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import application.controller.WindowController;
import application.model.ExamModel;
import application.model.Window;
import application.utils.IOUtils;
import application.utils.MaoriUtils;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ExamWindowController extends WindowController{

	@FXML
	private Label testNumber;

	@FXML
	private Label maoriNumber;

	@FXML
	private Label difficulty;

	@FXML
	private Label round;

	@FXML
	private JFXButton btn_next;
	
	@FXML
	private JFXButton btn_record;

	private Boolean isCompleted = false;
	private Boolean isFirstAttempt = true;

	private ExamModel em = ExamModel.getExamModel();

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public ExamWindowController () {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		testNumber.setText(em.getNext());
		maoriNumber.setText(MaoriUtils.getMaoriNumber(Integer.parseInt(testNumber.getText())));
		difficulty.setText(em.getDifficulty().toString());
		round.setText(""+em.getStage()+"/10");
	}

	/**
	 * Called when the user clicks on the Record button.
	 */
	@FXML
	private void handleRecordBtn() {
		Task<Void> task = new Task<Void>() {
			@Override 
			public Void call() {
//				String cmd = "./GoSpeech2";
//				ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", cmd);		
//				try {
//					builder.directory(new File("./HTK/MaoriNumbers/"));
//					Process pr = builder.start();						
//					try {
//						pr.waitFor();
//
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					pr.destroy();
//				} catch (IOException e) {
//				}
				return null;
			}
		};
		
		
		task.setOnSucceeded(e -> {
			String whatTheySaid = "";

			ArrayList<String> out = IOUtils.readFile("./HTK/MaoriNumbers/recout.mlf");
			for (String line : out) {
				whatTheySaid = whatTheySaid.concat(line + " ");
			}

			if (whatTheySaid.contains(maoriNumber.getText())) {
				isCompleted = true;
				em.setCorrect(true);
			} else if (isFirstAttempt) {
				isFirstAttempt=false;
				incorrectFirstAttempt();
			} else {
				incorrectSecondAttempt();
			}
			
			if (isCompleted) {
				btn_next.setDisable(false);
				btn_record.setDisable(true);
			}
		});

		new Thread(task).start();
	}

	/**
	 * Called when the user clicks on the Confirm button.
	 */
	@FXML
	private void handleConfirmBtn() {
		testNumber.setText(em.getNext());
		maoriNumber.setText(MaoriUtils.getMaoriNumber(Integer.parseInt(testNumber.getText())));
		round.setText(""+em.getStage()+"/10");
		if (em.getStage()==10) {
			mainApp.showWindow(Window.END);
		}
	}

	/**
	 * Called when the user clicks on the Menu button.
	 */
	@FXML
	private void handleMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}


	public void incorrectFirstAttempt() {

	}
	
	public void incorrectSecondAttempt() {
		
	}
}