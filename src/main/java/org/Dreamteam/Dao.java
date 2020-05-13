package org.Dreamteam;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public interface Dao {
    ObservableList<Mozi> tableM(String sql);
    ObservableList<Film> tableS(String sql);
    ObservableList<Kedvenc> tableK(String sql);
    void hozzaadas (String tipus, String cim, int evad, int resz, String kedvenc, String megn);
    void torles(String cim);
    void ujKedvenc(String cim);
    void ujMegnezett(String cim);
    void kedvenchezAd (String cim, int rating, String megjegyzes);
    String keres (String cim);
}
