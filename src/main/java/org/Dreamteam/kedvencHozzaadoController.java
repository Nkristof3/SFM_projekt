package org.Dreamteam;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class kedvencHozzaadoController extends DaoImp implements Initializable {

    @FXML
    Label utmutato;
    @FXML
    Button kedvencHozzaad;
    @FXML
    TextField megjegyzesek;
    @FXML
    TextField cimmezo;
    @FXML
    ComboBox<Integer> cBox = new ComboBox<>();
    String s = "5 - Mindenkinek ajánlom\n"+"...\n"+"1 - Szórakoztató volt";

    public void kedvencAdatok() {
        kedvenchezAd(cimmezo.getText(), cBox.getValue(), megjegyzesek.getText());
        Stage stage;
        stage = (Stage) cimmezo.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cBox.getItems().addAll(1,2,3,4,5);
        cBox.setPromptText("Értékelés...");
        utmutato.setText(s);
    }
}
