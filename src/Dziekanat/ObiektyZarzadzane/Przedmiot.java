package Dziekanat.ObiektyZarzadzane;

public class Przedmiot extends Obiekt{
    private String nazwa;
    private int punktyECTS;

    public Przedmiot(String nazwa, int punktyECTS) {
        this.nazwa = nazwa;
        this.punktyECTS = punktyECTS;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getPunktyECTS() {
        return punktyECTS;
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
