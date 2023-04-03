module com.example.ramadangreetingcard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ramadangreetingcard to javafx.fxml;
    exports com.example.ramadangreetingcard;
}