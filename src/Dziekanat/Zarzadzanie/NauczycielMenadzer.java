package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Nauczyciel;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;

public class NauczycielMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Nauczyciel> listaNauczycieli = BazaDanych.INSTANCJA.listaNauczycieli;
    private String kontekst = "nauczyciela";

    @Override
    public Obiekt dodaj() throws IOException {
        Nauczyciel nauczyciel = new Nauczyciel();
        nadajDaneOsobowe(nauczyciel, kontekst);
        PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer(false);
        nauczyciel.dodajPrzedmiot((Przedmiot) przedmiotMenadzer.dodaj());
        listaNauczycieli.add(nauczyciel);
        return nauczyciel;
    }

    @Override
    public Object edytuj() throws IOException {
        int indexZListyNauczycieli = wybierzIndexObiektuZListyObiektow(listaNauczycieli, kontekst);
        Nauczyciel nauczycielDoEdycji = listaNauczycieli.get(indexZListyNauczycieli);
        nadajDaneOsobowe(nauczycielDoEdycji, kontekst);
        return nauczycielDoEdycji;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaNauczycieli, kontekst);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaNauczycieli);
    }
}
