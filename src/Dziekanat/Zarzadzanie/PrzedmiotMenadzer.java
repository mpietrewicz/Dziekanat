package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Grupa;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Ocena;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;

public class PrzedmiotMenadzer extends ObiektMenadzer implements Operacje {
    private ArrayList<Przedmiot> listaPrzedmiotow = BazaDanych.INSTANCJA.listaPrzedmiotow;
    private String kontekst = "przedmiotu";

    private boolean czyDodacOcene;

    public PrzedmiotMenadzer(boolean czyDodacOcene) {
        this.czyDodacOcene = czyDodacOcene;
    }

    @Override
    public Obiekt dodaj() throws IOException {
        String nazwa = wierszPolecen.wczytajTekst("Podaj nazwę "+kontekst);
        int punktyECTS = wierszPolecen.wczytajLiczbeZZakresu("Podaj liczbę punktów ECTS (1-10)", 1, 10);
        Przedmiot przedmiot = new Przedmiot(nazwa, punktyECTS);
        if (czyDodacOcene) {
            dodajOceneZaPrzedmiot(przedmiot);
        }
        listaPrzedmiotow.add(przedmiot);
        return przedmiot;
    }

    private void dodajOceneZaPrzedmiot(Przedmiot przedmiot) throws IOException {
        int stopien = wierszPolecen.wczytajLiczbeZZakresu("Podaj stopień oceny (2-6)", 1, 6);
        Ocena ocena = new Ocena(stopien);
        przedmiot.setOcena(ocena);
    }

    @Override
    public Object edytuj() throws IOException {
        int indexZListyPrzedmiotow = wybierzIndexObiektuZListyObiektow(listaPrzedmiotow, kontekst);
        Przedmiot przedmiotDoEdycji = listaPrzedmiotow.get(indexZListyPrzedmiotow);
        przedmiotDoEdycji.setNazwa(wierszPolecen.wczytajTekst("Podaj nazwę "+kontekst));
        przedmiotDoEdycji.setPunktyECTS(wierszPolecen.wczytajLiczbeZZakresu("Podaj liczbę punktów ECTS (1-10)", 1, 10));
        return przedmiotDoEdycji;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaPrzedmiotow, kontekst);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaPrzedmiotow);
    }

    public Przedmiot wybierzPrzedmiotZListy(ArrayList<Przedmiot> lista) throws IOException {
        if (!wyswietlListeObiektow(lista)) {
            System.out.println("Brak przedmiotów nauczyciela");
            return null;
        }
        int indexPrzedmiotu = wierszPolecen.wczytajLiczbeZZakresu("Wybierz index przedmiotu",
                0, lista.size()-1);
        Przedmiot przedmiot = lista.get(indexPrzedmiotu);
        return przedmiot;
    }
}
