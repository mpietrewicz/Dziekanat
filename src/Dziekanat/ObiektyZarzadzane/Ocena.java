package Dziekanat.ObiektyZarzadzane;

public class Ocena {
    private int stopien;
    private Przedmiot przedmiot;

    public Ocena(int stopien, Przedmiot przedmiot) {
        this.stopien = stopien;
        this.przedmiot = przedmiot;
    }

    public Ocena(int stopien) {
        this.stopien = stopien;
    }

    public int getStopien() {
        return stopien;
    }

    public void setStopien(int stopien) {
        this.stopien = stopien;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "stopien=" + stopien +
                ", przedmiot=" + przedmiot +
                '}';
    }
}