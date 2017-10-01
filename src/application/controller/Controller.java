package application.controller;

import application.MainApp;

public interface Controller {
	
	/**
     * All controllers must implement this method.
     * It gives all controllers a reference to the MainApp.
     */
	public void setMainApp(MainApp mainApp);
}
