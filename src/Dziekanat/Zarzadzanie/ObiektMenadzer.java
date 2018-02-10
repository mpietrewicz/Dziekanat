package Dziekanat.Zarzadzanie;

import Dziekanat.ObiektyZarzadzane.Osoba;
import Dziekanat.ObiektyZarzadzane.Student;

import java.io.IOException;
import java.util.ArrayList;

class ObiektMenadzer {

    void wyswietlListeObiektow(ArrayList listaObiektow) {
        int index = 0;
        for (Object obiekt : listaObiektow) {
            System.out.println(index +": " +obiekt);
            index++;
        }
    }

    void nadajDaneOsobowe(Osoba osoba, String kontekst) throws IOException {
        String imie = WierszPolecen.INSTANCJA.wczytajTekst("Podaj imię "+kontekst +"a");
        osoba.setImie(imie);
        String nazwisko = WierszPolecen.INSTANCJA.wczytajTekst("Podaj nazwisko "+kontekst +"a");
        osoba.setNazwisko(nazwisko);
    }

    int wybierzIndexObiektuZListyObiektow(ArrayList listaObiektow, String kontekst) throws IOException {
        wyswietlListeObiektow(listaObiektow);
        return WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Wybierz index " +kontekst +"a, którego chcesz usunąć",
                        0, listaObiektow.size());
    }

}
