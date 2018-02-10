package Dziekanat.Zarzadzanie;

import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Osoba;

import java.io.IOException;
import java.util.ArrayList;

public class ObiektMenadzer implements Operacje{
    WierszPolecen wierszPolecen = WierszPolecen.INSTANCJA;

    void wyswietlListeObiektow(ArrayList listaObiektow) {
        int index = 0;
        if (listaObiektow.size() > 0) {
            for (Object obiekt : listaObiektow) {
                System.out.println(index +": " +obiekt);
                index++;
            }
        } else {
            System.out.println("Brak elementów do wyświetlenia");
        }
    }

    void nadajDaneOsobowe(Osoba osoba, String kontekst) throws IOException {
        String imie = wierszPolecen.wczytajTekst("Podaj imię "+kontekst +"a");
        osoba.setImie(imie);
        String nazwisko = wierszPolecen.wczytajTekst("Podaj nazwisko "+kontekst +"a");
        osoba.setNazwisko(nazwisko);
    }

    int wybierzIndexObiektuZListyObiektow(ArrayList listaObiektow, String kontekst) throws IOException {
        wyswietlListeObiektow(listaObiektow);
        return wierszPolecen.wczytajLiczbeZZakresu("Wybierz index " +kontekst +"a, którego chcesz usunąć",
                        0, listaObiektow.size()-1);
    }

    @Override
    public Obiekt dodaj() throws IOException {
        return null;
    }

    @Override
    public void usun() throws IOException {

    }

    @Override
    public void wyswietl() {

    }

    public void usunElementZListyObiektow(ArrayList listaObiektow, String kontekst) throws IOException {
        if (listaObiektow.size() > 0) {
            int indexZListyStudentowDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaObiektow, kontekst);
            listaObiektow.remove(indexZListyStudentowDoUsuniecia);
        } else {
            System.out.println("Brak elementów do usunięcia");
        }
    }
}
