package com.example.trytable2;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StopwatchApp extends Application {
    private Timeline timeline;
    private int secondsElapsed = 0;

    @Override
    public void start(Stage primaryStage) {

        Label daysLabel = new Label("Days");
        Label hoursLabel = new Label("Hours");
        Label minutesLabel = new Label("Minutes");
        Label secondsLabel = new Label("Seconds");

        Label explain1 = new Label("The time spent in the hospital since the program was run: ");
        explain1.setStyle("-fx-font-size: 50px;-fx-text-fill: black;");
        Label explain2 = new Label("");
        explain2.setStyle("-fx-font-size: 50px;-fx-text-fill: blue;");


        Label timerLabel = new Label();
        timerLabel.setStyle("-fx-font-size: 100px;");

        //timerLabel.setStyle("-fx-font-size: 300px;");
        double labelWidth = timerLabel.getFont().getSize()*10; // Adjust the multiplier as needed

        daysLabel.setStyle("-fx-font-size: 50px;-fx-text-fill: black;");
        hoursLabel.setStyle("-fx-font-size: 50px;-fx-text-fill: black;");
        minutesLabel.setStyle("-fx-font-size: 50px;-fx-text-fill: black;");
        secondsLabel.setStyle("-fx-font-size: 50px;-fx-text-fill: black;");


        timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), event -> {
                    secondsElapsed+=3600;
                    timerLabel.setText(formatTime(secondsElapsed));
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);

        Button addMinutesButton = new Button("Add Minutes");
        addMinutesButton.setOnAction(event -> addTime(60));

        Button addSecondsButton = new Button("Add Seconds");
        addSecondsButton.setOnAction(event -> addTime(1));

        Button addHoursButton = new Button("Add Hours");
        addHoursButton.setOnAction(event -> addTime(3600));

        HBox buttonsBox = new HBox(10, addMinutesButton, addSecondsButton, addHoursButton);
        buttonsBox.setAlignment(Pos.CENTER);


        HBox root_labels = new HBox(90, daysLabel , hoursLabel , minutesLabel , secondsLabel);
        root_labels.setAlignment(Pos.CENTER);

        VBox root = new VBox(30,explain1,explain2, root_labels,timerLabel);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1500, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stopwatch App");
        primaryStage.show();

        timeline.play();
    }

    private String formatTime(int seconds) {
        int days = seconds / 86400;
        int hours = (seconds % 86400) / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d:%02d:%02d", days, hours, minutes, remainingSeconds);
    }


    private void addTime(int secondsToAdd) {
        secondsElapsed += secondsToAdd;
    }

    public static void main(String[] args) {
        launch(args);
    }
}