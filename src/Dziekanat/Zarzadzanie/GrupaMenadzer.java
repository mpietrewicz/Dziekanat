package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Grupa;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Przedmiot;

import java.io.IOException;
import java.util.ArrayList;

public class GrupaMenadzer extends ObiektMenadzer implements Operacje {
    private ArrayList<Grupa> listaGrup = BazaDanych.INSTANCJA.listaGrup;

    @Override
    public Obiekt dodaj() throws IOException {
        String nazwa = wierszPolecen.wczytajTekst("Podaj nazwę grupy");
        Grupa grupa = new Grupa(nazwa);
        PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer();
        grupa.dodajPrzedmiot((Przedmiot) przedmiotMenadzer.dodaj());
        listaGrup.add(grupa);
        return grupa;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaGrup, "grupa");
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaGrup);
    }
}
