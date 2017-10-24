package application.controller;

import application.MainApp;

public abstract class WindowController implements Controller{
	// Reference to the main application.
	public MainApp mainApp;
	
	/**
	 * Is called by windows to give a reference to the MainApp.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
