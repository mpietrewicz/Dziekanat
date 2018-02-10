package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Nauczyciel;

import java.io.IOException;
import java.util.ArrayList;

public class NauczycielMenadzer extends ObiektMenadzer{
    private ArrayList<Nauczyciel> listaNauczycieli = BazaDanych.INSTANCJA.listaNauczycieli;

    public void dodajNauczyciela() throws IOException {
        Nauczyciel nauczyciel = new Nauczyciel();
        nadajDaneOsobowe(nauczyciel,"nauczyciel");
        listaNauczycieli.add(nauczyciel);
    }

    public void usunNauczyciela() throws IOException {
        int indexZListyNauczycieliDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaNauczycieli, "nauczyciel");
        listaNauczycieli.remove(indexZListyNauczycieliDoUsuniecia);
    }

    public void wyswietlListeObiektow() {
        super.wyswietlListeObiektow(listaNauczycieli);
    }
}
