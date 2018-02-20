package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Nauczyciel;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class NauczycielMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Nauczyciel> listaNauczycieli = BazaDanych.INSTANCJA.listaNauczycieli;
    private String kontekst = "nauczyciela";
    private ArrayList<Przedmiot> listaPrzedmiotow = BazaDanych.INSTANCJA.listaPrzedmiotow;
    private PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer(false);

    @Override
    public Obiekt dodaj() throws IOException {
        Nauczyciel nauczyciel = new Nauczyciel();
        nadajDaneOsobowe(nauczyciel, kontekst);
        Przedmiot przedmiot = przedmiotMenadzer.wybierzPrzedmiotZListy(listaPrzedmiotow);
        if (przedmiot != null) {
            nauczyciel.dodajPrzedmiot(przedmiot);
        }
        listaNauczycieli.add(nauczyciel);
        return nauczyciel;
    }

    @Override
    public Object edytuj() throws IOException {
        int indexZListyNauczycieli = wybierzIndexObiektuZListyObiektow(listaNauczycieli, kontekst);
        Nauczyciel nauczycielDoEdycji = listaNauczycieli.get(indexZListyNauczycieli);
        nadajDaneOsobowe(nauczycielDoEdycji, kontekst);
        int idOperacji = 0;
        while (idOperacji != 3) {
            super.wyswietlListeObiektow(nauczycielDoEdycji.getPrzedmioty());
            System.out.println("Zarządzanie " + kontekst + ": \n1. Dodaj, 2. Usuń, 3. Wyjdź");
            idOperacji = WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Podaj id operacji",
                    1, 3);
            switch (idOperacji) {
                case 1:
                    nauczycielDoEdycji.dodajPrzedmiot(przedmiotMenadzer.wybierzPrzedmiotZListy(listaPrzedmiotow));
                    break;
                case 2:
                    nauczycielDoEdycji.usunPrzedmiot(przedmiotMenadzer.
                            wybierzPrzedmiotZListy(nauczycielDoEdycji.getPrzedmioty()));
                    break;
            }
        }
        return nauczycielDoEdycji;
    }

}
