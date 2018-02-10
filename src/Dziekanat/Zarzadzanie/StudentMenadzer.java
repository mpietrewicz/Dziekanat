package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Student;

import java.io.IOException;
import java.util.ArrayList;

public class StudentMenadzer extends ObiektMenadzer{
    private ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;

    public void dodajStudenta() throws IOException {
        String imie = WierszPolecen.INSTANCJA.wczytajTekst("Podaj imię studenta");
        String nazwisko = WierszPolecen.INSTANCJA.wczytajTekst("Podaj nazwisko studenta");
        Student student = new Student(imie, nazwisko);
        listaStudentow.add(student);
    }

    public void usunStudenta() throws IOException {
        wyswietlListeObiektow(listaStudentow);
        int indexZListyStudentowDoUsuniecia = WierszPolecen.INSTANCJA.
                wczytajLiczbeZZakresu("Wybierz index studenta, którego chcesz usunąć",
                        0, listaStudentow.size());
        listaStudentow.remove(indexZListyStudentowDoUsuniecia);
    }

    public void wyswietlListeObiektow() {
        super.wyswietlListeObiektow(listaStudentow);
    }

}
