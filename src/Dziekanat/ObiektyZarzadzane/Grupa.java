package Dziekanat.ObiektyZarzadzane;

import Dziekanat.MenadzerListyPrzedmiotow;
import java.util.ArrayList;

public class Grupa extends Obiekt implements MenadzerListyPrzedmiotow {
    private String nazwa;
    private ArrayList<Przedmiot> przedmioty = new ArrayList<Przedmiot>();

    public Grupa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
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

    public ArrayList<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "nazwa='" + nazwa + '\'' +
                ", przedmioty=" + przedmioty +
                '}';
    }
}
