module org.Dreamteam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.Dreamteam to javafx.fxml;
    exports org.Dreamteam;
}