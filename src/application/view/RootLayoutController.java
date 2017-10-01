package application.view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import application.controller.WindowController;

public class RootLayoutController extends WindowController{
	
	@FXML
	ImageView leftSide;
	
	@FXML
	ImageView rightSide;
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public RootLayoutController () {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		Image image = new Image("side.png");
		leftSide.setImage(image);
		rightSide.setImage(image);
	}
}