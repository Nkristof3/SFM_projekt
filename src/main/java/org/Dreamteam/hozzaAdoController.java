package org.Dreamteam;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import org.Dreamteam.SecondaryController.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class hozzaAdoController extends DaoImp implements Initializable{

    String tipus = "Film";
    @FXML
    Label evadLabel;
    @FXML
    Label reszLabel;
    @FXML
    ComboBox<String> comboBox = new ComboBox<>();
    @FXML
    TextField titleField;
    @FXML
    TextField seasonNumber;
    @FXML
    TextField episodeNumber;
    @FXML
    CheckBox mgnCheck;
    @FXML
    CheckBox kedvBox;
    @FXML
    Button hAd;

    String mgn = "-";
    String kedv = "-";
    @FXML
    private void checked(){
        if (mgnCheck.isSelected()) {
            mgn = "+";
        }
    }

    @FXML
    private void checked2(){
        if (kedvBox.isSelected()) {
            kedv = "+";
        }
    }
    @FXML
    private void hozzaAd() throws SQLException {
        if(!titleField.getText().trim().equals("")) {
            if(tipus.equals("Sorozat")) {
                hozzaadas(tipus, titleField.getText(), Integer.parseInt(seasonNumber.getText()), Integer.parseInt(episodeNumber.getText()), kedv, mgn);
                Stage stage = (Stage) hAd.getScene().getWindow();
                stage.close();
            }
            else if(tipus.equals("Film")){
                hozzaadas(tipus, titleField.getText(), 0, 1, kedv, mgn);
                Stage stage = (Stage) hAd.getScene().getWindow();
                stage.close();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Figyelem!");
            alert.setHeaderText(null);
            alert.setContentText("Cím megadása kötelező!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Film", "Sorozat");
        comboBox.setPromptText("Válasszon a listából...");
    }

    public void valaszt(ActionEvent actionEvent) {
        tipus = comboBox.getValue();
        if(tipus == "Film"){
            seasonNumber.setVisible(false);
            episodeNumber.setVisible(false);
            evadLabel.setVisible(false);
            reszLabel.setVisible(false);
        }
        else{
            seasonNumber.setVisible(true);
            episodeNumber.setVisible(true);
            evadLabel.setVisible(true);
            reszLabel.setVisible(true);
        }
    }
}
