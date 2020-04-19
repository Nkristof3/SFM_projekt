package org.Dreamteam;

import java.io.IOException;
import javafx.fxml.FXML;

public class MegnezendoController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
