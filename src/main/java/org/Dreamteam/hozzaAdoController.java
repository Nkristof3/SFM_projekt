package org.Dreamteam;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class hozzaAdoController {

    @FXML
    TextField typeField;
    @FXML
    TextField titleField;
    @FXML
    TextField seasonNumber;
    @FXML
    TextField episodeNumber;
    @FXML
    TextField favoriteField;
    @FXML
    TextField wlaterField;
    @FXML

    private void hozzaAd() throws SQLException {

        try {
            ConnectDB connectionClass = new ConnectDB();
            Connection connection = connectionClass.getConnection();

            String sql = "INSERT INTO film (Tipus, Cim, Evadok, Reszek, Kedvenc, Megnezendo)" + " values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, typeField.getText());
            preparedStatement.setString(2, titleField.getText());
            preparedStatement.setInt(3, Integer.parseInt(seasonNumber.getText()));
            preparedStatement.setInt(4, Integer.parseInt(episodeNumber.getText()));
            preparedStatement.setString(5, favoriteField.getText());
            preparedStatement.setString(6, wlaterField.getText());

            preparedStatement.executeUpdate();

            connection.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
