package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalTime;


public class Countdown extends Application {
	
	private Stage primaryStage;
	ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    	
    	
        // Set up size
        primaryStage.setTitle("Countdown Mobile App");
        primaryStage.setWidth(360);
        primaryStage.setHeight(640);
        
        primaryStage.setScene(mainMenu());
        primaryStage.show();
    }
    
    private Scene mainMenu() {
        //header
        Label header = new Label("Countdown Mobile App");
        header.setStyle("-fx-font-size: 20px;");
        
        //button
        Button newCountdown = new Button("new Countdown");
        
        newCountdown.setOnAction(event ->{
        	primaryStage.setScene(addCountdown());
        });
        
        VBox root = new VBox(15,header,newCountdown,listView);
        root.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        
        Scene scene = new Scene(root);
        
        return scene;
    }
    
    //adds new countdown
    private Scene addCountdown() {
        //name
        Label nameLabel = new Label("Enter Name here:");
        TextField nameText = new TextField();
        nameText.setPromptText("Name");
        HBox name = new HBox(10,nameLabel,nameText);
        
        //time
        Label TimeLabel = new Label("Enter Time here:");
        Spinner<Integer> hourSpinner = new Spinner<>();
        hourSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));  // Default to 12
        hourSpinner.setPrefWidth(80);

        // Spinner for minutes (0-59)
        Spinner<Integer> minuteSpinner = new Spinner<>();
        minuteSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));  // Default to 0
        minuteSpinner.setPrefWidth(80);
        
        Label selectedTimeLabel = new Label("");
        
        hourSpinner.valueProperty().addListener((obs, oldValue, newValue) -> updateSelectedTimeLabel(hourSpinner, minuteSpinner, selectedTimeLabel));
        minuteSpinner.valueProperty().addListener((obs, oldValue, newValue) -> updateSelectedTimeLabel(hourSpinner, minuteSpinner, selectedTimeLabel));

        HBox timeBox = new HBox(15,TimeLabel, hourSpinner, new Label(":"), minuteSpinner);
        
        //date
        Label DateLabel = new Label("Enter Date here:");
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Select a date");
        HBox date = new HBox(15,DateLabel,datePicker);
        
        Button addCount = new Button("Add");
        
        addCount.setOnAction(event ->{
        	String inputName = nameText.getText();
            String selectedDate = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String selectedTime = selectedTimeLabel.getText();

            if (inputName.isEmpty() || selectedDate.isEmpty() || selectedTime.isEmpty()) {
            	primaryStage.setScene(addCountdown());
            } else {
                addCountdownToList(inputName, selectedDate, selectedTime, listView);  // Add to ListView
                primaryStage.setScene(mainMenu());  // Go back to main menu
            }
        });
        
        VBox root = new VBox(20,name,timeBox,date,addCount);
        root.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        
        Scene scene = new Scene(root);
        
        return scene;
    }
    
    private void updateSelectedTimeLabel(Spinner<Integer> hourSpinner, Spinner<Integer> minuteSpinner, Label selectedTimeLabel) {
        int hour = hourSpinner.getValue();
        int minute = minuteSpinner.getValue();
        LocalTime selectedTime = LocalTime.of(hour, minute);
        selectedTimeLabel.setText(selectedTime.toString());
    }
    
    private void addCountdownToList(String name, String date, String time, ListView<String> listView) {
        String countdownEntry = name + " - Date: " + date + " | Time: " + time;
        listView.getItems().add(countdownEntry);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
