package application.controller;

import application.MainApp;

public interface Controller {
	
	/**
     * All controllers must implement this method.
     * It gives all controllers a reference to the MainApp.
     * @param mainApp reference to the MainApp object
     */
	public void setMainApp(MainApp mainApp);
}
