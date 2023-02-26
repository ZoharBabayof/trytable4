
package com.example.trytable2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.print.PageLayout;
import javafx.print.PrinterJob;
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

    // global objects
    Stage stage2 = new Stage();
    static TabPane tabPane = new TabPane();

public static void CreateTables(Stage stage)
{

//defenitions for model
    //create object for every kind of specilization:
    Specialization n = new Specialization("Neurosurgery");
    Specialization p = new Specialization("Pediatric_surgery");
    Specialization c = new Specialization("Card_surgery");
    Specialization v = new Specialization("Vascular_surgery");
    // Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {
    Patient a = new Patient("a","1",0,1,"Neurosurgery");
    Patient b = new Patient("b","2",1,2,"Pediatric_surgery");
    Patient f = new Patient("c","3",2,3,"Card_surgery");
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
    table.setMaxSize(500, 400);


    // vbox.
    AnchorPane pane = new AnchorPane();
    AnchorPane.setTopAnchor(tabPane, 15.0);
    AnchorPane.setRightAnchor(tabPane, 15.0);
    AnchorPane.setBottomAnchor(tabPane, 15.0);
    AnchorPane.setLeftAnchor(tabPane, 15.0);
    pane.getChildren().addAll(tabPane,label,table);
    pane.setStyle("-fx-background-color: BEIGE");


    stage.setTitle("TabPane Demo");


    tabPane = new TabPane();
    tabPane.setSide(Side.BOTTOM);






    /////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////

// for vascular surgery
    //Label for education
    Label label2 = new Label("Neurosurgery:");
    Font font2 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
    label2.setFont(font2);
    //Creating a table view
    TableView<Patient> table2 = new TableView<Patient>();
    final ObservableList<Patient> data2 = FXCollections.observableArrayList(

    );

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
    table2.setMaxSize(500, 400);


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

    // vbox.
    AnchorPane pane2 = new AnchorPane();
    AnchorPane.setTopAnchor(tabPane, 15.0);
    AnchorPane.setRightAnchor(tabPane, 15.0);
    AnchorPane.setBottomAnchor(tabPane, 15.0);
    AnchorPane.setLeftAnchor(tabPane, 15.0);
    pane2.getChildren().addAll(tabPane,label,table2);
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
    Tab tab2 = new Tab("Neurosurgery");
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

    /**
     *
     * @param stage
     * @param tabPane
     * @param stage2
     */
    public static void CreateTimer(Stage stage,TabPane tabPane,Stage stage2 )
    {

    }


    @Override

    public void start(Stage stage) throws IOException
    {
        BorderPane root = new BorderPane();



        CreateTables( stage); // inthe fucutre i ll give the funtion +4 specializaions from model
        //CreateTimer( stage, tabPane,stage2 );

        root.setCenter(tabPane);
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