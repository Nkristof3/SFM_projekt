package org.Dreamteam;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MegnezendoController extends DaoImp implements Initializable {


    public void megnTable(String sql)
    {
        l = tableS(sql);
        tipusOszlop2.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        cimOszlop2.setCellValueFactory(new PropertyValueFactory<>("cim"));
        megnezendoTabla.setItems(l);
    }

    public void mozi(String sql)
    {
        l2 = tableM(sql);

        cimOszlop3.setCellValueFactory(new PropertyValueFactory<>("cim"));
        hosszOszlop.setCellValueFactory(new PropertyValueFactory<>("hossz"));
        idopontOszlop.setCellValueFactory(new PropertyValueFactory<>("idopont"));
        moziTabla.setItems(l2);
    }


    private ObservableList<Film> l;
    private ObservableList<Mozi> l2;
    @FXML
    TableView<Mozi> moziTabla;
    @FXML
    TableView<Film> megnezendoTabla;
    @FXML
    TableColumn<Film, String> tipusOszlop2;
    @FXML
    TableColumn<Film, String> cimOszlop2;
    @FXML
    TableColumn<Mozi, String> hosszOszlop;
    @FXML
    TableColumn<Mozi, String> cimOszlop3;
    @FXML
    TableColumn<Mozi, String> idopontOszlop;
    @FXML
    Button kezdo2;
    Scene scene;
    @FXML
    private void switchToPrimary() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(App.loadFXML("primary"));
        stage.setScene(scene);
        stage.setTitle("Kezdőlap");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
        stage.show();
        kezdo2.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        megnTable("select * from film where megnezendo = '+' ");
        mozi("select * from mozi where cim in (select cim from film where megnezendo = '+')");
    }
}
