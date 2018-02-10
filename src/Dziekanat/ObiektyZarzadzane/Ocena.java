package Dziekanat.ObiektyZarzadzane;

public class Ocena extends Obiekt {
    private int stopien;

    public Ocena(int stopien) {
        this.stopien = stopien;
    }

    public int getStopien() {
        return stopien;
    }

    public void setStopien(int stopien) {
        this.stopien = stopien;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "stopien=" + stopien +
                '}';
    }
}
