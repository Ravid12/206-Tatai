package application.controller;

import application.MainApp;

public abstract class WindowController implements Controller{
	// Reference to the main application.
	public MainApp mainApp;
	
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
