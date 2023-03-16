
package com.example.trytable2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;

public class trygui extends Application {

    // global objects
    Stage stage2 = new Stage();
    static TabPane tabPane = new TabPane();
    static AnchorPane pane2 = new AnchorPane();

    static HBox row = new HBox();

    static TableView<Patient> table2 = new TableView<Patient>();
    static final ObservableList<Patient> data2 = FXCollections.observableArrayList(

    );

    static Tab tab2 = new Tab("Neurosurgery");
    static Specialization n ;
    static Specialization p ;
    static Specialization c;
    static Specialization v;

    public static void opRoomsInformation(Stage primaryStage,ArrayList<Specialization> specs)
    {

    }

//    public static void DoctorsInformation(Stage primaryStage,ArrayList<Doctor> specs)
//    {
//        // get objects
////        OperatingRoom a = oprooms.get(0);
////        OperatingRoom b = oprooms.get(1);
////        OperatingRoom c = oprooms.get(2);
////        OperatingRoom d = oprooms.get(3);
//        Doctor n = specs.get(0);
//
//
//        //create labels
//        Label label = new Label("Doctors:");
//        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
//        label.setFont(font);
//        //Creating a table view
//        TableView<Patient> table = new TableView<Patient>();
//        final ObservableList<Patient> data = FXCollections.observableArrayList(
//
//        );
//
//        //Creating columns
//        TableColumn NameCol = new TableColumn("Name");
//        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        TableColumn IDCol = new TableColumn("id");
//        IDCol.setCellValueFactory(new PropertyValueFactory("id"));
//        TableColumn waitCol = new TableColumn("waiting_time");
//        waitCol.setCellValueFactory(new PropertyValueFactory("waiting_time"));
//        TableColumn sevCol = new TableColumn("severity_before");
//        sevCol.setCellValueFactory(new PropertyValueFactory("severity_before"));
//        TableColumn specCol = new TableColumn("spec_needed");
//        specCol.setCellValueFactory(new PropertyValueFactory("spec_needed"));
//        specCol.setPrefWidth(100);
//        Iterator<Patient> iterator = n.getPatient_queue().iterator();
//        while(iterator.hasNext()){
//            Patient q = iterator.next();
//            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
//            data.add(q);
//            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());
//
//        }
//
//        //Adding data to the table
//        ObservableList<String> list = FXCollections.observableArrayList();
//        table.setItems(data);
//        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        table.getColumns().addAll(NameCol, IDCol, waitCol, sevCol,specCol);
//        //Setting the size of the table
//        table.setMaxSize(500, 400);
//
//
//        // vbox.
//        AnchorPane pane = new AnchorPane();
//        AnchorPane.setTopAnchor(tabPane, 15.0);
//        AnchorPane.setRightAnchor(tabPane, 15.0);
//        AnchorPane.setBottomAnchor(tabPane, 15.0);
//        AnchorPane.setLeftAnchor(tabPane, 15.0);
//        pane.getChildren().addAll(tabPane,label,table);
//        pane.setStyle("-fx-background-color: BEIGE");
//
//
//        primaryStage.setTitle("TabPane Demo");
//
//        Tab tab = new Tab("zohar2");
//        // Button button = new Button("Button" + Integer.toString(i));
//        tab.setContent(pane);
//        tabPane.getTabs().add(tab);
//
//
//    }








    public static void SpecsInformation(Stage stage, ArrayList<Specialization> specs)
    {


        //   v.getPatient_queue().stream().sorted();

        // get all the specilizations objects
         n = specs.get(0);
         p = specs.get(1);
         c = specs.get(2);
         v = specs.get(3);


        // doctors table creations

        TableView<Doctor> table5 = new TableView<Doctor>();
        final ObservableList<Doctor> data5 = FXCollections.observableArrayList(

        );

        //Creating columns
        //name id is_available current_room_id
        TableColumn NameCol5 = new TableColumn("Name");
        NameCol5.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol5 = new TableColumn("id");
        IDCol5.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol5 = new TableColumn("is_available");
        waitCol5.setCellValueFactory(new PropertyValueFactory("is_available"));
        TableColumn sevCol5 = new TableColumn("current_room_id");
        sevCol5.setCellValueFactory(new PropertyValueFactory("current_room_id"));
        sevCol5.setPrefWidth(100);

        //
        Iterator<Doctor> iterator5 = v.getDoctors_with_spec().iterator();
        while(iterator5.hasNext()){
            Doctor q = iterator5.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data5.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }
        table5.setItems(data5);

        table5.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table5.getColumns().addAll(NameCol5, IDCol5, waitCol5, sevCol5);
        //Setting the size of the table
        table5.setMaxSize(500, 400);




        // patients table creations
        // for view
// for vascular surgery
        //Label for education

        Label label = new Label("Vascular_surgery:");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);
        //Creating a table view
        TableView<Patient> table = new TableView<Patient>();
        final ObservableList<Patient> data = FXCollections.observableArrayList(

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



        //Creating columns
        TableColumn NameCol2 = new TableColumn("Name");
        NameCol2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol2 = new TableColumn("id");
        IDCol2.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol2 = new TableColumn("waiting_time");
        waitCol2.setCellValueFactory(new PropertyValueFactory("waiting_time"));
        TableColumn sevCol2 = new TableColumn("severity_before");
        sevCol2.setCellValueFactory(new PropertyValueFactory("severity_before"));
        TableColumn specCol2 = new TableColumn("spec_needed");
        specCol2.setCellValueFactory(new PropertyValueFactory("spec_needed"));
        specCol2.setPrefWidth(100);

        //Creating columns
        TableColumn NameCol3 = new TableColumn("Name");
        NameCol3.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol3 = new TableColumn("id");
        IDCol3.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol3 = new TableColumn("waiting_time");
        waitCol3.setCellValueFactory(new PropertyValueFactory("waiting_time"));
        TableColumn sevCol3 = new TableColumn("severity_before");
        sevCol3.setCellValueFactory(new PropertyValueFactory("severity_before"));
        TableColumn specCol3 = new TableColumn("spec_needed");
        specCol3.setCellValueFactory(new PropertyValueFactory("spec_needed"));
        specCol3.setPrefWidth(100);

        Iterator<Patient> iterator = v.getPatient_queue().iterator();
        while(iterator.hasNext()){
            Patient q = iterator.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }



        //Creating columns
        TableColumn NameCol4 = new TableColumn("Name");
        NameCol4.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol4 = new TableColumn("id");
        IDCol4.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol4 = new TableColumn("waiting_time");
        waitCol4.setCellValueFactory(new PropertyValueFactory("waiting_time"));
        TableColumn sevCol4 = new TableColumn("severity_before");
        sevCol4.setCellValueFactory(new PropertyValueFactory("severity_before"));
        TableColumn specCol4 = new TableColumn("spec_needed");
        specCol4.setCellValueFactory(new PropertyValueFactory("spec_needed"));
        specCol4.setPrefWidth(100);
















        // for vascular surgery



        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(NameCol, IDCol, waitCol, sevCol,specCol);
        //Setting the size of the table
        table.setMaxSize(500, 700);


        // vbox.
        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 1000.0);
        AnchorPane.setLeftAnchor(tabPane, 1000.0);
        pane.getChildren().addAll(tabPane,label,table);
        // add more child
        pane.setStyle("-fx-background-color: BEIGE");


        stage.setTitle("TabPane Demo");









        /////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////

// for vascular surgery
        //Label for education
        Label label2 = new Label("Neurosurgery:");
        Font font2 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label2.setFont(font2);
        //Creating a table view


        TableView<Patient> table3 = new TableView<Patient>();
        final ObservableList<Patient> data3 = FXCollections.observableArrayList(

        );
        TableView<Patient> table4 = new TableView<Patient>();
        final ObservableList<Patient> data4 = FXCollections.observableArrayList(

        );




        //Creating columns
//        TableColumn NameCol = new TableColumn("Name");
//        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        TableColumn IDCol = new TableColumn("id");
//        IDCol.setCellValueFactory(new PropertyValueFactory("id"));
//        TableColumn waitCol = new TableColumn("waiting_time");
//        waitCol.setCellValueFactory(new PropertyValueFactory("waiting_time"));
//        TableColumn sevCol = new TableColumn("severity_before");
//        sevCol.setCellValueFactory(new PropertyValueFactory("severity_before"));
//        TableColumn specCol = new TableColumn("spec_needed");
//        specCol.setCellValueFactory(new PropertyValueFactory("spec_needed"));
//        specCol.setPrefWidth(100);

        // for vascular surgery

        Iterator<Patient> iterator2 = n.getPatient_queue().iterator();
        while(iterator2.hasNext()){
            Patient k = iterator2.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());

            data2.add(k);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }

        Iterator<Patient> iterator3 = p.getPatient_queue().iterator();
        while(iterator3.hasNext()){
            Patient z = iterator3.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data3.add(z);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }
        Iterator<Patient> iterator4 = c.getPatient_queue().iterator();
        while(iterator4.hasNext()){
            Patient q = iterator4.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data4.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }
        //Adding data to the table
        ObservableList<String> list2 = FXCollections.observableArrayList();
        table2.setItems(data2);

        table2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table2.getColumns().addAll(NameCol2, IDCol2, waitCol2, sevCol2,specCol2);
        //Setting the size of the table
        table2.setMaxSize(400, 600);


        table3.setItems(data3);

        table3.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table3.getColumns().addAll(NameCol3, IDCol3, waitCol3, sevCol3,specCol3);
        //Setting the size of the table
        table3.setMaxSize(500, 400);

        table4.setItems(data4);

        table4.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table4.getColumns().addAll(NameCol4, IDCol4, waitCol4, sevCol4,specCol4);
        //Setting the size of the table
        table4.setMaxSize(500, 400);

        //vbox. // agebox
        //define age box


        row.getChildren().addAll(table2,table5);


        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        // pane2.getChildren().addAll(tabPane,label,table2);
        pane2.getChildren().addAll(tabPane,row);


        // pane2.getChildren().add(table);
        pane2.setStyle("-fx-background-color: BEIGE");

        AnchorPane pane3 = new AnchorPane();
        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        pane3.getChildren().addAll(tabPane,label,table3);
        pane3.setStyle("-fx-background-color: BEIGE");

        AnchorPane pane4 = new AnchorPane();
        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        pane4.getChildren().addAll(tabPane,label,table4);
        pane4.setStyle("-fx-background-color: BEIGE");
        //  stage.setTitle("TabPane Demo");
        //   BorderPane root2 = new BorderPane();

        // tabPane = new TabPane();
        //tabPane.setSide(Side.BOTTOM);


////////////////////////////////////////////////////////////////////////////////















        Tab tab = new Tab("Vascular_surgery");
        // Button button = new Button("Button" + Integer.toString(i));
        tab.setContent(pane);
        tabPane.getTabs().add(tab);

        // Button button = new Button("Button" + Integer.toString(i));
        tab2.setContent(pane2);
        tabPane.getTabs().add(tab2);
        Tab tab3 = new Tab("Pediatric_surgery");
        // Button button = new Button("Button" + Integer.toString(i));
        tab3.setContent(pane3);
        tabPane.getTabs().add(tab3);
        Tab tab4 = new Tab("Card_surgery");
        // Button button = new Button("Button" + Integer.toString(i));
        tab4.setContent(pane4);
        tabPane.getTabs().add(tab4);


        //  root.setCenter(tabPane2);






    }


    public static void CreateTimer(Stage primaryStage )
    {
        // Button btStart = new Button("Start");
        //  Button btClear = new Button("Clear");
        // Create a hbox for buttons
        //HBox paneForButtons = new HBox(5);
        // paneForButtons.setAlignment(Pos.CENTER);
        // paneForButtons.getChildren().addAll(btStart, btClear);
        tabPane = new TabPane();
        tabPane.setSide(Side.BOTTOM);
        // Create a Stopwatch
        StopWatch stopWatch = new StopWatch();

        // Create a border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(stopWatch);
        stopWatch.start();
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("CLOCK");
        primaryStage.setScene(scene);
        //  primaryStage.show();
        Tab tab5 = new Tab("Event_Room");// beacuse I want the tab of clock to be the event room
        // Button button = new Button("Button" + Integer.toString(i));
        tab5.setContent(pane);
        tabPane.getTabs().add(tab5);
    }

    // }


    public void changepane()
    {
        pane2.getChildren().remove(row);
    }

    @Override

    public void start(Stage stage) throws IOException, InterruptedException {
        Presenter p = new Presenter();
        ArrayList<Specialization> specs = p.giveSpec();
        ArrayList<OperatingRoom> oprooms = p.retOprooms();
        RecoveryRoom recoveryRoom = p.retRecoveryRoom();
        ArrayList<Doctor> doctors = p.retDoctors();

        BorderPane root = new BorderPane();


        CreateTimer(stage);
        SpecsInformation(stage, specs); // in the future I'll give the function +4 specializations from model
        opRoomsInformation(stage, specs); // not finished
        // DoctorsInformation(stage,doctors);// not finished
        // not finished

        root.setCenter(tabPane);
        Scene scene = new Scene(root, 800, 500);
        //  scene.add;
        stage2.setScene(scene);
        stage2.show();
//        LocalDateTime now = LocalDateTime.now();
//        int zohar = now.getMinute();
//        for (int i = 0; i < 10000; i++) {
//            if (i == 999)
//                changepane();
//        }
     Patient newPatient = new Patient("John", "123", 10, 5, "Neurosurgery");
//        new Thread(() -> {
//            try {
//                // Wait for 5 seconds
//                Thread.sleep(5000);
//
//                // Add a new patient to the data list
//
//                data2.add(newPatient);
//
//                // Update the table with the new data
//                Platform.runLater(() -> {
//                    table2.setItems(data2);
//
//                    // Select the new row in the table
//                    table2.getSelectionModel().select(newPatient);
//
//                    // Update the UI to show the new data in the tab
//                    tab2.setContent(pane2);
//                });
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();








        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            // add 3 new patients to the queue
            n.getPatient_queue().add(newPatient);
            n.getPatient_queue().add(newPatient);
            n.getPatient_queue().add(newPatient);

            // update the data with the new patients
            data2.clear();
            Timeline delay = new Timeline(new KeyFrame(Duration.seconds(5), event2 -> {
            Iterator<Patient> iterator2 = n.getPatient_queue().iterator();
            while (iterator2.hasNext()) {
                Patient k = iterator2.next();
                data2.add(k);
            }
            }));
            delay.play();
        }));

// start the timeline
        timeline.play();







//
//        new Thread(() -> {
//            try {
//        Thread.sleep(5000);
//
//        }
//
//        // Update the table with the new data
//        table2.setItems(data2);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

//        //Thread.sleep(5000L);
//        while (true) {
//            zohar = now.getSecond();
//            if (zohar == 59) {
//                pane2.getChildren().addAll(row);
//                break;
//            }
//
//            //
    //    }
    }







    public static void main(String[] args) throws IOException {
        launch();
        //Stage newstage = new Stage();
        // idan(newstage,"z");
        //idan();
    }
}