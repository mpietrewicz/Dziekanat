package Dziekanat;

import java.util.ArrayList;

public class Grupa implements MenadzerListyPrzedmiotow{
    String nazwa;
    ArrayList<Przedmiot> przedmioty = new ArrayList<Przedmiot>();

    public Grupa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        this.przedmioty.add(przedmiot);
    }

    public void usunPrzedmiot(Przedmiot przedmiot) {
        this.przedmioty.remove(przedmiot);
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "nazwa='" + nazwa + '\'' +
                ", przedmioty=" + przedmioty +
                '}';
    }
}
