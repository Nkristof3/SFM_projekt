package org.Dreamteam;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;


public class SecondaryController extends DaoImp implements Initializable{


    public void tableSetup(String sql){
        lista = tableS(sql);
        tipusOszlop.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        cimOszlop.setCellValueFactory(new PropertyValueFactory<>("cim"));
        reszOszlop.setCellValueFactory(new PropertyValueFactory<>("reszek"));
        evadOszlop.setCellValueFactory(new PropertyValueFactory<>("evadok"));
        kedvencOszlop.setCellValueFactory(new PropertyValueFactory<>("kedvenc"));
        megnezendoOszlop.setCellValueFactory(new PropertyValueFactory<>("megnezendo"));
        filmTable.setItems(lista);
    }

    Scene scene;
    @FXML
    private void switchToPrimary() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("primary"));
        stage.setScene(scene);
        stage.setTitle("Kezdőlap");
        stage.show();
        filmTable.getScene().getWindow().hide();
    }

    public void hozzaAdAblak() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hozzaAdoAblak.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Hozzáadás");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("plus.png")));
        stage.getScene().getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.show();
    }

    public void torol(){
        if(filmTable.getSelectionModel().getSelectedItem() != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Törlés");
            alert.setHeaderText(null);
            alert.setContentText("Biztosan törli?");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                torles(filmTable.getSelectionModel().getSelectedItem().getCim());
                list.removeIf(film -> film.getCim().equals(filmTable.getSelectionModel().getSelectedItem().getCim()));
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Törlés");
            alert.setHeaderText(null);
            alert.setContentText("Nem jelölt ki semmit!");

            alert.show();
        }
    }
    @FXML
    public TableView<Film> filmTable;
    @FXML
    private TableColumn<Film, String> tipusOszlop;
    @FXML
    private TableColumn<Film, String> cimOszlop;
    @FXML
    private TableColumn<Film, Integer> reszOszlop;
    @FXML
    private TableColumn<Film, Integer> evadOszlop;
    @FXML
    private TableColumn<Film, String> kedvencOszlop;
    @FXML
    private TableColumn<Film, String> megnezendoOszlop;

    public ObservableList<Film> lista;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableSetup("select * from film where Tipus = 'Film'");
    }

    public void sorozat() {
        tableSetup("select * from film where Tipus = 'Sorozat'");
    }

    public void film() {
        tableSetup("select * from film where Tipus = 'Film'");
    }

    public void kedvencekhez() {
        if(filmTable.getSelectionModel().getSelectedItem() != null){
            ujKedvenc(filmTable.getSelectionModel().getSelectedItem().getCim());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kedvencekhez");
            alert.setHeaderText(null);
            alert.setContentText("Nem jelölt ki semmit!");

            alert.show();
        }
    }

    public void megneztem(ActionEvent actionEvent) {
        if(filmTable.getSelectionModel().getSelectedItem() != null){
            ujMegnezett(filmTable.getSelectionModel().getSelectedItem().getCim());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Megnéztem");
            alert.setHeaderText(null);
            alert.setContentText("Nem jelölt ki semmit!");

            alert.show();
        }
    }
}