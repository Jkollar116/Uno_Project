module com.mycompany.uno_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires transitive javafx.graphics;
    opens com.mycompany.uno_project to javafx.fxml;
    exports com.mycompany.uno_project;
}
