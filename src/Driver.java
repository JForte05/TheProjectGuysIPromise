import Utils.Constants.TextConstants;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
 
public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage mainStage) {
        BorderPane mainPane = new BorderPane();  // make layout to hold controls
        setupControls(mainPane);  // initialize and place controls
        Scene scene = new Scene(mainPane);  // Set up the main scene
        setStage(mainStage, scene);   // finalize and show the stage     
    }

    private void setupControls(BorderPane mainPane) {
        /* Button btnHello = new Button();
        btnHello.setText("Say 'Hello World'");
        btnHello.setOnAction(e -> lblMessage.setText("Hello World"));

        // Add controls to border pane
        mainPane.setTop(btnHello);
        BorderPane.setAlignment(btnHello, Pos.CENTER);
        mainPane.setCenter(new Label(" "));  // cheap way to get vertical space
        mainPane.setBottom(lblMessage);
        BorderPane.setAlignment(lblMessage, Pos.CENTER); */
        
        //Add title
        Label title = new Label("ADHD Project App");
        title.setFont(TextConstants.FONT_TITLE);
        title.setPadding(new Insets(10));
        mainPane.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        //Debug text
        Label debugText = new Label();
        mainPane.setBottom(debugText);
        BorderPane.setAlignment(debugText, Pos.CENTER);

        HBox topOptionLine = new HBox(0);
        BorderPane.setMargin(topOptionLine, new Insets(64));
        mainPane.setCenter(topOptionLine);
        Button opt1 = new Button();
        Button opt2 = new Button();
        Button opt3 = new Button();

        opt1.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt1.setMaxSize(256, 256);
        opt1.setStyle("-fx-background-color: rgba(0,0,0,0);");
        opt1.setOnAction((e) -> debugText.setText("Selected: opt1"));

        opt2.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt2.setMaxSize(256, 256);
        opt2.setStyle("-fx-background-color: rgba(0,0,0,0);");
        opt2.setOnAction((e) -> debugText.setText("Selected: opt2"));

        opt3.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt3.setMaxSize(256, 256);
        opt3.setStyle("-fx-background-color: rgba(0,0,0,0);");
        opt3.setOnAction((e) -> debugText.setText("Selected: opt3"));

        topOptionLine.getChildren().addAll(opt1, createHBoxSpacer(), opt2, createHBoxSpacer(), opt3);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(1280);
        mainStage.setTitle("Hello World");
        mainStage.setScene(scene);
        mainStage.show();
    }

    private static Region createHBoxSpacer(){
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
}
