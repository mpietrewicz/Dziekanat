package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Ocena;

import java.io.IOException;
import java.util.ArrayList;

public class OcenaMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Ocena> listaOcen = BazaDanych.INSTANCJA.listaOcen;

    @Override
    public Obiekt dodaj() throws IOException {
        int stopien = wierszPolecen.wczytajLiczbeZZakresu("Podaj stopień oceny (2-6)", 1, 6);
        Ocena ocena = new Ocena(stopien);
        listaOcen.add(ocena);
        return ocena;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaOcen, "ocena");
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaOcen);
    }
}
