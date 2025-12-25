module com.example.albumimpressions {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.albumimpressions to javafx.fxml;
    exports com.example.albumimpressions;
}