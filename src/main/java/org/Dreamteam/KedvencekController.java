package org.Dreamteam;

import java.io.IOException;
import javafx.fxml.FXML;

public class KedvencekController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}