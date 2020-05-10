package org.Dreamteam;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        if(!(cimmezo.getText().equals("") || cBox.getValue() == null || megjegyzesek.getText().equals("")))
        {
            kedvenchezAd(cimmezo.getText(), cBox.getValue(), megjegyzesek.getText());
            Stage stage;
            stage = (Stage) cimmezo.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba!");
            alert.setHeaderText(null);
            alert.setContentText("Minden mezőt ki kell tölteni!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cBox.getItems().addAll(1,2,3,4,5);
        cBox.setPromptText("Értékelés...");
        utmutato.setText(s);
    }
}
