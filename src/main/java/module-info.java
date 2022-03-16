module com.project.lab06 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.lab06 to javafx.fxml;
    exports com.project.lab06;
}