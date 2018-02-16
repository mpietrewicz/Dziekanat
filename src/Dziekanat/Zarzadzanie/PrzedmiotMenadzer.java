package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Ocena;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;

public class PrzedmiotMenadzer extends ObiektMenadzer implements Operacje {
    private ArrayList<Przedmiot> listaPrzedmiotow = BazaDanych.INSTANCJA.listaPrzedmiotow;
    private ArrayList<Ocena> listaOcen = BazaDanych.INSTANCJA.listaOcen;
    private String kontekst = "przedmiotu";

    @Override
    public Obiekt dodaj() throws IOException {
        String nazwa = wierszPolecen.wczytajTekst("Podaj nazwę "+kontekst);
        int punktyECTS = wierszPolecen.wczytajLiczbeZZakresu("Podaj liczbę punktów ECTS (1-10)", 1, 10);
        Przedmiot przedmiot = new Przedmiot(nazwa, punktyECTS);
        int stopien = wierszPolecen.wczytajLiczbeZZakresu("Podaj stopień oceny (2-6)", 1, 6);
        Ocena ocena = new Ocena(stopien);
        listaOcen.add(ocena);
        przedmiot.setOcena(ocena);
        listaPrzedmiotow.add(przedmiot);
        return przedmiot;
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
}
