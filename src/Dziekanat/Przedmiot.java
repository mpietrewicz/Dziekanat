package Dziekanat;

import java.util.ArrayList;

public class Przedmiot {
    String nazwa;
    int punktyECTS;

    public Przedmiot(String nazwa, int punktyECTS) {
        this.nazwa = nazwa;
        this.punktyECTS = punktyECTS;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setPunktyECTS(int punktyECTS) {
        this.punktyECTS = punktyECTS;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "nazwa='" + nazwa + '\'' +
                ", punktyECTS=" + punktyECTS +
                '}';
    }
}
