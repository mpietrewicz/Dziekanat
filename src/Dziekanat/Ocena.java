package Dziekanat;

public class Ocena {
    int stopien;

    public Ocena(int stopien) {
        this.stopien = stopien;
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
