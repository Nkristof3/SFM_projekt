package org.Dreamteam;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.Dreamteam.SecondaryController.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("kedvencHozzaado.fxml"));
            Stage stage = new Stage();
            try {
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.getIcons().add(new Image(getClass().getResourceAsStream("csillag.png")));
                stage.setTitle(titleField.getText());
                stage.getScene().getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    @FXML
    private void hozzaAd() throws SQLException {
        if(!titleField.getText().trim().equals("")) {
            if(tipus.equals("Sorozat")) {
                try
                {
                    hozzaadas(tipus, titleField.getText(), Integer.parseInt(seasonNumber.getText()), Integer.parseInt(episodeNumber.getText()), kedv, mgn);
                    Stage stage = (Stage) hAd.getScene().getWindow();
                    stage.close();
                }
                catch (NumberFormatException e){
                    Alert alert  = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hiba!");
                    alert.setHeaderText(null);
                    alert.setContentText("Nem számot adott meg évadok/részek számának!");
                    alert.show();
                }
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
            reszLabel.setVisible(true);
            episodeNumber.setVisible(true);
            seasonNumber.setVisible(false);
            evadLabel.setVisible(false);
        }
        else{
            seasonNumber.setVisible(true);
            episodeNumber.setVisible(true);
            evadLabel.setVisible(true);
            reszLabel.setVisible(true);
        }
    }
}
