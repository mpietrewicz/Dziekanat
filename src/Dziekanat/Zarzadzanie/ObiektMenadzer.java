package Dziekanat.Zarzadzanie;

import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Osoba;

import java.io.IOException;
import java.util.ArrayList;

public class ObiektMenadzer implements Operacje{
    WierszPolecen wierszPolecen = WierszPolecen.INSTANCJA;

    boolean wyswietlListeObiektow(ArrayList listaObiektow) {
        int index = 0;
        if (listaObiektow.size() > 0) {
            for (Object obiekt : listaObiektow) {
                System.out.println(index +": " +obiekt);
                index++;
            }
            return true;
        } else {
            System.out.println("Brak elementów do wyświetlenia");
            return false;
        }
    }

    void nadajDaneOsobowe(Osoba osoba, String kontekst) throws IOException {
        String imie = wierszPolecen.wczytajTekst("Podaj imię "+kontekst);
        osoba.setImie(imie);
        String nazwisko = wierszPolecen.wczytajTekst("Podaj nazwisko "+kontekst);
        osoba.setNazwisko(nazwisko);
    }

    int wybierzIndexObiektuZListyObiektow(ArrayList listaObiektow, String kontekst) throws IOException {
        wyswietlListeObiektow(listaObiektow);
        return wierszPolecen.wczytajLiczbeZZakresu("Wybierz index " +kontekst +", którego chcesz usunąć",
                        0, listaObiektow.size()-1);
    }

    @Override
    public Obiekt dodaj() throws IOException {
        return null;
    }

    @Override
    public Object edytuj() throws IOException {
        return null;
    }

    @Override
    public void usun(ArrayList listaObiektow, String kontekst) throws IOException {
        if (listaObiektow.size() > 0) {
            int indexZListyObiektowDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaObiektow, kontekst);
            listaObiektow.remove(indexZListyObiektowDoUsuniecia);
        } else {
            System.out.println("Brak elementów do usunięcia");
        }
    }

    @Override
    public void wyswietl(ArrayList listaObiektow) {
        wyswietlListeObiektow(listaObiektow);
    }

}
