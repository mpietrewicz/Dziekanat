package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Ocena;

import java.io.IOException;
import java.util.ArrayList;

public class OcenaMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Ocena> listaOcen = BazaDanych.INSTANCJA.listaOcen;

    @Override
    public void dodaj() throws IOException {
        int stopien = wierszPolecen.wczytajLiczbeZZakresu("Podaj stopień oceny (2-6)", 1, 6);
        Ocena ocena = new Ocena(stopien);
        listaOcen.add(ocena);
    }

    @Override
    public void usun() throws IOException {
        int indexZListyOcenDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaOcen, "ocena");
        listaOcen.remove(indexZListyOcenDoUsuniecia);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaOcen);
    }
}
