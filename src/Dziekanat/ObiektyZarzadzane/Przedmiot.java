package Dziekanat.ObiektyZarzadzane;

public class Przedmiot extends Obiekt{
    private String nazwa;
    private int punktyECTS;
    private Ocena ocena;

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

    public Ocena getOcena() {
        return ocena;
    }

    public void setOcena(Ocena ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        if (ocena != null) {
            return "Przedmiot{" +
                    "nazwa='" + nazwa + '\'' +
                    "ocena='" + ocena.getStopien() + '\'' +
                    ", punktyECTS=" + punktyECTS +
                    '}';
        } else {
            return "Przedmiot{" +
                    "nazwa='" + nazwa + '\'' +
                    ", punktyECTS=" + punktyECTS +
                    '}';
        }
    }
}
