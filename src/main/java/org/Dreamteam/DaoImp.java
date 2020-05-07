package org.Dreamteam;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DaoImp implements Dao {

    public ObservableList<Film> list;
    public ObservableList<Mozi> list2;

    @Override
    public ObservableList<Mozi> tableM(String sql) {
        ConnectDB connectionClass = new ConnectDB();
        Connection connection = connectionClass.getConnection();
        list2 = FXCollections.observableArrayList();
        try {
            ResultSet vissza = connection.createStatement().executeQuery(sql);

            while(vissza.next()){
                Mozi mozi = new Mozi();
                mozi.setCim(vissza.getString("cim"));
                mozi.setHossz(vissza.getTime("hossz"));
                mozi.setIdopont(vissza.getDate("idopont"));
                list2.add(mozi);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list2;
    }

    @Override
    public ObservableList<Film> tableS(String sql) {
        ConnectDB connectionClass = new ConnectDB();
        Connection connection = connectionClass.getConnection();
        list = FXCollections.observableArrayList();
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
                list.add(film);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public void hozzaadas(String tipus, String cim, int evad, int resz, String kedvenc, String megn) {
        try {
            ConnectDB connectionClass = new ConnectDB();
            Connection connection = connectionClass.getConnection();

            String sql = "INSERT INTO film (Tipus, Cim, Evadok, Reszek, Kedvenc, Megnezendo)" + " values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipus);
            preparedStatement.setString(2, cim);
            preparedStatement.setInt(3, evad);
            preparedStatement.setInt(4, resz);
            preparedStatement.setString(5, kedvenc);
            preparedStatement.setString(6, megn);

            preparedStatement.executeUpdate();

            connection.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void torles(String cim) {
        ConnectDB connectionClass = new ConnectDB();
        Connection connection = connectionClass.getConnection();

        String sql = "DELETE FROM film WHERE Cim = '"+cim+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void ujKedvenc(String cim) {
        ConnectDB connectionClass = new ConnectDB();
        Connection connection = connectionClass.getConnection();

        String sql = "UPDATE film SET kedvenc = '+' WHERE cim = '"+cim+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ujMegnezett(String cim) {
        ConnectDB connectionClass = new ConnectDB();
        Connection connection = connectionClass.getConnection();

        String sql = "UPDATE film SET megnezendo = '+' WHERE cim = '"+cim+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
