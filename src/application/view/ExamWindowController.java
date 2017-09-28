package application.view;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import application.controller.WindowController;
import application.model.Window;
import application.model.ExamModel;

public class ExamWindowController extends WindowController{

	@FXML
	private Label testNumber;

	private ExamModel em = ExamModel.getExamModel();
	private int Counter = 1;

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
	}

	/**
	 * Called when the user clicks on the Record button.
	 */
	@FXML
	private void handleRecordBtn() {
		Task<Integer> task = new Task<Integer>() {
			@Override protected void call() throws Exception {
				String cmd = "./HTK/MaoriNumbers/GoSpeech2";
				ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", cmd);		
				try {
					Process pr = builder.start();
					try {
						pr.waitFor();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					pr.destroy();
				} catch (IOException e) {
				}

			}
		};
	}

	/**
	 * Called when the user clicks on the listen button.
	 */
	@FXML
	private void handleListenBtn() {
	}

	/**
	 * Called when the user clicks on the Confirm button.
	 */
	@FXML
	private void handleConfirmBtn() {
		System.out.println("Confirm " + Counter);
		testNumber.setText(em.getNext());
		Counter++;
		checkAnswer();
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