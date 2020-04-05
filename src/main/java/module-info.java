module org.Dreamteam {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.Dreamteam to javafx.fxml;
    exports org.Dreamteam;
}