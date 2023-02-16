package com.example.trytable2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        Label label = new Label("File data:");
//        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
//        label.setFont(font);
//        //Creating a table view
//        TableView<String> table = new TableView<String>();
////Creating columns
//        TableColumn fileNameCol = new TableColumn("Name");
//        TableColumn pathCol = new TableColumn("urgency level");
//        TableColumn imageSizeCol = new TableColumn("Size");
//        TableColumn dateCol = new TableColumn("Date Modified");
//        dateCol.setPrefWidth(100);
//        //Adding data to the table
//        ObservableList<String> list = FXCollections.observableArrayList();
//        table.setItems(list);
//        table.getColumns().addAll(fileNameCol, pathCol, imageSizeCol, dateCol);
//        //Setting the size of the table
//        table.setMaxSize(350, 400);
//        VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 50, 50, 60));
//        vbox.getChildren().addAll(label, table);
//        //Setting the scene
//        Scene scene1 = new Scene(vbox, 595, 230);
//        stage.setTitle("Table View Exmple");
//        stage.setScene(scene1);
//        stage.show();
        //Label for education

        Label label = new Label("Neurosurgery:");// coteret
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);// font
        label.setFont(font);// set the font on coteret
        //Creating a table view
        TableView<FileData> table = new TableView<FileData>();// create new table
        String patient = "george";
        int urg = 2;
        final ObservableList<FileData> data = FXCollections.observableArrayList(

                new FileData(patient, String.valueOf(urg), "25 MB", "12/01/2017"),
                new FileData("file2", "D:zmyFiles\file2.txt", "30 MB", "01/11/2019"),
                new FileData("file3", "D:zmyFiles\file3.txt", "50 MB", "12/04/2017"),
                new FileData("file4", "D:zyFiles\file4.txt", "75 MB", "25/09/2018"),
                new FileData("file4", "D:zyFiles\file4.txt", "76 MB", "25/09/2018")
        );
        //Creating columns
        TableColumn fileNameCol = new TableColumn("File Name");
        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));

        TableColumn pathCol = new TableColumn("Path");
        pathCol.setCellValueFactory(new PropertyValueFactory("path"));

        TableColumn sizeCol = new TableColumn("Size");
        sizeCol.setCellValueFactory(new PropertyValueFactory("size"));

        TableColumn dateCol = new TableColumn("Date Modified");
        dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));


        dateCol.setPrefWidth(100);
        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(fileNameCol, pathCol, sizeCol, dateCol);
        //Setting the size of the table
        table.setMaxSize(350, 200);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 50, 50, 60));
        vbox.getChildren().addAll(label, table);
        //Setting the scene
        Scene scene = new Scene(vbox, 595, 230);
        stage.setTitle("Table View Exmple");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}