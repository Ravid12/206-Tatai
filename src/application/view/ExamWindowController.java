package application.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

	private ExamModel em = ExamModel.getExamModel();
	private int counter = 1;

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
		round.setText(""+counter+"/10");
	}

	/**
	 * Called when the user clicks on the Record button.
	 */
	@FXML
	private void handleRecordBtn() {

		Task<Void> task = new Task<Void>() {
			@Override 
			public Void call() {
				String cmd = "./GoSpeech2";
				ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", cmd);		
				try {
					builder.directory(new File("./HTK/MaoriNumbers/"));
					Process pr = builder.start();						
					try {
						pr.waitFor();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					pr.destroy();
				} catch (IOException e) {
				}
				return null;
			}
		};
		task.setOnSucceeded(e -> {
			ArrayList<String> out = IOUtils.readFile("./HTK/MaoriNumbers/recout.mlf");
			for (String line : out) {
				System.out.println(line);
			}
		});
		
		new Thread(task).start();
	}

	/**
	 * Called when the user clicks on the Confirm button.
	 */
	@FXML
	private void handleNextBtn() {
		if (counter < 11) counter++;
		checkAnswer();
		testNumber.setText(em.getNext());
		maoriNumber.setText(MaoriUtils.getMaoriNumber(Integer.parseInt(testNumber.getText())));
		round.setText(""+counter+"/10");
		if (counter == 11)
		{
			mainApp.showWindow(Window.END);
		}
	}

	/**
	 * Called when the user clicks on the Menu button.
	 */
	@FXML
	private void handleMenuBtn() {
		mainApp.showWindow(Window.MAIN);
		System.out.println("Menu");		
	}

	/**
	 * checks user recording with HTK, updates screen if correct/incorrect, 
	 * and updates stats model.
	 */
	public void checkAnswer() {

	}
}