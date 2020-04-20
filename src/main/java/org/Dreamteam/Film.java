package org.Dreamteam;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Film {
    private final StringProperty tipus = new SimpleStringProperty();
    private final StringProperty cim = new SimpleStringProperty();
    private final IntegerProperty reszek = new SimpleIntegerProperty();
    private final IntegerProperty evadok = new SimpleIntegerProperty();
    private final StringProperty kedvenc = new SimpleStringProperty();
    private final StringProperty megnezendo = new SimpleStringProperty();
    public String getCim() {
        return cim.get();
    }

    public String getTipus() {
        return tipus.get();
    }

    public StringProperty tipusProperty() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus.set(tipus);
    }

    public int getEvadok() {
        return evadok.get();
    }

    public IntegerProperty evadokProperty() {
        return evadok;
    }

    public void setEvadok(int evadok) {
        this.evadok.set(evadok);
    }

    public StringProperty cimProperty() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim.set(cim);
    }

    public int getReszek() {
        return reszek.get();
    }

    public IntegerProperty reszekProperty() {
        return reszek;
    }

    public void setReszek(int reszek) {
        this.reszek.set(reszek);
    }

    public String getKedvenc() {
        return kedvenc.get();
    }

    public StringProperty kedvencProperty() {
        return kedvenc;
    }

    public void setKedvenc(String kedvenc) {
        this.kedvenc.set(kedvenc);
    }

    public String getMegnezendo() {
        return megnezendo.get();
    }

    public StringProperty megnezendoProperty() {
        return megnezendo;
    }

    public void setMegnezendo(String megnezendo) {
        this.megnezendo.set(megnezendo);
    }
}
