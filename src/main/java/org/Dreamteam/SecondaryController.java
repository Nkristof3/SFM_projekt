package org.Dreamteam;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SecondaryController implements Initializable {


    public void tableSetup(String sql){
        ConnectDB connectionClass = new ConnectDB();
        Connection connection = connectionClass.getConnection();

        lista = FXCollections.observableArrayList();
        try {
            ResultSet vissza = connection.createStatement().executeQuery(sql);

            while(vissza.next()){
                Film film = new Film();
                film.setTipus(vissza.getString("tipus"));
                film.setCim(vissza.getString("cim"));
                film.setReszek(vissza.getInt("reszek"));
                film.setEvadok(vissza.getInt("evadok"));
                film.setKedvenc(vissza.getString("kedvenc"));
                film.setMegnezendo(vissza.getString("megnezendo"));
                lista.add(film);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        tipusOszlop.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        cimOszlop.setCellValueFactory(new PropertyValueFactory<>("cim"));
        reszOszlop.setCellValueFactory(new PropertyValueFactory<>("reszek"));
        evadOszlop.setCellValueFactory(new PropertyValueFactory<>("evadok"));
        kedvencOszlop.setCellValueFactory(new PropertyValueFactory<>("kedvenc"));
        megnezendoOszlop.setCellValueFactory(new PropertyValueFactory<>("megnezendo"));

        filmTable.setItems(lista);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
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
        stage.show();
    }

    @FXML
    private TableView<Film> filmTable;
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

    private ObservableList<Film> lista;

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
}