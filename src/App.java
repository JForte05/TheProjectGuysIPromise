import Scenes.MainMenu;
import Scenes.ProjectScene;
import Users.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {    
    private Stage mainStage;
    private User currentUser = null;

    public App(){}

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
