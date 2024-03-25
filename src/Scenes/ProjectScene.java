package Scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public abstract class ProjectScene extends Scene {
    private final BorderPane mainPane;

    protected ProjectScene(){
        super(new BorderPane());

        mainPane = (BorderPane)super.getRoot();
    }

    protected final BorderPane getMainPane(){
        return mainPane;
    }
}
