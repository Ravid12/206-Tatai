package application.view;

import application.controller.WindowController;
import javafx.fxml.FXML;

public class EndWindowController extends WindowController{

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
		@FXML
		private void initialize() {
		}

		/**
		 * Called when the user clicks on the Record button.
		 */
		
		
		@FXML
		private void handleMainMenuBtn() {
			mainApp.showWindow(Window.MAIN);
			System.out.println("Menu");		
		}
}
