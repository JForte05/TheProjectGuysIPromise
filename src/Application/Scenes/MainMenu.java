package Application.Scenes;

import Utils.Constants.TextConstants;
import Application.App;
import Utils.StylingUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainMenu extends ProjectScene {
    private static MainMenu instance = null;
    
    public static MainMenu getInstance(){
        if (instance == null){
            instance = new MainMenu();
        }
        return instance;
    }

    private MainMenu(){
        super();

        setupTitleBanner(super.getMainPane());
        setupMenuOptions(super.getMainPane());
    }

    private void setupTitleBanner(BorderPane mainPane){
        BorderPane banner = new BorderPane();
        banner.setPrefHeight(128);
        banner.setStyle("-fx-background-color: #36aeeb;");

        BorderPane userInfo = new BorderPane();

        Label loggedInAs = new Label("Not Logged In");
        loggedInAs.setFont(TextConstants.FONT_USERREADOUT);
        BorderPane.setMargin(loggedInAs, new Insets(8));
        BorderPane.setAlignment(loggedInAs, Pos.TOP_RIGHT);
        userInfo.setRight(loggedInAs);
        
        Button loginButton = new Button("Log In");
        loginButton.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 0px;");
        BorderPane.setMargin(loginButton, new Insets(8));
        BorderPane.setAlignment(loginButton, Pos.TOP_LEFT);
        userInfo.setLeft(loginButton);

        loginButton.setOnAction((e) -> App.getInstance().loadScene(UserMenu.getInstance()));

        banner.setTop(userInfo);

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
        debugText.setFont(TextConstants.FONT_TITLE);
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
        HBox.setMargin(opt1, new Insets(0, 0, 0, 32));

        //Styling
        opt2.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt2.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt2.setOnAction((e) -> debugText.setText("Selected: opt2")); // Test callback
        opt2.setPadding(new Insets(0));

        //Styling
        opt3.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt3.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt3.setOnAction((e) -> debugText.setText("Selected: opt3")); // Test callback
        HBox.setMargin(opt3, new Insets(0, 32, 0, 0));

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
        HBox.setMargin(opt4, new Insets(0, 0, 0, 32));

        //Styling
        opt5.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt5.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt5.setOnAction((e) -> debugText.setText("Selected: opt5")); // Test callback
        opt5.setPadding(new Insets(0));

        //Styling
        opt6.setGraphic(new ImageView(new Image("Assets/Images/test.png")));
        opt6.setStyle("-fx-background-color: rgba(0,0,0,0);"); // Remove gray background
        opt6.setOnAction((e) -> debugText.setText("Selected: opt6")); // Test callback
        HBox.setMargin(opt6, new Insets(0, 32, 0, 0));

        bottomOptionLine.getChildren().addAll(opt4, StylingUtils.createHBoxSpacer(), opt5, StylingUtils.createHBoxSpacer(), opt6);
    }
}
