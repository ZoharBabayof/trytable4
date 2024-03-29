
package com.example.trytable2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.util.Duration;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class View extends Application {

    // global objects
    static HBox row = new HBox(10);
    static HBox row2 = new HBox(10);
    static HBox row3 = new HBox(10);
    static HBox row4 = new HBox(10);

    static HBox surgeries_row = new HBox(10);

    Stage stage2 = new Stage(); // it's the only stage
    static TabPane tabPane = new TabPane();

    static AnchorPane pane = new AnchorPane();

    static AnchorPane surgery_pane = new AnchorPane();


    static TableView<Surgery> surg_table = new TableView<Surgery>();

    static final ObservableList<Surgery> surgeries_data = FXCollections.observableArrayList(

    );
    static ArrayList<Surgery> surgeries = new ArrayList<>();

    // patients speciality
    static TableView<Patient> table = new TableView<Patient>();

    static final ObservableList<Patient> data = FXCollections.observableArrayList(

    );


    static AnchorPane pane2 = new AnchorPane();
    static TableView<Patient> table2 = new TableView<Patient>();
    static final ObservableList<Patient> data2 = FXCollections.observableArrayList(

    );

    static AnchorPane pane3 = new AnchorPane();
    static TableView<Patient> table3 = new TableView<Patient>();
    static final ObservableList<Patient> data3 = FXCollections.observableArrayList(

    );
    static AnchorPane pane4 = new AnchorPane();
    static TableView<Patient> table4 = new TableView<Patient>();
    static final ObservableList<Patient> data4 = FXCollections.observableArrayList(

    );

    // doctors speciality
    static TableView<Doctor> table5 = new TableView<Doctor>();
    static final ObservableList<Doctor> data5 = FXCollections.observableArrayList(

    );


    static TableView<Doctor> table6 = new TableView<Doctor>();
    static final ObservableList<Doctor> data6 = FXCollections.observableArrayList(

    );
    static TableView<Doctor> table7 = new TableView<Doctor>();
    static final ObservableList<Doctor> data7 = FXCollections.observableArrayList(

    );
    static TableView<Doctor> table8 = new TableView<Doctor>();
    static final ObservableList<Doctor> data8 = FXCollections.observableArrayList(

    );
    static Tab tab = new Tab("Vascular_surgery");
    static Tab tab2 = new Tab("Neurosurgery");

    static Tab tab3 = new Tab("Pediatric_surgery");
    static Tab tab4 = new Tab("Card_surgery");

    static Tab tab5 = new Tab("Time");// beacuse I want the tab of clock to be the event room
    static Tab surg_tab = new Tab("Surgeries");


    // Create a Stopwatch
    static StopWatch stopWatch = new StopWatch();
    static long startTime = System.currentTimeMillis();


    static Specialization n = new Specialization("Neurosurgery");
    static Specialization p = new Specialization("Pediatric_surgery");
    static Specialization c = new Specialization("Card_surgery");
    static Specialization v = new Specialization("Vascular_surgery");



    static ArrayList<Surgery> all_the_surgeries;


    /**
     * constructor
     */
    public View()// consturctor
    {
    }

    /**
     * not relevant. ignore.
     */

    public static void opRoomsInformation(Stage primaryStage, ArrayList<Specialization> specs) {

    }


    /**
     * refresh all the data variables information(refresh their collection) by clear all and fill them again
     */
    public void refresh(ArrayList<Surgery> retSurges)// parameter not relevant
    {
        surgeries_data.clear();
        Iterator<Surgery> surg_iterator = surgeries.iterator();
        // add all objects of surgery to the data
        while (surg_iterator.hasNext()) {
            Surgery s = surg_iterator.next();
            surgeries_data.add(s);

        }

        data.clear();
        Iterator<Patient> iterator = v.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator.hasNext()) {
            Patient q = iterator.next();
            data.add(q);

        }

        data2.clear();
        Iterator<Patient> iterator2 = n.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator2.hasNext()) {
            Patient k = iterator2.next();

            data2.add(k);
        }
        data3.clear();

        Iterator<Patient> iterator3 = p.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator3.hasNext()) {
            Patient z = iterator3.next();
            data3.add(z);

        }
        data4.clear();

        Iterator<Patient> iterator4 = c.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator4.hasNext()) {
            Patient q = iterator4.next();
            data4.add(q);

        }


        data5.clear();
        Iterator<Doctor> iterator5 = v.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator5.hasNext()) {
            Doctor q = iterator5.next();
            data5.add(q);

        }


        data6.clear();
        Iterator<Doctor> iterator6 = n.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator6.hasNext()) {
            Doctor q = iterator6.next();
            data6.add(q);

        }

        data7.clear();
        Iterator<Doctor> iterator7 = p.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator7.hasNext()) {
            Doctor q = iterator7.next();
            data7.add(q);

        }

        data8.clear();

        Iterator<Doctor> iterator8 = c.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator8.hasNext()) {
            Doctor q = iterator8.next();
            data8.add(q);
        }


    }

    /**
     * we call this function in the beginning. it creates all tables and put in them the information from collections
     * in them.
     */
    public static void SpecsInformation(Stage stage, ArrayList<Specialization> specs) {
        // get all the specilizations objects
        System.out.println(specs.get(0).toString());
        n = specs.get(0);

        p = specs.get(1);
        c = specs.get(2);
        v = specs.get(3);


        // doctors table creations


        //Creating columns


        TableColumn NameCol5 = new TableColumn("Name");
        NameCol5.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol5 = new TableColumn("id");
        IDCol5.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol5 = new TableColumn("is_available");
        waitCol5.setCellValueFactory(new PropertyValueFactory("is_available"));
        TableColumn sevCol5 = new TableColumn("current_room_id");
        sevCol5.setCellValueFactory(new PropertyValueFactory("current_room_id"));
        sevCol5.setPrefWidth(150);

        NameCol5.setPrefWidth(150);
        IDCol5.setPrefWidth(150);
        waitCol5.setPrefWidth(150);


        //
        Iterator<Doctor> iterator5 = v.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator5.hasNext()) {
            Doctor q = iterator5.next();
            data5.add(q);

        }
        table5.setItems(data5);

        table5.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table5.getColumns().addAll(NameCol5, IDCol5, waitCol5, sevCol5);
        //Setting the size of the table
        table5.setMaxSize(1500, 1000);


        // add doctors of neuro surgery
        TableColumn NameCol6 = new TableColumn("Name");
        NameCol6.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol6 = new TableColumn("id");
        IDCol6.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol6 = new TableColumn("is_available");
        waitCol6.setCellValueFactory(new PropertyValueFactory("is_available"));
        TableColumn sevCol6 = new TableColumn("current_room_id");
        sevCol6.setCellValueFactory(new PropertyValueFactory("current_room_id"));
        sevCol6.setPrefWidth(150);

        //
        Iterator<Doctor> iterator6 = n.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator6.hasNext()) {
            Doctor q = iterator6.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data6.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }

        table6.setItems(data6);

        table6.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table6.getColumns().addAll(NameCol6, IDCol6, waitCol6, sevCol6);
        //Setting the size of the table
        //table6.setMaxSize(500, 400);

        // add doctors of neuro surgery
        TableColumn NameCol7 = new TableColumn("Name");
        NameCol7.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol7 = new TableColumn("id");
        IDCol7.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol7 = new TableColumn("is_available");
        waitCol7.setCellValueFactory(new PropertyValueFactory("is_available"));
        TableColumn sevCol7 = new TableColumn("current_room_id");
        sevCol7.setCellValueFactory(new PropertyValueFactory("current_room_id"));
        sevCol7.setPrefWidth(150);

        //
        Iterator<Doctor> iterator7 = p.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator7.hasNext()) {
            Doctor q = iterator7.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data7.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }

        table7.setItems(data7);

        table7.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table7.getColumns().addAll(NameCol7, IDCol7, waitCol7, sevCol7);
        //Setting the size of the table
        //table7.setMaxSize(500, 400);
        // add doctors of neuro surgery
        TableColumn NameCol8 = new TableColumn("Name");
        NameCol8.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn IDCol8 = new TableColumn("id");
        IDCol8.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn waitCol8 = new TableColumn("is_available");
        waitCol8.setCellValueFactory(new PropertyValueFactory("is_available"));
        TableColumn sevCol8 = new TableColumn("current_room_id");
        sevCol8.setCellValueFactory(new PropertyValueFactory("current_room_id"));
        sevCol8.setPrefWidth(150);

        //
        Iterator<Doctor> iterator8 = c.getDoctors_with_spec().iterator();
        //add all objects of doctor in the spec to the data
        while (iterator8.hasNext()) {
            Doctor q = iterator8.next();
            //FileData g = new FileData(q.getName(),q.getId(),q.getSpec_needed(),q.getSpec_needed());
            data8.add(q);
            //    FileData l =  new FileData(q.getName(), q.getId(), String.valueOf(q.getSeverity_before()), String.valueOf(q.getWaiting_time()),q.getSpec_needed());

        }
        table8.setItems(data8);

        table8.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table8.getColumns().addAll(NameCol8, IDCol8, waitCol8, sevCol8);
        //Setting the size of the table
        // table8.setMaxSize(500, 400);


        Label label = new Label("Vascular_surgery:");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);


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
        specCol.setPrefWidth(150);

        NameCol.setPrefWidth(150);
        IDCol.setPrefWidth(150);
        waitCol.setPrefWidth(150);
        sevCol.setPrefWidth(150);


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
        specCol2.setPrefWidth(150);

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
        specCol3.setPrefWidth(150);

        Iterator<Patient> iterator = v.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator.hasNext()) {
            Patient q = iterator.next();
            data.add(q);

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
        specCol4.setPrefWidth(150
        );


        // for vascular surgery


        //Adding data to the table
        //       ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(NameCol, IDCol, waitCol, sevCol, specCol);


        //Setting the size of the tables
        table.setMaxSize(1500, 1000);
        table2.setMaxSize(1500, 1000);
        table3.setMaxSize(1500, 1000);
        table4.setMaxSize(1500, 1000);
        table6.setMaxSize(1500, 1000);
        table7.setMaxSize(1500, 1000);
        table8.setMaxSize(1500, 1000);


        Label Vascular_Doctors_label = new Label("Vascular Doctors");
        Font font_Vascular_Doctors = new Font("david", 24); // create a new Font object with size 100
        Vascular_Doctors_label.setFont(font_Vascular_Doctors); // set the font of zlabel to the new Font object
        VBox Vascular_Doctors_vbox = new VBox();
        Vascular_Doctors_vbox.getChildren().addAll(Vascular_Doctors_label, table5);
        Vascular_Doctors_vbox.setAlignment(Pos.CENTER);

        Vascular_Doctors_label.setTextFill(Color.BLUE);


//        // vbox.
////        AnchorPane pane = new AnchorPane();
//        row.setAlignment(Pos.CENTER);
//        //row.setPadding(new Insets(10));
//        TableColumn<Patient, String> label2 = new TableColumn<>("Patients");

//        VBox vbox2 = new VBox();
//        vbox2.setAlignment(Pos.CENTER);
//        vbox2.getChildren().addAll(label2, table2);
//       // table5.setAlignment(Pos.CENTER);


        Label Vascular_Patients_label = new Label("Vascular Patients");
        Font font_Vascular_Patients = new Font("david", 24); // create a new Font object with size 100
        Vascular_Patients_label.setTextFill(Color.BLUE);

        Vascular_Patients_label.setFont(font_Vascular_Patients); // set the font of zlabel to the new Font object
        VBox Vascular_Patients_vbox = new VBox();
        Vascular_Patients_vbox.getChildren().addAll(Vascular_Patients_label, table);
        Vascular_Patients_vbox.setAlignment(Pos.CENTER);

        for (TableColumn column : table.getColumns()) {
            column.setStyle("-fx-font-size: 18px;");
        }


        for (TableColumn column : table5.getColumns()) {
            column.setStyle("-fx-font-size: 18px;");
        }


        row.getChildren().addAll(Vascular_Patients_vbox, Vascular_Doctors_vbox);
        row.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 1000.0);
        AnchorPane.setLeftAnchor(tabPane, 1000.0);
        pane.getChildren().addAll(tabPane, row);
        // add more child
        pane.setStyle("-fx-background-color: BEIGE");


        stage.setTitle("TabPane Demo");


// for vascular surgery
        //Label for education
        Label label2 = new Label("Neurosurgery:");
        Font font2 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label2.setFont(font2);
        //Creating a table view

//
//        TableView<Patient> table3 = new TableView<Patient>();
//        final ObservableList<Patient> data3 = FXCollections.observableArrayList(
//
//        );
//        TableView<Patient> table4 = new TableView<Patient>();
//        final ObservableList<Patient> data4 = FXCollections.observableArrayList(
//
//        );


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Iterator<Patient> iterator2 = n.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator2.hasNext()) {
            Patient k = iterator2.next();

            data2.add(k);

        }

        Iterator<Patient> iterator3 = p.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator3.hasNext()) {
            Patient z = iterator3.next();
            data3.add(z);

        }
        Iterator<Patient> iterator4 = c.getPatient_array_list().iterator();
        //add all objects of patient in the spec to the data
        while (iterator4.hasNext()) {
            Patient q = iterator4.next();
            data4.add(q);
        }
        //Adding data to the table
        // ObservableList<String> list2 = FXCollections.observableArrayList();
        table2.setItems(data2);

        table2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table2.getColumns().addAll(NameCol2, IDCol2, waitCol2, sevCol2, specCol2);
        //Setting the size of the table
        // table2.setMaxSize(400, 600);


        table3.setItems(data3);

        table3.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table3.getColumns().addAll(NameCol3, IDCol3, waitCol3, sevCol3, specCol3);
        //Setting the size of the table
        //table3.setMaxSize(500, 400);

        table4.setItems(data4);

        table4.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table4.getColumns().addAll(NameCol4, IDCol4, waitCol4, sevCol4, specCol4);
        //Setting the size of the table
        //table4.setMaxSize(700, 400);


        //vbox. // agebox
        //define age box


        for (TableColumn column : table2.getColumns()) {
            column.setStyle("-fx-font-size: 18px;");
        }

        for (TableColumn column : table6.getColumns()) {
            column.setStyle("-fx-font-size: 18px;");
        }

        Label Neuro_Doctors_label = new Label("Neurologists");
        Font font_Neuro_Doctors = new Font("david", 24); // create a new Font object with size 100
        Neuro_Doctors_label.setFont(font_Neuro_Doctors); // set the font of zlabel to the new Font object
        VBox Neuro_Doctors_vbox = new VBox();
        Neuro_Doctors_vbox.getChildren().addAll(Neuro_Doctors_label, table6);
        Neuro_Doctors_vbox.setAlignment(Pos.CENTER);

        Neuro_Doctors_label.setTextFill(Color.BLUE);

        Label Neuro_Patient_label = new Label("Neuro Patients");
        Font font_Neuro_Patients = new Font("david", 24); // create a new Font object with size 100
        Neuro_Patient_label.setFont(font_Neuro_Patients); // set the font of zlabel to the new Font object
        VBox Neuro_Patients_vbox = new VBox();
        Neuro_Patients_vbox.getChildren().addAll(Neuro_Patient_label, table2);
        Neuro_Patients_vbox.setAlignment(Pos.CENTER);

        Neuro_Patient_label.setTextFill(Color.BLUE);

        // row2.getChildren().addAll(table2,table6);
        row2.getChildren().addAll(Neuro_Patients_vbox, Neuro_Doctors_vbox);
        row2.setAlignment(Pos.CENTER);


        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        // pane2.getChildren().addAll(tabPane,label,table2);
        pane2.getChildren().addAll(tabPane, row2);


        // pane2.getChildren().add(table);
        pane2.setStyle("-fx-background-color: BEIGE");


//--------------------------------------------------------------------------------------

        for (TableColumn column : table3.getColumns()) {
            column.setStyle("-fx-font-size: 18px;");
        }

        for (TableColumn column : table7.getColumns()) {
            column.setStyle("-fx-font-size: 18px;");
        }

        Label Pediatric_Doctors_label = new Label("pediatricians");
        Font font_ped_Doctors = new Font("david", 24); // create a new Font object with size 100
        Pediatric_Doctors_label.setFont(font_ped_Doctors); // set the font of zlabel to the new Font object
        VBox ped_Doctors_vbox = new VBox();
        ped_Doctors_vbox.getChildren().addAll(Pediatric_Doctors_label, table7);
        ped_Doctors_vbox.setAlignment(Pos.CENTER);

        Pediatric_Doctors_label.setTextFill(Color.BLUE);

        Label ped_Patient_label = new Label("Pediatric Patients");
        Font font_ped_Patients = new Font("david", 24); // create a new Font object with size 100
        ped_Patient_label.setFont(font_ped_Patients); // set the font of zlabel to the new Font object
        VBox ped_Patients_vbox = new VBox();
        ped_Patients_vbox.getChildren().addAll(ped_Patient_label, table3);
        ped_Patients_vbox.setAlignment(Pos.CENTER);

        ped_Patient_label.setTextFill(Color.BLUE);


//        AnchorPane pane3 = new AnchorPane();
        // row.getChildren().removeAll(table2,table5);////////////////////////////////////////////////////////////////////////////////////////////
        //  row3.getChildren().addAll(table3,table7);////////////////////////////////////////////////////////////////////////////////////////////

        row3.getChildren().addAll(ped_Patients_vbox, ped_Doctors_vbox);
        row3.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        pane3.getChildren().addAll(tabPane, row3);
        pane3.setStyle("-fx-background-color: BEIGE");

        row4.getChildren().addAll(table4, table8);
//        AnchorPane pane4 = new AnchorPane();
        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        pane4.getChildren().addAll(tabPane, row4);
        pane4.setStyle("-fx-background-color: BEIGE");
        //  stage.setTitle("TabPane Demo");
        //   BorderPane root2 = new BorderPane();

        // tabPane = new TabPane();
        //tabPane.setSide(Side.BOTTOM);


////////////////////////////////////////////////////////////////////////////////


        //  root.setCenter(tabPane2);


    }




        /**
         * to all the preparations a timer to the user in javafx.
         */


        public static void CreateTimer(Stage primaryStage) {


//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    convertTime();
//
//                }
//            };
//            Timer timer = new Timer();
//            timer.schedule(timerTask,0,1000);

// Your existing code
            tabPane = new TabPane();
            tabPane.setSide(Side.BOTTOM);

// Create a border pane
            BorderPane pane = new BorderPane();
            pane.setCenter(stopWatch);
            stopWatch.start();

// Create a scene and place it in the stage
            StopwatchApp stopwatchApp = new StopwatchApp();
            stopwatchApp.start(primaryStage);
            BorderPane pane_clock = stopwatchApp.getScene();
            pane.setCenter(pane_clock);

            Tab tab5 = new Tab("CLOCK");
            tab5.setContent(pane);
            tabPane.getTabs().add(tab5);

            primaryStage.setTitle("Clock");
            Scene scene = new Scene(tabPane);
            primaryStage.setScene(scene);
            }








        /**
         * show add the surgeries to the surgeries collection to show to user in the future.
         * gets doctor, patient, operating room to connect in a one new surgery.
         **/
        public void showSurgery(Doctor d, Patient pat, OperatingRoom op, ArrayList<Surgery> allsurgeries) {
            double time = pat.getEstimated_surgery_time();

            Surgery surg = new Surgery(pat.getSpec_needed(), d, pat, op,time);
            surgeries.add(surg);
            allsurgeries.add(surg);
            all_the_surgeries = allsurgeries;

        }


        /**
         * @param retSurges - arraylist, collection of surgeries.
         *                  this function create the surgeries table to user in javafx.
         */
        public void showSurgerytable(ArrayList<Surgery> retSurges) {


            TableColumn<Surgery, String> surg_ID = new TableColumn<>("surgID");
            surg_ID.setCellValueFactory(new PropertyValueFactory<>("surgID"));

            TableColumn<Surgery, String> surg_spec = new TableColumn<>("spec");
            surg_spec.setCellValueFactory(new PropertyValueFactory<>("spec"));

            TableColumn<Surgery, Doctor> surg_doc = new TableColumn<>("surg_doc");
            surg_doc.setCellValueFactory(new PropertyValueFactory<>("doctor"));

            TableColumn<Surgery, Patient> surg_pat = new TableColumn<>("patient");
            surg_pat.setCellValueFactory(new PropertyValueFactory<>("patient"));

            TableColumn<Surgery, OperatingRoom> surg_room = new TableColumn<>("room");
            surg_room.setCellValueFactory(new PropertyValueFactory<>("room"));

            TableColumn<Surgery, String> time_left = new TableColumn<>("time_left");
            time_left.setCellValueFactory(new PropertyValueFactory<>("time_left"));

            time_left.setPrefWidth(150);
            surg_ID.setPrefWidth(150);
            surg_spec.setPrefWidth(150);
            surg_doc.setPrefWidth(150);
            surg_pat.setPrefWidth(150);
            surg_room.setPrefWidth(150);

            Iterator<Surgery> surg_iterator = retSurges.iterator();
            while (surg_iterator.hasNext()) {
                Surgery s = surg_iterator.next();
                surgeries_data.add(s);
            }
            surg_table.setItems(surgeries_data);

            surg_table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            surg_table.getColumns().addAll(surg_ID, surg_spec, surg_doc, surg_pat, surg_room, time_left);
            surg_table.setMaxSize(1500, 1000);

            Label surg_label = new Label("Surgeries");
            Font font_surgeries = new Font("david", 24);
            surg_label.setFont(font_surgeries);
            surg_label.setTextFill(Color.BLUE);

            for (TableColumn<Surgery, ?> column : surg_table.getColumns()) {
                column.setStyle("-fx-font-size: 18px;");
            }


            surgeries_row.getChildren().clear();
            surgeries_row.getChildren().add(surg_table);

            surgery_pane.getChildren().clear();
            AnchorPane.setTopAnchor(tabPane, 15.0);
            AnchorPane.setRightAnchor(tabPane, 15.0);
            AnchorPane.setBottomAnchor(tabPane, 1000.0);
            AnchorPane.setLeftAnchor(tabPane, 1000.0);

            surgery_pane.getChildren().addAll(surg_label, surgeries_row);
            surgery_pane.setStyle("-fx-background-color: BEIGE");
        }


        // }


        /**
         * Stage stage
         **/
        @Override

        public void start(Stage stage) throws IOException, InterruptedException {
            Presenter presenter = new Presenter();

            presenter.startHospital();
            ArrayList<Specialization> specs = presenter.giveSpec();
            ArrayList<OperatingRoom> oprooms = presenter.retOprooms();
            RecoveryRoom recoveryRoom = presenter.retRecoveryRoom();
            ArrayList<Doctor> doctors = presenter.retDoctors();


            BorderPane root = new BorderPane();


            CreateTimer(stage);
            SpecsInformation(stage, specs); // in the future I'll give the function +4 specializations from model
            opRoomsInformation(stage, specs); // not finished
            // DoctorsInformation(stage,doctors);// not finished
            // not finished


//        presenter.Algorithem();

            // Button button = new Button("Button" + Integer.toString(i));
            showSurgerytable(presenter.retSurges());
            surg_tab.setContent(surgery_pane);
            tabPane.getTabs().add(surg_tab);

            tab.setContent(pane);
            tabPane.getTabs().add(tab);


            tab2.setContent(pane2);
            tabPane.getTabs().add(tab2);

            tab3.setContent(pane3);
            tabPane.getTabs().add(tab3);

            tab4.setContent(pane4);
            tabPane.getTabs().add(tab4);
            root.setCenter(tabPane);
            Scene scene = new Scene(root, 800, 500);
            stage2.setScene(scene);
            Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
            stage2.setX(visualBounds.getMinX());
            stage2.setY(visualBounds.getMinY());
            stage2.setWidth(visualBounds.getWidth());
            stage2.setHeight(visualBounds.getHeight());
            stage2.setTitle("THE EFFICIENT HOSPITAL - ZOHAR BABAYOF");
            stage2.show();



            Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(5), event2 -> {
                try {
                    System.out.println("made it!!!!!!!!!!");
                    presenter.Algorithem();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
            timeline2.setCycleCount(Animation.INDEFINITE);
            timeline2.play();



            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.02), event -> {

                surgeries = presenter.retSurges();
                refresh(surgeries);

            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();



            // Schedule a task to increment stopwatch time every 5 seconds

            // Schedule a task to add 1 minute to the stopwatch every 5 seconds

        }



        // Create a Timeline to increment the time every 5 seconds


        /**
         * @param - String[] args
         * @throws IOException launch the View.
         */
        public static void main(String[] args) throws IOException {
            launch();

        }
    }
