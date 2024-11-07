package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Countdown extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set up mobile-like window size
        primaryStage.setTitle("Countdown Mobile App");
        primaryStage.setWidth(360);
        primaryStage.setHeight(640);
        
        Label header = new Label("Countdown Mobile App");
        header.setStyle(null);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
