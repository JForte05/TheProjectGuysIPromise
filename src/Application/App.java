package Application;

import Application.Scenes.MainMenu;
import Application.Scenes.ProjectScene;
import Application.Users.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    public static final double HEIGHT = 850;
    public static final double WIDTH = 1280;

    private static App instance;
    public static App getInstance(){
        return instance;
    }

    private Stage mainStage;
    private User currentUser = null;

    public App(){
        instance = this;
    }
    public static void begin(String[] args){
        launch(args);
    }
    public void loadScene(ProjectScene scene){
        mainStage.setScene(scene);
    }

    @Override
    public void start(Stage mainStage) {
        this.mainStage = mainStage;
        setStage(mainStage, MainMenu.getInstance());   // finalize and show the stage     
    }

    private void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(1280);
        mainStage.setHeight(850);
        mainStage.setTitle("ADHD Project");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     * Can be null
     * @return
     */
    public User getLoggedInUser(){
        return currentUser;
    }
    public boolean isLoggedIn(){
        return currentUser == null;
    }
}
