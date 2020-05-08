package org.Dreamteam;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mozi {
    private StringProperty cim = new SimpleStringProperty();
    private Timestamp idopont;
    private Time hossz;

    public String getCim() {
        return cim.get();
    }

    public StringProperty cimProperty() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim.set(cim);
    }

    public Timestamp getIdopont() {
        return idopont;
    }

    public void setIdopont(Timestamp idopont) {
        this.idopont = idopont;
    }

    public Time getHossz() {
        return hossz;
    }

    public void setHossz(Time hossz) {
        this.hossz = hossz;
    }
}
