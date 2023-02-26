package com.example.trytable2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

class StopWatch extends BorderPane {
    private Text tTime;
    private Button btControl;
    private Button btClear;
    private int hours;
    private int minutes;
    private int seconds;
    private Timeline timeline;

    public StopWatch() {
        hours = 0;
        minutes = 0;
        seconds = 0;

        // set up the time display
        tTime = new Text();
        tTime.setFont(Font.font("SansSerif", 50));
        setTime();

        // set up the control buttons
        btControl = new Button("Start");
        btClear = new Button("Clear");

        btControl.setOnAction(e -> {
            String text = btControl.getText();
            if (text.equals("Start") || text.equals("Resume")) {
                btControl.setText("Pause");
                if (text.equals("Start")) {
                    start();
                } else {
                    resume();
                }
            } else {
                btControl.setText("Resume");
                pause();
            }
        });

        btClear.setOnAction(e -> {
            btControl.setText("Start");
            clear();
        });

        // lay out the UI
//        HBox buttonBox = new HBox(10);
//        buttonBox.getChildren().addAll(btControl, btClear);
//        buttonBox.setAlignment(Pos.CENTER);

        setCenter(tTime);
//        setBottom(buttonBox);
        setMargin(tTime, new Insets(20, 50, 20, 50));
    }

    public void start() {
        KeyFrame kf = new KeyFrame(Duration.millis(1000), e -> {
            seconds++;
            setTime();
        });

        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void pause() {
        timeline.pause();
    }

    public void resume() {
        timeline.play();
    }

    public void clear() {
        timeline.stop();
        hours = 0;
        minutes = 0;
        seconds = 0;
        setTime();
    }

    public void setTime() {
        // flip 60 seconds over to a minute
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        // flip 60 minutes over to an hour
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        // ensure that values < 10 are padded with a 0
        String h = hours >= 10 ? String.valueOf(hours) : "0" + String.valueOf(hours);
        String m = minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes);
        String s = seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds);

        tTime.setText(h + ":" + m + ":" + s);
    }
}