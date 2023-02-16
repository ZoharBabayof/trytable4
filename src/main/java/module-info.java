module com.example.trytable2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trytable2 to javafx.fxml;
    exports com.example.trytable2;
}