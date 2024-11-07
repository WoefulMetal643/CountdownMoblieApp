package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Countdown extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set up size
        primaryStage.setTitle("Countdown Mobile App");
        primaryStage.setWidth(360);
        primaryStage.setHeight(640);
        
        //header
        Label header = new Label("Countdown Mobile App");
        header.setStyle("-fx-font-size: 20px;");
        
        //button
        Button newCountdown = new Button("new Countdown");
        
        ListView<String> listView = new ListView<>();
        
        newCountdown.setOnAction(event ->{
        	addCountdown(primaryStage);
        });
        
        VBox root = new VBox(15,header,newCountdown,listView);
        root.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //adds new countdown
    public static String addCountdown(Stage primaryStage) {
    	primaryStage.setTitle("");
        primaryStage.setWidth(360);
        primaryStage.setHeight(640);
        
        //name
        Label nameLabel = new Label("Enter Name here:");
        TextField nameText = new TextField();
        nameText.setPromptText("Name");
        HBox name = new HBox(10,nameLabel,nameText);
        
        //time
        Label timeLabel = new Label("Enter Time here:");
        TextField timeTextHour = new TextField();
        timeTextHour.setPromptText("Hour");
        Label timeLabel1 = new Label(":");
        TextField timeTextMin = new TextField();
        timeTextMin.setPromptText("Minute");
        
        HBox time = new HBox(15,timeLabel,timeTextHour);
        HBox time1 = new HBox(2,time,timeLabel1,timeTextMin);
        
        //date
        Label dateLabel = new Label("Enter Date here:");
        TextField dateText = new TextField();
        HBox date = new HBox(15,dateLabel,dateText);
        
        VBox root = new VBox(20,name,time1,date);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        return "";
    }
}
