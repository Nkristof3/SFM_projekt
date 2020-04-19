package org.Dreamteam;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToKedvencek() throws IOException {
        App.setRoot("Kedvencek");
    }
    @FXML
    private void switchToMegnezendo() throws IOException {
        App.setRoot("Megnezendo");
    }

}
