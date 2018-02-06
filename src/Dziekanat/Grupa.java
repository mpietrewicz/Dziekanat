package Dziekanat;

public class Grupa {
    String nazwa;

    public Grupa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }
}
