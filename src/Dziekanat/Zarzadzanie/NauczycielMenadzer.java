package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Nauczyciel;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;

public class NauczycielMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Nauczyciel> listaNauczycieli = BazaDanych.INSTANCJA.listaNauczycieli;

    @Override
    public Obiekt dodaj() throws IOException {
        Nauczyciel nauczyciel = new Nauczyciel();
        nadajDaneOsobowe(nauczyciel,"nauczyciel");
        PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer();
        nauczyciel.dodajPrzedmiot((Przedmiot) przedmiotMenadzer.dodaj());
        listaNauczycieli.add(nauczyciel);
        return nauczyciel;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaNauczycieli, "nauczyciel");
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaNauczycieli);
    }
}
