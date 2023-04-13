module com.example.eventdriven {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eventdriven to javafx.fxml;
    exports com.example.eventdriven;
}