package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Grupa;
import Dziekanat.Zarzadzanie.ObiektMenadzer;
import Dziekanat.Zarzadzanie.Operacje;

import java.io.IOException;
import java.util.ArrayList;

public class GrupaMenadzer extends ObiektMenadzer implements Operacje {
    private ArrayList<Grupa> listaGrup = BazaDanych.INSTANCJA.listaGrup;

    @Override
    public void dodaj() throws IOException {
        String nazwa = wierszPolecen.wczytajTekst("Podaj nazwę grupy");
        Grupa grupa = new Grupa(nazwa);
        listaGrup.add(grupa);
    }

    @Override
    public void usun() throws IOException {
        int indexZListyGrupDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaGrup, "grupa");
        listaGrup.remove(indexZListyGrupDoUsuniecia);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaGrup);
    }
}
