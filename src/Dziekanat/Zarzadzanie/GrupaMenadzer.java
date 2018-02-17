package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Grupa;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;

public class GrupaMenadzer extends ObiektMenadzer implements Operacje {
    private ArrayList<Grupa> listaGrup = BazaDanych.INSTANCJA.listaGrup;
    private String kontekst = "grupy";

    @Override
    public Obiekt dodaj() throws IOException {
        String nazwa = wierszPolecen.wczytajTekst("Podaj nazwę "+kontekst);
        Grupa grupa = new Grupa(nazwa);
        PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer(true);
        grupa.dodajPrzedmiot((Przedmiot) przedmiotMenadzer.dodaj());
        listaGrup.add(grupa);
        return grupa;
    }

    @Override
    public Object edytuj() throws IOException {
        int indexZListyGrup = wybierzIndexObiektuZListyObiektow(listaGrup, kontekst);
        Grupa grupaDoEdycji = listaGrup.get(indexZListyGrup);
        grupaDoEdycji.setNazwa(wierszPolecen.wczytajTekst("Podaj nazwę "+kontekst));
        return grupaDoEdycji;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaGrup, kontekst);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaGrup);
    }
}
