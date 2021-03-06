package org.Dreamteam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.skin.SplitMenuButtonSkin;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class PrimaryController{

    @FXML
    Button kedvG;
    Scene scene;
    @FXML
     private void switchToSecondary() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("secondary"));
        stage.setScene(scene);
        stage.setTitle("Minden tartalom");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("pop.png")));
        stage.show();
        kedvG.getScene().getWindow().hide();
    }
    @FXML
    private void switchToKedvencek() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("Kedvencek"));
        stage.setScene(scene);
        stage.setTitle("Kedvencek");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("kedvencek.png")));
        stage.show();
        kedvG.getScene().getWindow().hide();
    }
    @FXML
    private void switchToMegnezendo() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("Megnezendo"));
        stage.setScene(scene);
        stage.setTitle("Megnézendő");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("wlater.png")));
        stage.show();
        kedvG.getScene().getWindow().hide();
    }

}
