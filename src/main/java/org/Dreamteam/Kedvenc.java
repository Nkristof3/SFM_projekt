package org.Dreamteam;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Kedvenc {
    private String cim;
    private IntegerProperty rating = new SimpleIntegerProperty();
    private StringProperty megjegyzes = new SimpleStringProperty();

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getRating() {
        return rating.get();
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public String getMegjegyzes() {
        return megjegyzes.get();
    }

    public StringProperty megjegyzesProperty() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes.set(megjegyzes);
    }
}
