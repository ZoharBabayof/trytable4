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
import java.util.Iterator;

public class HelloApplication extends Application {


    public static void idan(Stage stage, String id) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void start(Stage stage) throws IOException {
        //idan(stage);
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

//        Label label = new Label("Neurosurgery:");// coteret
//        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);// font
//        label.setFont(font);// set the font on coteret
//        //Creating a table view
//        TableView<FileData> table = new TableView<FileData>();// create new table
//        String patient = "george";
//        int urg = 2;
//        final ObservableList<Patient> data = FXCollections.observableArrayList(
//
//                new Patient("a","1",0,1,"Neurosurgery")
////                new FileData(patient, String.valueOf(urg), "25 MB", "12/01/2017"),
////                new FileData("file2", "D:zmyFiles\file2.txt", "30 MB", "01/11/2019"),
////                new FileData("file3", "D:zmyFiles\file3.txt", "50 MB", "12/04/2017"),
////                new FileData("file4", "D:zyFiles\file4.txt", "75 MB", "25/09/2018"),
////                new FileData("file4", "D:zyFiles\file4.txt", "76 MB", "25/09/2018")
//        );
//
//
//
//        // defenitions:
//        //create object for every kind of specilization:
//        Specialization n = new Specialization("Neurosurgery");
//        Specialization p = new Specialization("Pediatric_surgery");
//        Specialization c = new Specialization("Cardiothoracic_surgery");
//        Specialization v = new Specialization("Vascular_surgery");
//
//        // patients:
//
//        //Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {
//        Patient a = new Patient("a","1",0,1,"Neurosurgery");
//        Patient b = new Patient("b","2",1,2,"Pediatric_surgery");
//        Patient f = new Patient("c","3",2,3,"Cardiothoracic_surgery");
//        Patient d = new Patient("d","4",3,4,"Vascular_surgery");
//        Patient e = new Patient("e","5",4,5,"Vascular_surgery");
//        n.getPatient_queue().add(a);
//        p.getPatient_queue().add(b);
//        c.getPatient_queue().add(f);
//        v.getPatient_queue().add(d);
//        v.getPatient_queue().add(e);
//        Iterator<Patient> iterator = v.getPatient_queue().iterator();
//        while(iterator.hasNext()){
//            Patient q = iterator.next();
//        //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());
//
//        }
//
//
//
//        //Creating columns
//        TableColumn fileNameCol = new TableColumn("Name");
//        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
//
//        TableColumn fileNameCol2 = new TableColumn("id");
//        fileNameCol2.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn pathCol = new TableColumn("waiting_time");
//        pathCol.setCellValueFactory(new PropertyValueFactory("waiting_time"));
//
//        TableColumn sizeCol = new TableColumn("severity");
//        sizeCol.setCellValueFactory(new PropertyValueFactory("severity"));
//
//        TableColumn dateCol = new TableColumn("spec needed");
//        dateCol.setCellValueFactory(new PropertyValueFactory("spec needed"));
//
//
//        dateCol.setPrefWidth(100);
//        //Adding data to the table
//        ObservableList<String> list = FXCollections.observableArrayList();
//        table.setItems(data);
//        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        table.getColumns().addAll(fileNameCol,fileNameCol2, pathCol, sizeCol, dateCol);
//        //Setting the size of the table
//        table.setMaxSize(350, 200);
//        VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 50, 50, 60));
//        vbox.getChildren().addAll(label, table);
//        //Setting the scene
//        Scene scene = new Scene(vbox, 595, 230);
//        stage.setTitle("Table View Exmple");
//        stage.setScene(scene);
//        stage.show();

        //create object for every kind of specilization:
        Specialization n = new Specialization("Neurosurgery");
        Specialization p = new Specialization("Pediatric_surgery");
        Specialization c = new Specialization("Cardiothoracic_surgery");
        Specialization v = new Specialization("Vascular_surgery");
       // Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {
        Patient a = new Patient("a","1",0,1,"Neurosurgery");
        Patient b = new Patient("b","2",1,2,"Pediatric_surgery");
        Patient f = new Patient("c","3",2,3,"Cardiothoracic_surgery");
        Patient d = new Patient("d","4",3,4,"Vascular_surgery");
        Patient e = new Patient("e","5",4,5,"Vascular_surgery");
        n.getPatient_queue().add(a);
        p.getPatient_queue().add(b);
        c.getPatient_queue().add(f);
        v.getPatient_queue().add(d);
        v.getPatient_queue().add(e);

        //Label for education
        Label label = new Label("File Data:");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);
        //Creating a table view
        TableView<Patient> table = new TableView<Patient>();
        final ObservableList<Patient> data = FXCollections.observableArrayList(
//                new Patient(a.getName(), a.getName(), a.getName(), a.getName()),
//                new Patient("file2", "D:/myFiles\file2.txt", "30 MB", "01/11/2019"),
//                new FileData("file3", "D:/myFiles\file3.txt", "50 MB", "12/04/2017"),
//                new FileData("file4", "D:/myFiles\file4.txt", "75 MB", "25/09/2018")
        );

        //Creating columns
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol = new TableColumn("id");
        IDCol.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol = new TableColumn("waiting_time");
        waitCol.setCellValueFactory(new PropertyValueFactory("waiting_time"));
        TableColumn sevCol = new TableColumn("severity_before");
        sevCol.setCellValueFactory(new PropertyValueFactory("severity_before"));
        TableColumn specCol = new TableColumn("spec_needed");
        specCol.setCellValueFactory(new PropertyValueFactory("spec_needed"));
        specCol.setPrefWidth(100);
        Iterator<Patient> iterator = v.getPatient_queue().iterator();
        while(iterator.hasNext()){
            Patient q = iterator.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }
        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(NameCol, IDCol, waitCol, sevCol,specCol);
        //Setting the size of the table
        table.setMaxSize(500, 800);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 50, 50, 60));
        vbox.getChildren().addAll(label, table);
        //Setting the scene
        Scene scene = new Scene(vbox, 500, 800);
        stage.setTitle("Table View Exmple");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        //Stage newstage = new Stage();
        // idan(newstage,"z");
        //idan();
    }
}