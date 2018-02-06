package Dziekanat;

public class Przedmiot {
    String nazwa;

    public Przedmiot(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }
}
