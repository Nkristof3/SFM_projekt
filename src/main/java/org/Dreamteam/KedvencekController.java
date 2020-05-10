package org.Dreamteam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class KedvencekController extends DaoImp implements Initializable {

    Scene scene;
    @FXML
    Button kezdo;
    @FXML
    TableView<Kedvenc> kedvencTable;
    @FXML
    TableColumn<Kedvenc, String> cimOszlopK;
    @FXML
    TableColumn<Kedvenc, Integer> ertekelesOszlop;
    @FXML
    TableColumn<Kedvenc,String> megjOszlop;


    public void megnyit(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Megjegyzések");
        alert.setHeaderText(null);
        alert.setContentText(kedvencTable.getSelectionModel().getSelectedItem().getMegjegyzes());
        alert.show();
    }

    private ObservableList<Kedvenc> li;
    public void kedvTable(String sql)
    {
        li = tableK(sql);
        cimOszlopK.setCellValueFactory(new PropertyValueFactory<>("cim"));
        ertekelesOszlop.setCellValueFactory(new PropertyValueFactory<>("rating"));
        megjOszlop.setCellValueFactory(new PropertyValueFactory<>("megjegyzes"));
        kedvencTable.setItems(li);
    }


    @FXML
    private void switchToPrimary() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("primary"));
        MediaView videoablak = (MediaView)scene.lookup("#videoablak");
        MediaPlayer player = new MediaPlayer(new Media(getClass().getResource("video.mp4").toExternalForm()));
        player.setAutoPlay(true);
        videoablak.setMediaPlayer(player);
        stage.setScene(scene);
        stage.setTitle("Kezdőlap");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
        stage.show();
        kezdo.getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kedvTable("select * from kedvenc where cim in (select cim from film where kedvenc = '+')");
    }
}
