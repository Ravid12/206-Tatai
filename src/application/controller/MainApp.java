package application.controller;

import java.io.IOException;

import application.view.Window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Tatai");

        initRootLayout();

        showWindow(Window.MAIN);
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void showWindow(Window windowName) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/" + windowName.toString() + "Window.fxml"));
            AnchorPane EasyLevel = (AnchorPane) loader.load();

            // Set MainWindow into the center of root layout.
            rootLayout.setCenter(EasyLevel);
        
            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
//
//  /**
//   * Shows the MainWindow inside the root layout.
//   */
//  public void showMainWindow() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/MainWindow.fxml"));
//          AnchorPane mainWindow = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(mainWindow);
//      
//          // Give the controller access to the main app.
//          MainWindowController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//  
//  /**
//   * Shows the ExamWindow inside the root layout.
//   */
//  public void showExamWindow() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/ExamWindow.fxml"));
//          AnchorPane mainWindow = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(mainWindow);
//      
//          // Give the controller access to the main app.
//          ExamWindowController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//  
//  /**
//   * Shows the PractiseWindow inside the root layout.
//   */
//  public void showPractiseWindow() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/PractiseWindow.fxml"));
//          AnchorPane practiceWindow = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(practiceWindow);
//      
//          // Give the controller access to the main app.
//          PractiseWindowController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//  
//  public void showInstructionWindow() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/InstructionWindow.fxml"));
//          AnchorPane instructionWindow = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(instructionWindow);
//      
//          // Give the controller access to the main app.
//          InstructionWindowController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//  
//  public void showLeaderboardWindow() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/LeaderboardWindow.fxml"));
//          AnchorPane leaderboardWindow = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(leaderboardWindow);
//      
//          // Give the controller access to the main app.
//          LeaderboardWindowController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//  
//  public void showEndWindow() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/EndWindow.fxml"));
//          AnchorPane endWindow = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(endWindow);
//      
//          // Give the controller access to the main app.
//          EndWindowController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//  
//  /**
//   * Shows the MainWindow inside the root layout.
//   */
//  public void showEasyLevel() {
//      try {
//          // Load person overview.
//          FXMLLoader loader = new FXMLLoader();
//          loader.setLocation(MainApp.class.getResource("../view/LevelEasy.fxml"));
//          AnchorPane EasyLevel = (AnchorPane) loader.load();
//
//          // Set MainWindow into the center of root layout.
//          rootLayout.setCenter(EasyLevel);
//      
//          // Give the controller access to the main app.
//          EasyLevelController controller = loader.getController();
//          controller.setMainApp(this);
//          
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      
//  }
//
}