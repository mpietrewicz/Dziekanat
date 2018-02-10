package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Nauczyciel;

import java.io.IOException;
import java.util.ArrayList;

public class NauczycielMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Nauczyciel> listaNauczycieli = BazaDanych.INSTANCJA.listaNauczycieli;

    @Override
    public void dodaj() throws IOException {
        Nauczyciel nauczyciel = new Nauczyciel();
        nadajDaneOsobowe(nauczyciel,"nauczyciel");
        listaNauczycieli.add(nauczyciel);
    }

    @Override
    public void usun() throws IOException {
        int indexZListyNauczycieliDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaNauczycieli, "nauczyciel");
        listaNauczycieli.remove(indexZListyNauczycieliDoUsuniecia);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaNauczycieli);
    }
}