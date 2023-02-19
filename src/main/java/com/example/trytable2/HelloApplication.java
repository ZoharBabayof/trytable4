package com.example.trytable2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
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

//defenitions
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

        Patient e = new Patient("e","0",4,5,"Vascular_surgery");
        Patient e1 = new Patient("e1","1",4,5,"Vascular_surgery");
        Patient e2 = new Patient("e2","2",1,5,"Vascular_surgery");
        Patient e3 = new Patient("e3","3",4,5,"Vascular_surgery");
        Patient e4 = new Patient("e4","1",4,5,"Vascular_surgery");
        Patient e5 = new Patient("e1","2",1,5,"Vascular_surgery");
        Patient e6 = new Patient("e2","19",4,5,"Vascular_surgery");
        Patient e7 = new Patient("e3","1",4,5,"Vascular_surgery");
        Patient e8 = new Patient("e4","2",4,5,"Vascular_surgery");
        n.getPatient_queue().add(a);
        p.getPatient_queue().add(b);
        c.getPatient_queue().add(f);
        v.getPatient_queue().add(d);
        v.getPatient_queue().add(e);
        v.getPatient_queue().add(e1);
        v.getPatient_queue().add(e2);
        v.getPatient_queue().add(e3);
        v.getPatient_queue().add(e4);

      //   v.getPatient_queue().stream().sorted();


// for vascular surgery
        //Label for education
        Label label = new Label("Vascular_surgery:");
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

        Label label2 = new Label("Vascular_surgery:");
        Font font2 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);
        //Creating a table view
        TableView<Patient> table2 = new TableView<Patient>();
//        final ObservableList<Patient> data2 = FXCollections.observableArrayList(
////                new Patient(a.getName(), a.getName(), a.getName(), a.getName()),
////                new Patient("file2", "D:/myFiles\file2.txt", "30 MB", "01/11/2019"),
////                new FileData("file3", "D:/myFiles\file3.txt", "50 MB", "12/04/2017"),
////                new FileData("file4", "D:/myFiles\file4.txt", "75 MB", "25/09/2018")
//        );

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

        // for vascular surgery

        Iterator<Patient> iterator = v.getPatient_queue().iterator();
        while(iterator.hasNext()){
            Patient q = iterator.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }
//         iterator = n.getPatient_queue().iterator();
//        while(iterator.hasNext()){
//            Patient q = iterator.next();
//            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
//            data2.add(q);
//            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());
//
//        }

        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(NameCol, IDCol, waitCol, sevCol,specCol);
        //Setting the size of the table
        table.setMaxSize(500, 400);
//        VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 50, 50, 60));
        TabPane tabPane = new TabPane();
       // vbox.
        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        pane.getChildren().addAll(tabPane,label,table);
        pane.setStyle("-fx-background-color: BEIGE");
            //    getChildren().addAll(label, table);

        //Adding data to the table
//        ObservableList<String> list2 = FXCollections.observableArrayList();
//        table.setItems(data2);
//        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        table.getColumns().addAll(NameCol, IDCol, waitCol, sevCol,specCol);
//        //Setting the size of the table
//        table.setMaxSize(500, 400);
////        VBox vbox = new VBox();
////        vbox.setSpacing(5);
////        vbox.setPadding(new Insets(10, 50, 50, 60));
//        TabPane tabPane2 = new TabPane();
//        // vbox.
//        AnchorPane pane2 = new AnchorPane();
//        AnchorPane.setTopAnchor(tabPane, 15.0);
//        AnchorPane.setRightAnchor(tabPane, 15.0);
//        AnchorPane.setBottomAnchor(tabPane, 15.0);
//        AnchorPane.setLeftAnchor(tabPane, 15.0);
//        pane.getChildren().addAll(tabPane,label,table);
//        pane.setStyle("-fx-background-color: BEIGE");
//        //    getChildren().addAll(label, table);







//
//        for (int i = 1; i<= 20; i++) {
//            Tab tab = new Tab("Tab" + Integer.toString(i));
//            Button button = new Button("Button" + Integer.toString(i));
//            tab.setContent(button);
//            tabPane.getTabs().add(tab);
//        }
//
//
//        root.setCenter(tabPane);
//
//        Scene scene = new Scene(root, 800, 500);
//        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }

        //Setting the scene







        /// zohar from here
//        Scene scene = new Scene(pane, 500, 400);
//        stage.setTitle("TableViews Of Patients");
////        stage.setScene(scene);
////        stage.show();
//
//
//
//       // stage.setTitle("TabPane Demo");
//        BorderPane root = new BorderPane();
//
//
//        tabPane.setSide(Side.BOTTOM);
//
//        Tab tab = new Tab("Tab");
//        Button button = new Button("Button");
//        tab.setContent(button);
//        tabPane.getTabs().add(tab);
//
//        for (int i = 1; i<= 20; i++) {
//            tab = new Tab("Tab" + Integer.toString(i));
//            button = new Button("Button" + Integer.toString(i));
//            tab.setContent(button);
//            tabPane.getTabs().add(tab);
//        }
//
//
//        root.setCenter(tabPane);
//
//        //Scene scene = new Scene(root, 800, 500);
//       // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//        stage.setScene(scene);
//        stage.show();

// til here i think



        stage.setTitle("TabPane Demo");
        BorderPane root = new BorderPane();

        tabPane = new TabPane();
        tabPane.setSide(Side.BOTTOM);

//			Tab tab1 = new Tab("Tab 1");
//			tab1.setClosable(false);
//			Button button1 = new Button("Button 1");
//			VBox vbox1 = new VBox(10);
//			vbox1.getChildren().addAll(button1);
//			tab1.setContent(vbox1);
//
//			tabPane.getTabs().add(tab1);
//
//			Tab tab2 = new Tab("Tab 2");
//			tab2.setClosable(false);
//			Button button2 = new Button("Button 2");
//			tab2.setContent(button2);
//
//			tabPane.getTabs().add(tab2);
//
//			tabPane.getSelectionModel().select(1);

        Tab tab = new Tab("Vascular_surgery");
           // Button button = new Button("Button" + Integer.toString(i));
            tab.setContent(pane);
            tabPane.getTabs().add(tab);
//        Tab tab1 = new Tab("1");
//        // Button button = new Button("Button" + Integer.toString(i));
//        tab1.setContent(pane2);
//        tabPane2.getTabs().add(tab1);



        root.setCenter(tabPane);

        Stage stage2 = new Stage();
        Scene scene = new Scene(root, 800, 500);
      //  scene.add;
        stage2.setScene(scene);
        stage2.show();



    }

    public static void main(String[] args) throws IOException {
        launch();
        //Stage newstage = new Stage();
        // idan(newstage,"z");
        //idan();
    }
}