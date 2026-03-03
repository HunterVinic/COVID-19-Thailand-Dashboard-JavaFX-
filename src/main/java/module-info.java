module com.example.covid {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires json.simple;


    opens com.example.covid to javafx.fxml;
    exports com.example.covid;
}