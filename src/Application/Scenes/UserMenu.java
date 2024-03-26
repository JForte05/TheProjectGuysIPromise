package Application.Scenes;

import Application.App;
import Utils.Constants.TextConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class UserMenu extends ProjectScene {
    private static UserMenu instance = null;
    public static UserMenu getInstance(){
        if (instance == null){
            instance = new UserMenu();
        }
        return instance;
    }

    private UserMenu(){
        super();

        setupBanner(getMainPane());
        setupLoginOptions(getMainPane());
    }

    private void setupBanner(BorderPane mainPane){
        BorderPane banner = new BorderPane();
        banner.setPrefHeight(128);
        banner.setStyle("-fx-background-color: #36aeeb;");

        Label title = new Label("Log In");
        title.setFont(TextConstants.FONT_TITLE);
        banner.setCenter(title);

        Button menuButton = new Button("Main Menu");
        menuButton.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 0px;");
        BorderPane.setMargin(menuButton, new Insets(8));
        BorderPane.setAlignment(menuButton, Pos.TOP_LEFT);
        banner.setTop(menuButton);

        menuButton.setOnAction((e) -> App.getInstance().loadScene(MainMenu.getInstance()));

        mainPane.setTop(banner);
    }
    private void setupLoginOptions(BorderPane mainPane){
        VBox options = new VBox();
        TextField test = new TextField("First Name");
        test.setMaxWidth(App.WIDTH / 3.0);
        test.setStyle("-fx-background-radius: 0;");
        options.getChildren().addAll(test);

        BorderPane.setAlignment(options, Pos.CENTER);
        mainPane.setCenter(options);
    }
}
