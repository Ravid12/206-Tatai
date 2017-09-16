package application.view;

import application.controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InstructionWindowController {

	@FXML
	private Label instructions;

	
	// Reference to the main application.
		private MainApp mainApp;
		
		/**
		 * The constructor.
		 * The constructor is called before the initialize() method.
		 */
		public InstructionWindowController () {
		}

		/**
		 * Initializes the controller class. This method is automatically called
		 * after the fxml file has been loaded.
		 */
		@FXML
		private void initialize() {
			
			//TODO: Finish this
			instructions.setText(
					  "Taatai is an app for practicing to pronounce Maori numbers. "
					+ "There are two game modes: play and practice. \n"
					+ "In Practice mode, you can choose which numbers you would like to "
					+ "learn, and practice them. \n"
					+ "In Play mode, you are tested, and given a score out of 10. There "
					+ "are 2 difficulties in play mode: easy and hard. In easy mode, you "
					+ "are only tested on numbers below 10, but in hard mode, you can be "
					+ "tested on any number below 100."
					);
		}

		/**
		 * Called when the user clicks on the Record button.
		 */
		
		
		@FXML
		private void handleMainMenuBtn() {
			mainApp.showMainWindow();
			System.out.println("Menu");		
		}

		/**
		 * Is called by the main application to give a reference back to itself.
		 * 
		 * @param mainApp
		 */
		public void setMainApp(MainApp mainApp) {
			this.mainApp = mainApp;
		}
	
}
