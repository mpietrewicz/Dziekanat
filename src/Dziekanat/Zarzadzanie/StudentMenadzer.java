package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Student;

import java.io.IOException;
import java.util.ArrayList;

public class StudentMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;

    @Override
    public void dodaj() throws IOException {
        Student student = new Student();
        nadajDaneOsobowe(student,"student");
        listaStudentow.add(student);
    }

    @Override
    public void usun() throws IOException {
        int indexZListyStudentowDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaStudentow, "student");
        listaStudentow.remove(indexZListyStudentowDoUsuniecia);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaStudentow);
    }

}
