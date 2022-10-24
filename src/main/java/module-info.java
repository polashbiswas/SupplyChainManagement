module com.example.supplychainmanagementproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainmanagementproject to javafx.fxml;
    exports com.example.supplychainmanagementproject;
}