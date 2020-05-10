module org.Dreamteam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;

    opens org.Dreamteam to javafx.fxml;
    exports org.Dreamteam;
}