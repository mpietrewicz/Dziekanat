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
        PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer(false);
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

    public Grupa wybierzGrupeZListy(ArrayList<Grupa> lista) throws IOException {
        if (!wyswietlListeObiektow(lista)) {
            System.out.println("Brak grup studenta");
            return null;
        }
        int indexGrupy = wierszPolecen.wczytajLiczbeZZakresu("Wybierz index grupy",
                0, lista.size()-1);
        Grupa grupa = lista.get(indexGrupy);
        return grupa;
    }
}
