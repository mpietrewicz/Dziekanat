package Dziekanat;

public class Ocena {
    int stopien;
    Przedmiot przedmiot;

    public Ocena(int stopien, Przedmiot przedmiot) {
        this.stopien = stopien;
        this.przedmiot = przedmiot;
    }

    public void setStopien(int stopien) {
        this.stopien = stopien;
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
