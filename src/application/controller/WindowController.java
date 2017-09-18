package application.controller;

public abstract class WindowController implements Controller{
	// Reference to the main application.
	protected MainApp mainApp;
	
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	}
