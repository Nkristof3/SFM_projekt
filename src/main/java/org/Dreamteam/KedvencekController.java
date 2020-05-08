package org.Dreamteam;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class KedvencekController {

    Scene scene;
    @FXML
    Button kezdo;
    @FXML
    private void switchToPrimary() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("primary"));
        stage.setScene(scene);
        stage.setTitle("Kezdőlap");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
        stage.show();
        kezdo.getScene().getWindow().hide();
    }
}
