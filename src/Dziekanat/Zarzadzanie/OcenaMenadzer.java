package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.*;

import java.io.IOException;
import java.util.ArrayList;

public class OcenaMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Ocena> listaOcen = BazaDanych.INSTANCJA.listaOcen;
    StudentMenadzer studentMenadzer = new StudentMenadzer();

    @Override
    public Obiekt dodaj() throws IOException {
        Przedmiot przedmiot = studentMenadzer.wybierzPrzedmiotStudenta();
        if (przedmiot == null) {
            return null;
        } else {
            int stopien = wierszPolecen.wczytajLiczbeZZakresu("Podaj stopień oceny (2-6)", 1, 6);
            Ocena ocena = new Ocena(stopien);
            przedmiot.setOcena(ocena);
            listaOcen.add(ocena);
            return ocena;
        }
    }

    @Override
    public void usun() throws IOException {
        Przedmiot przedmiot = studentMenadzer.wybierzPrzedmiotStudenta();
        if (przedmiot != null) {
            przedmiot.setOcena(null);
            super.usunElementZListyObiektow(listaOcen, "ocena");
        }
    }

    @Override
    public void wyswietl() {
        for (Student student : BazaDanych.INSTANCJA.listaStudentow) {
            for (Grupa grupa : student.getGrupy()) {
                for (Przedmiot przedmiot : grupa.getPrzedmioty()) {
                    System.out.println("Student: "+student.getImie()+" "+student.getNazwisko()+", ");
                    System.out.print("grupa: "+grupa.getNazwa()+", ");
                    System.out.print("przedmiot: "+przedmiot.getNazwa()+": ocena: "+przedmiot.getOcena().getStopien());
                }
            }
        }
    }
}
