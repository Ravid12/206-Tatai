package application;


import java.io.File;
import java.io.IOException;

import application.controller.Controller;
import application.model.Window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
//    private boolean unlocked = false;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Tatai");
        this.primaryStage.setResizable(false);

        initRootLayout();

        showWindow(Window.USERSELECT);
    }

    
    
    /**
     * Initializes the root layout.
     */
    
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(MainApp.class.getResource("view/red-theme.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   

    
    /**
     * Initializes the window that goes inside the rootlayout.
     * @param windowName The window to display inside the root layout.
     */
    
    public void showWindow(Window windowName) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/" + windowName.toString() + "Window.fxml"));
            AnchorPane Window = (AnchorPane) loader.load();

            // Set MainWindow into the center of root layout.
            rootLayout.setCenter(Window);

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }    
    }


    
    /**
     * Returns the main stage.
     */
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
    
    /**
     * Entry point for application.
     */
    
    public static void main(String[] args) {
    	new File("./stats").mkdir();
    	new File("./stats/users").mkdir();
		try {
			new File("./stats/users/user.txt").createNewFile();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

    	launch(args);
    }
}
