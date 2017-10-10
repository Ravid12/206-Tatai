package application.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import application.controller.WindowController;
import application.model.ExamModel;
import application.model.StatsModel;
import application.model.Window;
import application.utils.IOUtils;
import application.utils.MaoriUtils;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;

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
	private Label attemptsLeft;

	@FXML
	private Label message;

	@FXML
	private JFXButton btn_next;

	@FXML
	private JFXButton btn_record;

	@FXML
	private JFXButton btn_menu;

	@FXML
	private ProgressBar recordingProgress;

	private Boolean isCompleted = false;
	private Boolean isFirstAttempt = true;
	private final String greenColour = "#13ea00";
	private final String redColour = "#e80000";

	private int counter = 1;

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
		difficulty.setText("Difficulty: " + em.getDifficulty().toString());
		round.setText("Question " + counter + " of 10");
		attemptsLeft.setText("You have 2 attempts remaining");
		message.setText("");
		maoriNumber.setVisible(false);
		maoriNumber.setTextFill(Color.web(redColour));
		recordingProgress.setProgress(0);
	}

	/**
	 * Called when the user clicks on the Record button.
	 * Creates a new task to Record the person's voice.
	 * It is then compared to the Maori Number that was generated.
	 */
	@FXML
	private void handleRecordBtn() {
		Task<Void> task = new Task<Void>() {
			@Override 
			public Void call() {
				//				btn_menu.setDisable(true);
				//				btn_record.setDisable(true);
				//				btn_next.setDisable(true);
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

			ArrayList<String> out = IOUtils.readFile("HTK/MaoriNumbers/recout.mlf");
			for (String line : out) {
				whatTheySaid = whatTheySaid.concat(line + " ");
			}

			if (whatTheySaid.contains(maoriNumber.getText())) {
				isCompleted = true;
				em.setCorrect(true);
				StatsModel.getInstance().updateStats(em.getDifficulty(),Integer.parseInt(testNumber.getText()), true);
				correctAttempt();
			} else if (isFirstAttempt) {
				isFirstAttempt=false;
				incorrectFirstAttempt();
			} else {
				incorrectSecondAttempt();
				isCompleted = true;
				em.setCorrect(false);
				StatsModel.getInstance().updateStats(em.getDifficulty(),Integer.parseInt(testNumber.getText()), false);
			}

			if (isCompleted) {
				btn_next.setDisable(false);
				btn_record.setDisable(true);
			}

			btn_menu.setDisable(false);

		});


		// New task for the loading bar
		Task<Void> loadingTask = new Task<Void>() {
			@Override 
			public Void call() {
				for(int i = 0; i < 1000; i++)
				{
					recordingProgress.setProgress(i*0.001 + 0.001);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				recordingProgress.setProgress(0);

				for(int i = 0; i < 1000; i++)
				{
					recordingProgress.setProgress(i*0.001 + 0.001);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return null;
			}
		};


		loadingTask.setOnSucceeded(e -> {

		});

		new Thread(task).start();
		new Thread(loadingTask).start();
	}

	/**
	 * Called when the user clicks on the Confirm button.
	 */
	@FXML
	private void handleConfirmBtn() {		
		testNumber.setText(em.getNext());
		counter++;
		maoriNumber.setText(MaoriUtils.getMaoriNumber(Integer.parseInt(testNumber.getText())));
		round.setText(""+counter+"/10");
		if (counter==11) {
			mainApp.showWindow(Window.END);
		}

		btn_next.setDisable(true);
		btn_record.setDisable(false);
		isCompleted = false;
		isFirstAttempt=true;
		attemptsLeft.setText("You have 2 attempts remaining");
		message.setText("");
		maoriNumber.setVisible(false);
	}

	/**
	 * Called when the user clicks on the Menu button.
	 */
	@FXML
	private void handleMenuBtn() {
		mainApp.showWindow(Window.MAIN);
	}

	// called when correct attempt is input
	private void correctAttempt() 
	{
		message.setText("Correct, Well Done");
		message.setTextFill(Color.web(greenColour));
		attemptsLeft.setText("Press Next to continue");
		maoriNumber.setVisible(false);
	}

	// This should change display to red or show a cross or something
	private void incorrectFirstAttempt() 
	{
		message.setText("Incorrect, Try again");
		message.setTextFill(Color.web(redColour));
		attemptsLeft.setText("You have 1 attempt remaining");
		btn_record.setDisable(false);
	}

	// This should change display to red and also say "you should have said"
	private void incorrectSecondAttempt() 
	{
		attemptsLeft.setText("Press Next to continue");
		message.setText("Incorrect, You should have said");
		message.setTextFill(Color.web(redColour));
		maoriNumber.setVisible(true);
	}
}
