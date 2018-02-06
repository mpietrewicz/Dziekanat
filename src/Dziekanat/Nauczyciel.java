package Dziekanat;

import java.util.ArrayList;

public class Nauczyciel extends Osoba implements MenadzerListyPrzedmiotow{
    ArrayList<Przedmiot> przedmioty = new ArrayList<Przedmiot>();

    public Nauczyciel(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        this.przedmioty.add(przedmiot);
    }

    public void usunPrzedmiot(Przedmiot przedmiot) {
        this.przedmioty.remove(przedmiot);
    }

    @Override
    public String toString() {
        return "Nauczyciel{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", przedmioty=" + przedmioty +
                '}';
    }
}
