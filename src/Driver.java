import Utils.StylingUtils;
import Utils.Constants.TextConstants;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage mainStage) {
        BorderPane mainPane = new BorderPane();  // make layout to hold controls
        setupTitleBanner(mainPane);
        setupMenuOptions(mainPane);
        Scene scene = new Scene(mainPane);  // Set up the main scene
        setStage(mainStage, scene);   // finalize and show the stage     
    }

    private void setupTitleBanner(BorderPane mainPane){
        BorderPane banner = new BorderPane();
        banner.setPrefHeight(128);
        banner.setStyle("-fx-background-color: #36aeeb;");

        Label title = new Label("ADHD Project App");
        title.setFont(TextConstants.FONT_TITLE);
        title.setPadding(new Insets(10));
        banner.setCenter(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        mainPane.setTop(banner);
    }

    private void setupMenuOptions(BorderPane mainPane) {
        //Debug text for callback tests
        Label debugText = new Label();
        mainPane.setBottom(debugText);
        BorderPane.setAlignment(debugText, Pos.CENTER);

        BorderPane options = new BorderPane();
        mainPane.setCenter(options);

        //Top row of options
        HBox topOptionLine = new HBox(0);
        BorderPane.setMargin(topOptionLine, new Insets(32));
        options.setTop(topOptionLine);
        Button opt1 = new Button();
        Button opt2 = new Button();
        Button opt3 = new Button();

        //Styling
        opt1.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt1.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt1.setOnAction((e) -> debugText.setText("Selected: opt1")); // Test callback
        opt1.setPadding(new Insets(0, 0, 0, 32));

        //Styling
        opt2.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt2.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt2.setOnAction((e) -> debugText.setText("Selected: opt2")); // Test callback
        opt2.setPadding(new Insets(0));

        //Styling
        opt3.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt3.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt3.setOnAction((e) -> debugText.setText("Selected: opt3")); // Test callback
        opt3.setPadding(new Insets(0, 32, 0, 0));

        topOptionLine.getChildren().addAll(opt1, StylingUtils.createHBoxSpacer(), opt2, StylingUtils.createHBoxSpacer(), opt3);

        //Bottom row of options
        HBox bottomOptionLine = new HBox(0);
        BorderPane.setMargin(bottomOptionLine, new Insets(32));
        options.setBottom(bottomOptionLine);
        Button opt4 = new Button();
        Button opt5 = new Button();
        Button opt6 = new Button();

        //Styling
        opt4.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt4.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt4.setOnAction((e) -> debugText.setText("Selected: opt4")); // Test callback
        opt4.setPadding(new Insets(0, 0, 0, 32));

        //Styling
        opt5.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt5.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt5.setOnAction((e) -> debugText.setText("Selected: opt5")); // Test callback
        opt5.setPadding(new Insets(0));

        //Styling
        opt6.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt6.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt6.setOnAction((e) -> debugText.setText("Selected: opt6")); // Test callback
        opt6.setPadding(new Insets(0, 32, 0, 0));

        bottomOptionLine.getChildren().addAll(opt4, StylingUtils.createHBoxSpacer(), opt5, StylingUtils.createHBoxSpacer(), opt6);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(1280);
        mainStage.setTitle("Hello World");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
